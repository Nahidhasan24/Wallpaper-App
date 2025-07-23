# Wallpaper-App

An **Android wallpaper app** built with **Java** that allows users to browse and set beautiful wallpapers fetched dynamically from the [Pexels API](https://api.pexels.com/v1/). Users can explore the latest wallpapers and set them as their phone background directly within the app.

---

## Table of Contents

- [About](#about)  
- [Features](#features)  
- [Technology Stack](#technology-stack)  
- [API Used](#api-used)  
- [Project Structure](#project-structure)  
- [Installation](#installation)  
- [Usage](#usage)  
- [Screenshots](#screenshots)  
- [Contributing](#contributing)  
- [License](#license)  
- [Contact](#contact)  

---

## About

Wallpaper-App is a simple yet powerful Android application that fetches high-quality wallpapers from the Pexels API and displays them to users. Users can browse trending and new wallpapers, preview them, and set any wallpaper directly on their device with ease.

---

## Features

- Fetch and display latest wallpapers from Pexels API  
- Browse wallpapers in a smooth, scrollable grid layout  
- Preview wallpapers in full screen  
- Set selected wallpaper as device background  
- Efficient image loading and caching for smooth experience  
- Offline fallback for previously loaded wallpapers (if implemented)  

---

## Technology Stack

- Android SDK  
- Java  
- Retrofit / OkHttp (for API calls)  
- Glide or Picasso (for image loading and caching)  
- JSON parsing with GSON or native Android tools  

---

## API Used

- **Pexels API**: [https://www.pexels.com/api/](https://www.pexels.com/api/)  
  - Used to fetch high-quality free stock photos as wallpapers  
  - Requires an API key (You need to register on Pexels to get your API key)  

---

## Project Structure

```

Wallpaper-App/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/               # Java source files (activities, adapters, API service)
│   │   │   ├── res/                # Layouts, drawables, and other resources
│   │   │   └── AndroidManifest.xml
├── build.gradle                   # Build configurations
├── README.md                     # This documentation
└── ...

````

---

## Installation

1. Clone the repository:

```bash
git clone https://github.com/Nahidhasan24/Wallpaper-App.git
````

2. Open the project in **Android Studio**.

3. Add your **Pexels API Key**:

* Locate where the API key is defined (e.g., in a constants file or inside your API service class).
* Replace the placeholder with your actual API key from [Pexels](https://www.pexels.com/api/new/).

4. Build and run the app on a physical device or emulator.

---

## Usage

* Open the app to see the latest wallpapers fetched from Pexels.
* Scroll through the wallpaper grid to explore.
* Tap on any wallpaper to preview it fullscreen.
* Use the "Set Wallpaper" option to apply it as your device background.

## Contributing

Contributions are welcome! Feel free to:

* Report issues and bugs
* Suggest new features
* Submit pull requests with improvements

Please follow Android best practices and keep the code clean.

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Contact

**Nahid Hasan**

* GitHub: [https://github.com/Nahidhasan24](https://github.com/Nahidhasan24)
* Email: *nahidsoftware24@yahoo.com*

---

Thank you for checking out the Wallpaper-App!
Please ⭐ star the repository if you find it useful.
