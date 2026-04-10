# Play Store Submission — Mahjong Slice (切牌)

> Single source of truth for the Google Play Console submission. Every asset
> referenced below lives in this directory.

---

## 1. APK file

`mahjong-slice-1.0.0-unsigned.apk` — 6.9 MB, release build, ProGuard +
resource shrinking enabled. **Unsigned** because no upload keystore is
configured in `local.properties`. Two paths to a signed artifact:

- **Recommended:** upload the AAB below and let Play App Signing manage the
  signing key. You only need to provide an *upload* key.
- **Manual:** generate a keystore once with
  `keytool -genkey -v -keystore mahjong-slice.jks -keyalg RSA -keysize 2048 -validity 10000 -alias slice`,
  then add to `local.properties`:
  ```
  storeFile=../mahjong-slice.jks
  storePassword=...
  keyAlias=slice
  keyPassword=...
  ```
  and rerun `./gradlew assembleRelease`. The release config in
  `app/build.gradle.kts` already wires this up behind a guard.

## 2. App Bundle file (AAB format)

`mahjong-slice-1.0.0.aab` — 9.4 MB. This is the artifact to upload to
Play Console. Same signing caveat as #1.

## 3. App name

- **Display name:** `切牌 Mahjong Slice`
- **Listing title:** `Mahjong Slice — 切牌`

## 4. Short description (≤80 chars)

```
A calmer mahjong slicing game. Slice matching tiles with elegant precision.
```
(78 chars)

## 5. Full description (≤4000 chars)

```
Mahjong Slice (切牌) is a meditative arcade game where mahjong tiles drift
gently across your screen — slice matching pairs, sequences, and triplets
with confident swipes before they leave the board.

A calmer companion to fast-paced tile-slashing games, Slice trades frenzy
for elegance. Tiles move at a contemplative pace, the spawn rate is
forgiving, and every successful cut feels deliberate. Perfect for unwinding
between meetings, on a long commute, or as a focused brain break.

GAMEPLAY
• Tiles drift across the screen from every direction
• Swipe through matching tiles to slice them — pairs, sequences, or triplets
• Build combos for score multipliers
• Five escalating difficulty tiers, tuned for precision over panic
• Miss three tiles and the round ends — slice carefully

GAME MODES
• Slice Mode — the core arcade experience. How long can you stay focused?
• Memory Mode — flip and match mahjong tiles in a classic memory challenge
  with Easy, Medium, and Hard difficulty layouts

DESIGN
Inspired by traditional Chinese ink-wash painting and the quiet beauty of
jade and bamboo. Every screen is a hand-painted scene: a moonlit garden, a
lotus pond, a hanging bamboo scroll, drifting petals on stone. The mahjong
tiles are aged bamboo cream with deep jade ink — the brushwork is calm and
the palette is warm.

FEATURES
• All 34 authentic mahjong tile types (Bamboo, Characters, Circles, Winds,
  Dragons)
• Hand-painted jade & bamboo backgrounds for every screen
• Calligraphy brush-stroke slice trails
• Satisfying tile shatter effects
• Haptic feedback on every successful cut
• Local high-score tracking
• 100% offline — no ads, no analytics, no tracking, no in-app purchases
• No network permissions of any kind

WHO IT'S FOR
Mahjong Slice is for players who want the joy of pattern recognition
without the pressure of real-time panic. If you enjoy quiet, focused games
that respect your time and attention, this is for you.

Variant note: Mahjong Slice is a calmer companion to Mahjong Slash. Same
core engine, recalibrated for precision and meditation rather than reflex.
```
(~1980 chars)

## 6. App icon (512×512)

`icon_512.png` — 512×512 PNG, opaque, no alpha channel issues. Generated
via Gemini and re-encoded through Pillow for AAPT compatibility. Shows a
single bamboo-cream mahjong tile with the 切 character in dark jade ink
and a diagonal jade-green slice across it, on a deep jade background.

## 7. App screenshots (phone, 1080×2400, portrait)

Provide all seven for a complete listing. Order suggested for the carousel:

