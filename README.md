# StandBy

**Time, beautifully still.**

A calm, minimal clock and system screensaver for Android phones and Android TV.

Solar-inspired digits. Ambient night mode. Carefully curated colors. Nothing unnecessary.

[**↓ Download StandBy v3.14 (APK)**](https://github.com/MeraniBadreddine/StandBy/raw/refs/heads/main/StandBy-v3.14.apk)

*Android 5.0+ · Phones & Android TV · No third-party libraries*

---

## Overview

StandBy transforms your screen into a quiet, beautifully designed clock — whether you're charging your phone, using a dock, or relaxing in front of your TV.

## Features

| Feature | Description |
|---|---|
| **Solar clock** | Custom SVG digits with smooth, precise transitions |
| **Ambient night mode** | Responds to the light sensor, with a time-based fallback |
| **Next alarm** | Displays your system's next scheduled alarm |
| **Flexible date & time** | Optional date, automatic or manual 12/24-hour format |
| **Curated colors** | 10 palettes with optional hourly color rotation |
| **Adjustable sizing** | Small, medium, and large |
| **Subtle haptics** | Light feedback when changing colors or settings |
| **OLED care** | Very slow pixel drift |
| **Native screensaver** | Android DreamService integration without customization controls |

## Download & setup

### 1. Install

Download the APK using the link above and install it on your Android device. If prompted, allow installation from your chosen source.

### 2. Customize

Open **StandBy**, then tap **+** or press **OK** on your TV remote to access settings and colors.

### 3. Enable the system screensaver

Open your device's **Settings → Display → Screen saver**, select **StandBy**, and choose when it should start. Available options depend on your device.

**Recommended:** Landscape orientation while charging or docked.

## Settings

| Option | Available values |
|---|---|
| Seconds | On / Off |
| Time format | System / 24-hour / 12-hour |
| Date | On / Off |
| Alarm | On / Off |
| Night mode | On / Off |
| Automatic colors | On / Off |
| Clock size | Small / Medium / Large |

Settings are stored locally using native Android preferences, with a WebView local-storage fallback.

## Build from source

Requirements: Android SDK and a compatible Java development environment.

```bash
./gradlew assembleDebug
```

Generated APK:

```text
app/build/outputs/apk/debug/app-debug.apk
```

## Architecture

```text
PreviewActivity
└── Customizable clock interface

StandbyDreamService
└── Native Android screensaver

StandbyBridge
└── Light sensor, time format, alarms,
    haptics and preferences

assets/clock.html
└── Clock interface and rendering engine
```

## Design principles

- Beautiful defaults, with no setup required.
- Minimal controls, each with a clear purpose.
- No customization controls inside the screensaver.
- Stable digit frames, with only changing glyphs animated.
- A quiet interface designed to stay out of the way.

## Technical details

| Property | Value |
|---|---|
| Version | 3.14 |
| Minimum Android version | Android 5.0 (API 21) |
| Target SDK | 35 |
| Dependencies | No third-party libraries |

---

*StandBy is an independent project and is not affiliated with or endorsed by Apple Inc.*

**StandBy · A little more calm on your screen.**