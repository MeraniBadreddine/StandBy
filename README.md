 <div align="center">

# StandBy

### Time, beautifully still.

A quiet, thoughtfully designed clock for Android.

Minimal by design. Beautiful by default.

<br>

<a href="https://github.com/MeraniBadreddine/StandBy/raw/refs/heads/main/StandBy-v3.14.apk"><strong>↓ &nbsp; Download StandBy</strong></a>

**Version 3.14** &nbsp; · &nbsp; Android &nbsp; · &nbsp; Free

<br>

</div>

---

<div align="center">

**TIME, WITHOUT THE NOISE.**

</div>

StandBy turns your Android screen into a calm, always-ready clock. Designed for your desk, your bedside, your charging stand, or your TV.

No clutter. No unnecessary controls. Just time, presented with care.

## The experience

### A clock with room to breathe

Custom solar-inspired digits, carefully tuned spacing, and subtle transitions create a display that feels considered rather than busy.

### Light sets the mood

Ambient-light-aware night mode helps the clock adapt to its surroundings, with a time-based fallback when a light sensor is unavailable.

### Your screen, your way

Choose from curated color palettes, adjust the clock size, switch between 12-hour and 24-hour time, and decide what information appears.

### More than a preview

StandBy integrates with Android's native screensaver system, so the clock can run without its customization controls.

---

## Made for everyday moments

| Detail | Experience |
|:--|:--|
| Clock | Custom SVG digits |
| Night mode | Ambient light sensor or time fallback |
| Color | 10 curated palettes |
| Time | System, 12-hour or 24-hour |
| Display | Small, medium or large |
| Personalization | Date, seconds and alarm visibility |
| Screen protection | Very slow pixel drift |
| Feedback | Subtle haptics on supported phones |
| Screensaver | Native Android DreamService |

## Get started

**01 — Install**

Download the APK using the button at the top of this page. If Android asks for permission to install apps from your chosen source, review and allow it as appropriate.

**02 — Make it yours**

Open StandBy and tap **+**, or press **OK** on your TV remote, to access the available settings and colors.

**03 — Set it as your screensaver**

Open your Android device's **Settings → Display → Screen saver**, select StandBy, and choose when the screensaver should start. The available options depend on your device.

*Tip: Landscape orientation while charging or docked makes a great bedside setup.*

---

## Thoughtful by default

- The clock should look right without configuration.
- Every setting should have a clear purpose.
- The screensaver should remain free of customization controls.
- Digit positions stay fixed while changing glyphs animate.
- OLED pixel drift remains extremely subtle.

## For developers

StandBy uses a lightweight Android architecture with a WebView-based clock interface and a native bridge.

```text
PreviewActivity
└── Clock preview and customization

StandbyDreamService
└── Native Android screensaver

StandbyBridge
└── Sensors, alarms, time format,
    haptics and preferences

assets/clock.html
└── Clock interface and rendering
```

### Build locally

Requirements: Android SDK and a compatible Java development environment.

```bash
./gradlew assembleDebug
```

The generated APK is located at:

```text
app/build/outputs/apk/debug/app-debug.apk
```

| Technical detail | Value |
|:--|:--|
| Version | 3.14 |
| Minimum Android | 5.0 · API 21 |
| Target SDK | 35 |
| Third-party libraries | None |

---

<div align="center">

**Less interface. More atmosphere.**

StandBy · Version 3.14

<sub>An independent project. Not affiliated with or endorsed by Apple Inc.</sub>

</div>