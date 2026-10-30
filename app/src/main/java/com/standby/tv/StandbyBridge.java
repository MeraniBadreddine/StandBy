package com.standby.tv;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import android.provider.Settings;
import android.text.format.DateFormat;
import android.webkit.JavascriptInterface;
import android.app.AlarmManager;
import android.app.AlarmManager.AlarmClockInfo;

/**
 * Native bridge: light sensor, system format, next alarm, haptics, settings.
 * FIX: the sensor listener is now registered/unregistered with the window
 * lifecycle (pause()/resume()) so it never runs in the background.
 */
public final class StandbyBridge implements SensorEventListener {

    private static final String PREFS = "standby_prefs";

    private final Context context;
    private final SharedPreferences prefs;
    private final SensorManager sensorManager;
    private Sensor lightSensor;
    private boolean sensorRegistered = false;
    private float lastLux = 100f;

    public StandbyBridge(Context context) {
        this.context = context.getApplicationContext();
        this.prefs = this.context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        this.sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager != null) {
            lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        }
        resume(); // register on creation (window is about to be visible)
    }

    /** Call from onPause() / onDreamingStopped(): stops the light sensor. */
    public void pause() {
        if (sensorManager != null && sensorRegistered) {
            sensorManager.unregisterListener(this);
            sensorRegistered = false;
        }
    }

    /** Call from onResume() / onDreamingStarted(): restarts the light sensor. */
    public void resume() {
        if (sensorManager != null && lightSensor != null && !sensorRegistered) {
            sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
            sensorRegistered = true;
        }
    }

    public void destroy() {
        pause();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            lastLux = event.values[0];
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}

    @JavascriptInterface
    public float getLux() {
        return lastLux;
    }

    @JavascriptInterface
    public boolean is24Hour() {
        return DateFormat.is24HourFormat(context);
    }

    @JavascriptInterface
    public String getNextAlarm() {
        try {
            AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            if (am == null) return "";
            AlarmClockInfo info = am.getNextAlarmClock();
            if (info == null) return "";
            long trigger = info.getTriggerTime();
            // Latin digits keep the alarm readable in every locale,
            // matching the clock face style.
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
                    is24Hour() ? "HH:mm" : "h:mm",
                    java.util.Locale.US
            );
            return sdf.format(new java.util.Date(trigger));
        } catch (Exception e) {
            return "";
        }
    }

    /* ===== Activation: is StandBy set as the system screensaver? ===== */

    @JavascriptInterface
    public boolean isDreamActive() {
        try {
            /* The system may store the shorthand or the fully-qualified
               component name — match either, via two known keys. */
            String comps = Settings.Secure.getString(
                    context.getContentResolver(), "screensaver_components");
            String def = Settings.Secure.getString(
                    context.getContentResolver(), "screensaver_default_component");
            return (comps != null && comps.contains("StandbyDreamService"))
                    || (def != null && def.contains("StandbyDreamService"));
        } catch (Exception e) {
            return false;
        }
    }

    /** Deep link straight to the system screensaver settings (one tap). */
    @JavascriptInterface
    public void openDreamSettings() {
        try {
            context.startActivity(new Intent(Settings.ACTION_DREAM_SETTINGS)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        } catch (Exception e) {
            try {
                context.startActivity(new Intent(Settings.ACTION_SETTINGS)
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            } catch (Exception ignored) {}
        }
    }

    /* ===== Smart battery row (no permission needed: sticky BATTERY_CHANGED intent) ===== */

    @JavascriptInterface
    public int getBatteryLevel() {
        try {
            Intent i = context.registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
            if (i == null) return -1;
            int level = i.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = i.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            if (level < 0 || scale <= 0) return -1;
            return Math.round(level * 100f / scale);
        } catch (Exception e) {
            return -1;
        }
    }

    @JavascriptInterface
    public boolean isCharging() {
        try {
            Intent i = context.registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
            if (i == null) return false;
            int status = i.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            return status == BatteryManager.BATTERY_STATUS_CHARGING
                    || status == BatteryManager.BATTERY_STATUS_FULL;
        } catch (Exception e) {
            return false;
        }
    }

    /** Light selection tick — no-op if vibrator missing. */
    @JavascriptInterface
    public void hapticTick() {
        vibrate(12, VibrationEffect.EFFECT_TICK);
    }

    /** Slightly stronger confirmation (e.g. opening sheet). */
    @JavascriptInterface
    public void hapticClick() {
        vibrate(18, VibrationEffect.EFFECT_CLICK);
    }

    private void vibrate(int ms, int predefined) {
        try {
            Vibrator vibrator = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                VibratorManager vm = (VibratorManager) context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE);
                if (vm != null) vibrator = vm.getDefaultVibrator();
            } else {
                vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
            }
            if (vibrator == null || !vibrator.hasVibrator()) return;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                vibrator.vibrate(VibrationEffect.createPredefined(predefined));
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(ms, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                vibrator.vibrate(ms);
            }
        } catch (Exception ignored) {
        }
    }

    /* ===== Persistent settings (SharedPreferences) ===== */

    @JavascriptInterface
    public void saveSetting(String key, String value) {
        if (key == null) return;
        prefs.edit().putString(key, value != null ? value : "").apply();
    }

    @JavascriptInterface
    public String getSetting(String key, String defaultValue) {
        if (key == null) return defaultValue != null ? defaultValue : "";
        if (!prefs.contains(key)) {
            return defaultValue != null ? defaultValue : "";
        }
        return prefs.getString(key, defaultValue != null ? defaultValue : "");
    }

    @JavascriptInterface
    public void saveBool(String key, boolean value) {
        if (key == null) return;
        prefs.edit().putBoolean(key, value).apply();
    }

    @JavascriptInterface
    public boolean getBool(String key, boolean defaultValue) {
        if (key == null) return defaultValue;
        return prefs.getBoolean(key, defaultValue);
    }

    @JavascriptInterface
    public void saveInt(String key, int value) {
        if (key == null) return;
        prefs.edit().putInt(key, value).apply();
    }

    @JavascriptInterface
    public int getInt(String key, int defaultValue) {
        if (key == null) return defaultValue;
        return prefs.getInt(key, defaultValue);
    }
}