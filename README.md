# StandBy

A calm clock and system screensaver for Android phones and Android TV — inspired by Apple StandBy.

Solar digits, liquid-glass settings, night mode from the light sensor, and almost no chrome.

---

## Features

| Feature | Detail |
|--------|--------|
| **Solar clock** | Hand-tuned SVG digits; fixed cells so only the changing digit animates |
| **Night Mode** | Dims with the ambient light sensor (time fallback) |
| **Next alarm** | System next alarm; optional On/Off |
| **Date** | Optional, independent of alarm |
| **12 / 24h** | Auto (system) or forced |
| **Colors** | 10 curated palettes; optional hourly auto-rotate |
| **Size** | S / M / L |
| **Haptics** | Light ticks on color / settings (phones) |
| **OLED care** | Very slow pixel drift |
| **True screensaver** | Android DreamService — no options UI in dream mode |

---

## Install & use

### Preview (customize)
1. Install the APK.
2. Open **StandBy**.
3. Tap **+** (or press **OK** on a TV remote) for Settings and Colors.

### System screensaver
1. **Settings → Display → Screen saver** (wording varies by device).
2. Choose **StandBy**.
3. Start now / when charging / when docked — as your OEM allows.

Best on many phones: **landscape + charging / dock**.

---

## Settings

| Setting | Options |
|---------|---------|
| Seconds | On / Off |
| Time format | Auto · 24h · 12h |
| Date | On / Off |
| Alarm | On / Off |
| Night Mode | On / Off |
| Auto Color | On / Off |
| Size | S · M · L |

Stored in native SharedPreferences (localStorage fallback in WebView).

---

## Build

```bash
./gradlew assembleDebug
# APK: app/build/outputs/apk/debug/app-debug.apk
```

**minSdk 21** · **targetSdk 35** · no third-party libraries.

---

## Architecture

```
PreviewActivity      → Customize (WebView, options visible)
StandbyDreamService  → System screensaver (WebView, no chrome)
StandbyBridge        → Light sensor, 12/24h, next alarm, haptics, prefs
assets/clock.html    → UI + clock engine
```

---

## Design notes

- Defaults should look right with zero configuration.
- Options stay few and purposeful.
- Screensaver never shows the customize button.
- Digit frame stays fixed; only the glyph that changes is replaced.

---

## Version

**3.14** — Spacing locked (SLOT 68 / GAP -14); dead code removed; docs updated.
