<div align="center">

# StandBy

### Time, elevated.

A calm, beautifully considered ambient experience for Android.

Simplicity by design. Perfection by detail.

<br>

<a href="https://github.com/MeraniBadreddine/StandBy/raw/refs/heads/main/StandBy-v3.14.apk"><strong>↓ &nbsp; Download StandBy 3.14</strong></a>

**Version 3.14** &nbsp; · &nbsp; Android &nbsp; · &nbsp; Pure Native Performance

<br>

</div>

---

<div align="center">

### **PURE TIME. ZERO DISTRACTION.**

</div>

StandBy reimagines what your Android display can be when it’s not in active use. Whether placed on your nightstand, resting on your desk, docked on a charger, or elevated on your TV—StandBy transforms quiet moments into a seamless, atmospheric display.

Every pixel is deliberate. Every motion is fluid. Just pure, essential time.

---

## Crafted with Precision

### **Proportions in Harmony**
Featuring bespoke, solar-inspired SVG typography engineered with meticulous kerning and optical alignment. The result is a clock face that breathes naturally in any room, at any distance.

### **Intelligent Atmosphere**
StandBy seamlessly responds to your environment. Utilizing native ambient light hardware sensors, the display dynamically dims into an ultra-low-brightness night mode, preserving your sleep environment while ensuring instant legibility.

### **Personalized Elegance**
Select from 10 hand-curated color palettes. Fine-tune clock scale, toggle 12/24-hour modes, or customize secondary indicators like date, seconds, and upcoming alarms with effortless fluidity.

### **Uncompromised Integration**
Deeply integrated with Android’s native `DreamService` architecture. StandBy operates cleanly in the background as a true screensaver—uncluttered by user controls until invoked.

---

## Design Specifications

| Spec | Implementation |
|:--|:--|
| **Typography** | Bespoke vector-rendered glyphs |
| **Adaptive Lighting** | Ambient hardware sensing with temporal fallback |
| **Color Science** | 10 calibrated ambient palettes |
| **Chronometry** | System-synced, 12-hour or 24-hour precision |
| **Scale** | Small, Medium, or Large optical layouts |
| **OLED Preservation** | Micro-subpixel drift prevention algorithm |
| **Haptics** | Subtle, tactile feedback engine |
| **Screensaver Engine** | Native Android `DreamService` integration |

---

## Getting Started

### **01. Download**
Obtain the latest signed APK directly from the release button at the top of this page.

### **02. Customize**
Launch StandBy and tap **+** (or press **OK** on your TV remote) to reveal the intuitive customization overlay.

### **03. Activate**
Navigate to **Settings → Display → Screen saver** on your Android device, select **StandBy**, and specify your preferred idle trigger.

*Pro-tip: Place your device in landscape mode on a wireless charger for the ultimate bedside setup.*

---

## Engineering Philosophy

- **Invisible Interface:** The best interface is one you never have to think about.
- **Purposeful Control:** Every toggle serves a distinct, meaningful function.
- **Fluid Motion:** Digit positions remain anchored while changing glyphs animate smoothly.
- **Hardware Protection:** Subtle micro-drift algorithms protect OLED displays against image retention.

---

## Architecture

StandBy is built on a lightweight, zero-dependency architecture pairing an optimized web layer with a high-performance native Android bridge.

```text
PreviewActivity
└── Interactive preview & customization matrix

StandbyDreamService
└── High-performance native Android screensaver

StandbyBridge
└── Native sensor pipeline, system alarms, haptics & state

assets/clock.html
└── Hardware-accelerated rendering engine
```

### Build from Source

```bash
./gradlew assembleDebug
```

Built binary path:
```text
app/build/outputs/apk/debug/app-debug.apk
```

| Environment | Specification |
|:--|:--|
| **Version** | 3.14 |
| **Minimum API** | Android 5.0 (API Level 21) |
| **Target SDK** | API Level 35 |
| **Dependencies** | 0 Third-party libraries |

---

<div align="center">

**Less interface. More atmosphere.**

StandBy · Version 3.14

<sub>An independent open-source project. Not affiliated with or endorsed by Apple Inc.</sub>

</div>