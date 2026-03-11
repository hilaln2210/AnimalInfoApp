# Animal Info App — Animal Encyclopedia

An Android animal encyclopedia app with bilingual support (English and Hebrew). Browse animals by category, search by name, toggle between list and grid views, view detailed animal facts, share information, and contribute new facts via a dialog.

## Screenshots

| Splash Screen | Animal Grid | Animal Detail |
|---|---|---|
| ![Splash Screen](screenshots/splash.png) | ![Animal Grid](screenshots/animal_grid.png) | ![Animal Detail](screenshots/animal_detail.png) |

## Features

- **Splash Screen** — Animated introduction screen shown on first launch
- **Bilingual support** — Toggle between English and Hebrew at any time; all animal names and UI labels switch accordingly
- **Category Selector** — Filter the displayed animals by category (e.g. mammals, birds, reptiles)
- **Live Search** — `SearchBar` composable filters animals in real time by name as you type
- **List / Grid View Toggle** — Switch between a scrollable `AnimalList` and a card-based `AnimalGrid` layout
- **Animal Detail Screen** — Full detail view (`AnimalDetails`) with facts and information for the selected animal
- **Share** — Share animal facts to other apps via the Android share sheet (`ShareUtils`)
- **Add Contribution Dialog** — Submit additional facts for any animal via `AddContributionDialog`
- **MVVM architecture** — `AnimalViewModel` manages search query, language preference, category selection, and the animal dataset

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Kotlin |
| UI | Jetpack Compose (Material 3, dynamic color) |
| Architecture | MVVM — `AnimalViewModel` + Compose state |
| Build system | Gradle with Kotlin DSL + Version Catalog |
| Min SDK | 24 |
| Target / Compile SDK | 34 |
| AGP | 8.6.0 |
| Kotlin | 1.9.0 |

## Project Structure

```
AnimalInfoApp/
├── app/
│   └── src/main/
│       ├── java/com/example/animalinfoapp/
│       │   ├── MainActivity.kt          # Entry point; splash → main
│       │   ├── AnimalInfoApp.kt         # Root composable; layout orchestration
│       │   ├── AnimalViewModel.kt       # Business logic and app state
│       │   ├── AnimalItem.kt            # Animal data model
│       │   ├── AnimalList.kt            # List-mode composable
│       │   ├── AnimalGrid.kt            # Grid-mode composable
│       │   ├── AnimalGridItem.kt        # Single grid cell composable
│       │   ├── AnimalDetails.kt         # Detail screen composable
│       │   ├── CategorySelector.kt      # Category filter row
│       │   ├── SearchBar.kt             # Search input + language/view-toggle controls
│       │   ├── SplashScreen.kt          # Animated splash composable
│       │   ├── AddContributionDialog.kt # Contribution input dialog
│       │   ├── ShareUtils.kt            # Android share-sheet helper
│       │   └── ui/theme/               # Material 3 theme
│       └── AndroidManifest.xml
├── gradle/
│   ├── libs.versions.toml
│   └── wrapper/
└── settings.gradle.kts
```

## How to Build

### Prerequisites

- Android Studio Hedgehog (2023.1.1) or newer
- Android SDK with API level 34 platform installed
- JDK 17+

### Steps

1. Clone the repository and open the `AnimalInfoApp` folder in Android Studio.
2. Allow Gradle to sync — all dependencies are resolved automatically.
3. Connect a device or start an AVD (API 24+).
4. Click **Run > Run 'app'** or press `Shift+F10`.

### Command-line build

```bash
./gradlew assembleDebug
```

Output APK: `app/build/outputs/apk/debug/app-debug.apk`

## Notes

- The app uses `dynamicLightColorScheme` (Material You) on Android 12+ (API 31+), adapting colors to the device wallpaper. On older devices a standard Material 3 color scheme is applied.
