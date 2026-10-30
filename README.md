<div align="center">

# StandBy
### Time, elevated.

A calm, beautifully considered ambient clock experience for Android phones.  
Simplicity by design. Perfection by detail.

<br>

[![Download v4.0](https://img.shields.io/badge/Download-StandBy_v4.0_APK-0A84FF?style=for-the-badge&logo=apple&logoColor=white)]([https://github.com/MeraniBadreddine/StandBy/releases/tag/v4.0](https://github.com/MeraniBadreddine/StandBy/releases/download/v4.0/app-debug.apk))

**Version 4.0** &nbsp;·&nbsp; **Android Phone Edition** &nbsp;·&nbsp; **Native Performance**

<br>

---

### PURE TIME. ZERO DISTRACTION.

</div>

StandBy reimagines what your Android phone can become when it is not in active use. Place it on your nightstand, desk, or charging stand, and transform idle moments into a calm, atmospheric clock display.  
Designed exclusively for phones, StandBy combines carefully crafted vector typography, smooth digit transitions, and intelligent screen dimming.  

*Every pixel is deliberate. Every motion has a purpose. Just pure, essential time.*

---

## Crafted with Precision

* **Proportions in Harmony**  
  Featuring bespoke, solar-inspired SVG clock typography with carefully refined proportions, spacing, and optical alignment. The clock maintains its visual structure while individual digits transition smoothly.
* **Intelligent Atmosphere**  
  StandBy adapts to ambient lighting through the device's light sensor, with a scheduled nighttime mode as a fallback. Gradual dimming and hysteresis help prevent abrupt brightness changes.
* **Personalized Elegance**  
  Choose from 10 curated color palettes, adjust the clock size across Small, Medium, and Large, and switch between 12-hour and 24-hour formats. Enable seconds, display the date and next alarm, and customize additional display preferences.
* **Designed for OLED**  
  Subtle screen-position shifting helps reduce the risk of image retention during extended display sessions. Optimized rendering and lightweight animations help keep the experience efficient.
* **A Native Android Experience**  
  Built around Android's native DreamService architecture, StandBy provides a system screensaver alongside an interactive preview and customization experience.

---

## Design Specifications

| Specification | Implementation |
| :--- | :--- |
| **Typography** | Custom SVG clock glyphs |
| **Adaptive Lighting** | Ambient light sensor and scheduled night mode |
| **Color Palette** | 10 curated color palettes |
| **Chronometry** | System-synchronized 12/24-hour clock |
| **Clock Scale** | Small, Medium, and Large |
| **OLED Consideration** | Subtle pixel-position drift |
| **Motion** | Smooth digit transitions and optimized updates |
| **Interface** | Multilingual settings with Arabic RTL support |
| **Screensaver Engine** | Native Android DreamService |
| **Native Integration** | Battery, charging state, next alarm, and haptics |

---

## Getting Started

1. **Download**  
   Get the latest `v4.0` APK directly from the [GitHub Releases Page](https://github.com/MeraniBadreddine/StandBy/releases/tag/v4.0) and install it on your Android phone.
2. **Customize**  
   Open StandBy to preview the clock and access its settings. Choose your preferred color palette, clock size, time format, and display options.
3. **Activate**  
   Open your Android system settings and navigate to:  
   `Settings → Display → Screen saver`  
   Select StandBy and configure when your phone should activate the screensaver.  

*For the best experience, place your phone on a stable stand while charging.*

---

## Engineering Philosophy

* **Invisible Interface:** The clock remains the focus; controls appear only when needed.
* **Purposeful Control:** Every setting has a clear function.
* **Fluid Motion:** Digit positions remain visually anchored while changing smoothly.
* **Adaptive Comfort:** Gradual dimming creates a more comfortable nighttime display.
* **Hardware Awareness:** Sensor-driven behavior and subtle screen movement help make extended use more considerate of the display.

---

## Architecture

StandBy follows a lightweight architecture combining an optimized HTML rendering layer with a native Android bridge.

```text
PreviewActivity
└── Interactive phone preview and customization

StandbyDreamService
└── Native Android system screensaver

StandbyBridge
└── Sensors, system alarms, battery, haptics and native state

assets/clock.html
└── Clock rendering, animations, themes and settings
```

---

## Build from Source

```bash
git clone https://github.com/MeraniBadreddine/StandBy.git
cd StandBy
gradle assembleDebug
```

**Built APK location:**  
`app/build/outputs/apk/debug/app-debug.apk`

---

## Environment Specification

| Parameter | Value |
| :--- | :--- |
| **Version** | 4.0 |
| **Version Code** | 36+ |
| **Minimum Android** | Android 7.0 (API Level 24) |
| **Compile SDK** | API Level 35 |
| **Target SDK** | API Level 35 |
| **Java Compatibility** | Java 11 |
| **Dependencies** | No third-party libraries |

---

<div align="center">

### Less interface. More atmosphere.

**StandBy · Phone Edition · Version 4.0**  
<sub>An independent open-source project. Not affiliated with or endorsed by Apple Inc.</sub>

</div>