| # | File | Screen | Note |
|---|---|---|---|
| 1 | `screenshot_2_splash.png` | Splash | 切牌 title with bamboo + mountains |
| 2 | `screenshot_1_menu.png` | Main menu | Moonlit jade garden + game mode buttons |
| 3 | `screenshot_3b_gameplay_alt.png` | Gameplay | Multiple tiles drifting, bamboo scene |
| 4 | `screenshot_3_gameplay.png` | Gameplay (alt) | Sparse early-round shot |
| 5 | `screenshot_5_memory_difficulty.png` | Memory difficulty | Lotus pavilion picker |
| 6 | `screenshot_6_memory.png` | Memory in-game | Tile grid over lotus pond |
| 7 | `screenshot_4_scores.png` | High scores | Hanging bamboo scroll |
| 8 | `screenshot_7_settings.png` | Settings | Ink brush strokes + scroll |

Play Store accepts up to 8 phone screenshots; this fills the slot exactly.

## 8. Feature graphic (1024×500)

`feature_graphic.png` — 1024×500 PNG. Cinematic landscape composition: a
cream mahjong tile with the 切 character on the left, a swift jade slash
across it, fading into a moonlit bamboo + misty mountain landscape on the
right. Negative space center-right for any title overlay Play Store applies.

## 9. App category

- **Application type:** Game
- **Category:** **Casual** (primary). Reasonable alternatives: **Puzzle**,
  **Arcade**.
- **Tags (keywords):** mahjong, casual, puzzle, tiles, arcade, swipe,
  matching, chinese, meditative, jade, bamboo, ink wash

## 10. Content rating

- **IARC self-rating:** **Everyone** / **PEGI 3** / **ESRB Everyone**
- **Rationale:** No violence beyond cartoonish tile breaking, no language,
  no user-generated content, no chat, no purchases, no ads, no location
  data, no gambling mechanics, no cultural sensitivities. Pattern-matching
  arcade gameplay.
- Complete the IARC questionnaire in Play Console; all answers are "No".

## 11. Privacy policy (link)

**Live URL — paste this into Play Console:**

```
https://sabianhk.github.io/mahjong-slice/playstore/privacy_policy.html
```

Hosted via GitHub Pages from this repo's `main` branch. The source file is
`playstore/privacy_policy.html`; updates to it on `main` republish
automatically within ~30 seconds.

Summary: the app makes **zero network requests**, collects **no personal
data**, has **no analytics**, **no advertising**, and stores high scores +
settings locally via Android DataStore.

## 12. Required permissions and Data Safety

### Manifest permissions

The `AndroidManifest.xml` declares **no `<uses-permission>` entries at
all.** The app needs nothing beyond the implicit permissions every
foreground app gets.

### Play Console — Data safety form

Answer in the *App content → Data safety* section:

| Question | Answer |
|---|---|
| Does your app collect or share any of the required user data types? | **No** |
| Is all of the user data collected by your app encrypted in transit? | **N/A** (no data leaves the device) |
| Do you provide a way for users to request that their data be deleted? | **N/A** (uninstall clears all local data) |
| Data types collected | **None** |
| Data types shared | **None** |
| Security practices | "Data is not encrypted in transit" → **Not applicable, no data is collected or transmitted** |

### Tablet view screenshot

Two tablet captures are included for the *7-inch* tablet form factor:

| File | Resolution | Screen |
|---|---|---|
| `tablet_7in_1_menu.png` | 1200×1920 | Main menu (moonlit jade garden) |
| `tablet_7in_2_gameplay.png` | 1200×1920 | Slice gameplay with drifting tiles |

Captured by temporarily resizing the emulator with
`adb shell wm size 1200x1920` and reverting with `adb shell wm size reset`.

For a 10-inch tablet listing slot, recapture at 1600×2560 the same way:
`adb shell wm size 1600x2560`. The Compose UI scales fluidly so no code
change is needed.

---

## Build provenance

- Built from commit `107e729` on the `main` branch
- `versionCode`: 1
- `versionName`: 1.0.0
- `minSdk`: 26 (Android 8.0)
- `targetSdk`: 35 (Android 15)
- `compileSdk`: 35
- ProGuard + resource shrinking: **enabled** for release
- Signing: **upload key required** before publishing (see #1)
