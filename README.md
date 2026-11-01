 <div align="center">

# StandBy
### Time, elevated.

A refined ambient clock experience for Android phones.  
Time in its purest form. Simplicity by design.

<br>

[![Download v4.0.2](https://img.shields.io/badge/Download-v4.0.2-0A84FF?style=for-the-badge&logo=android&logoColor=white)](https://github.com/MeraniBadreddine/StandBy/releases/download/v4.0.2/app-release.apk)

[![Version](https://img.shields.io/badge/Version-4.0.2-30D158?style=flat-square)](https://github.com/MeraniBadreddine/StandBy/releases/tag/v4.0.2)
![Platform](https://img.shields.io/badge/Platform-Android-0A84FF?style=flat-square)
![Project](https://img.shields.io/badge/Project-Open%20Source-8E8E93?style=flat-square)

**Version 4.0.2** &nbsp;·&nbsp; **Native Android** &nbsp;·&nbsp; **Phone Edition**

<br>

---

### PURE TIME. ZERO DISTRACTION.

</div>

StandBy transforms an idle Android phone into a refined ambient clock. Designed for nightstands, desks, and charging stands, it combines carefully crafted clock typography, fluid transitions, adaptive brightness, and native Android screensaver integration.

Built to remain visually calm while providing meaningful customization, StandBy brings together a lightweight HTML rendering layer and native Android capabilities.

*Less interface. More atmosphere. Time, with intention.*

---

## Crafted with Precision

- **A Distinctive Clock Experience**  
  A bespoke, solar-inspired SVG clock design with carefully balanced proportions, optical alignment, and spacing. Individual digits transition smoothly while maintaining their visual positions and structure.

- **Intelligent Ambient Lighting**  
  Uses the device's ambient light sensor to adapt display brightness to surrounding conditions. Gradual brightness transitions and hysteresis help prevent sudden changes. A scheduled nighttime mode provides an alternative when automatic light adaptation is unavailable or not preferred.

- **Personalized Color Palettes**  
  Explore 10 curated color palettes designed to create different visual atmospheres while preserving the clock's identity and readability.

- **Flexible Clock Sizing**  
  Select Small, Medium, or Large clock sizes to suit different phone screens, viewing distances, and placement preferences.

- **12-Hour and 24-Hour Formats**  
  Choose the time format that matches your preference, with optional seconds for a more detailed time display.

- **Useful Information at a Glance**  
  Customize additional display information, including the date and next alarm, to keep essential details accessible without cluttering the screen.

- **Smooth and Purposeful Motion**  
  Digit transitions and visual updates are optimized to maintain a fluid experience while avoiding unnecessary rendering work.

- **OLED Display Consideration**  
  Subtle screen-position shifting helps reduce the risk of prolonged static-image exposure. The clock is designed to remain visually restrained during extended sessions.

- **Native Android Screensaver**  
  Integrates with Android's DreamService architecture, allowing StandBy to operate as a system screensaver rather than simply functioning as an ordinary clock screen.

- **Interactive Preview and Settings**  
  Preview the clock and adjust its appearance through the application's interactive interface before activating the system screensaver.

- **Multilingual Interface**  
  Includes multilingual settings with Arabic right-to-left interface support.

---

## Design Specifications

| Specification | Implementation |
| :--- | :--- |
| **Clock Rendering** | HTML and custom SVG clock glyphs |
| **Clock Design** | Solar-inspired typography |
| **Time Format** | 12-hour and 24-hour |
| **Seconds Display** | Optional seconds |
| **Date Display** | Customizable date visibility |
| **Next Alarm** | Optional next-alarm information |
| **Color Palettes** | 10 curated palettes |
| **Clock Scale** | Small, Medium, and Large |
| **Adaptive Lighting** | Ambient light sensor |
| **Night Mode** | Scheduled nighttime mode |
| **Brightness Control** | Gradual dimming and hysteresis |
| **Motion** | Smooth digit transitions |
| **OLED Consideration** | Subtle pixel-position shifting |
| **System Integration** | Native Android DreamService |
| **Interactive Preview** | Native preview activity |
| **Native Bridge** | Sensors and Android system information |
| **Interface** | Multilingual settings with Arabic RTL support |
| **Dependencies** | No third-party libraries |

---

## Getting Started

1. **Download**  
   Download the signed Android APK from the official GitHub release.

   [Download StandBy v4.0.2](https://github.com/MeraniBadreddine/StandBy/releases/download/v4.0.2/app-release.apk)

2. **Install**  
   Open the downloaded APK and follow the Android installation instructions. You may need to allow installation from your browser or file manager.

3. **Customize**  
   Open StandBy to access the interactive preview and settings. Select your preferred palette, clock size, time format, and additional display options.

4. **Activate the Screensaver**  
   Open your Android system settings and navigate to:

   `Settings → Display → Screen saver`

   Select StandBy and configure when the screensaver should activate.

5. **Enjoy the Ambient Experience**  
   Place your phone on a stable stand, preferably while charging, and let StandBy transform its idle display into an ambient clock.

*System menu names and screensaver availability may vary depending on the Android manufacturer and device.*

---

## Engineering Philosophy

- **Clarity First:** Time remains the primary focus, without unnecessary interface elements.
- **Purposeful Customization:** Every setting contributes to a meaningful aspect of the clock experience.
- **Fluid Motion:** Digit transitions preserve visual stability and avoid distracting movement.
- **Adaptive Comfort:** Gradual dimming and nighttime scheduling support comfortable viewing in different lighting conditions.
- **Display Awareness:** Subtle position shifting helps reduce prolonged static-image exposure.
- **Native Integration:** Android system capabilities are used directly through native components.
- **Lightweight Architecture:** A focused rendering layer and native bridge keep the application simple and efficient.

---

## Architecture

StandBy combines a lightweight HTML-based clock interface with native Android components.

```text
PreviewActivity
└── Interactive clock preview
    └── Settings and customization

StandbyDreamService
└── Native Android system screensaver
    └── Screensaver lifecycle and display

StandbyBridge
└── Native Android integration
    ├── Ambient light sensor
    ├── Battery and charging state
    ├── System alarms
    ├── Haptic feedback
    └── Native application state

assets/
└── clock.html
    ├── SVG clock rendering
    ├── Digit transitions
    ├── Color palettes
    ├── Clock sizing
    ├── Time and date formatting
    ├── Brightness adaptation
    └── Display preferences
```

---

## Build from Source

Clone the official repository:

```bash
git clone https://github.com/MeraniBadreddine/StandBy.git
cd StandBy
```

Build the debug version:

```bash
gradle assembleDebug
```

Build the release version:

```bash
gradle :app:assembleRelease
```

**Debug APK location:**

`app/build/outputs/apk/debug/app-debug.apk`

**Signed Release APK location:**

`app/build/outputs/apk/release/app-release.apk`

Release builds require the dedicated StandBy signing key and corresponding local signing configuration. Never publish or commit the private keystore or its passwords.

---

## Environment Specification

| Parameter | Value |
| :--- | :--- |
| **Version** | 4.0.2 |
| **Version Code** | 41 |
| **Application ID** | `com.standby.phone` |
| **Namespace** | `com.standby.tv` |
| **Minimum Android** | Android 7.0 (API Level 24) |
| **Compile SDK** | API Level 35 |
| **Target SDK** | API Level 35 |
| **Java Compatibility** | Java 11 |
| **Build System** | Gradle |
| **Rendering Layer** | HTML / SVG |
| **Native Integration** | Android Java APIs |
| **Dependencies** | No third-party libraries |

---

## Quality and Verification

The v4.0.2 release has successfully passed:

- Android Gradle release build.
- APK signature verification using APK Signature Scheme v2.
- Release certificate verification.
- Source project compilation.
- Dedicated StandBy signing-key configuration.

**Release signing identity:** Dedicated StandBy RSA 2048-bit key.

*Note: v4.0.2 uses a new signing identity. Existing installations signed with a different key must be uninstalled before installing this release.*

---

<div align="center">

### Less interface. More atmosphere.

**StandBy · Android Phone Edition · Version 4.0.2**

<sub>An independent open-source project. Not affiliated with or endorsed by Apple Inc.</sub>

</div>
