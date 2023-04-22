# News App
<p align="center">
  <img src="https://docs.google.com/uc?export=download&id=1G3EsOGtZ1YpC5AwkFYuBcvwVWybces42" alt="Logo" width="150" height="150">
</p>

**News App** is a simple Android application that displays the latest news for United States and France, using the **NewsAPI.org** API.
## Screenshots
<p align="center" float="left">
  <img src="https://docs.google.com/uc?export=download&amp;id=1wpOd2nGvvw01Xfe7iBksZ6MzFhqJG9YO" width="23%" />
  <img src="https://docs.google.com/uc?export=download&amp;id=17LBT5VeYSL5q54Z7sOfwJjVxmr5_pFvC" width="23%" />
  <img src="https://docs.google.com/uc?export=download&amp;id=1Bx8H1mdlnSqnXD8h7fOKljTTK501NDZ-" width="23%" />
  <img src="https://docs.google.com/uc?export=download&amp;id=1yZtYpuFudBjGnZQe5drQNIN-u3bfHflZ" width="23%" />
</p>

## Architecture
The project follows the MVVM architecture and consists of several packages, including **common**, **data**, **di**, **ui**, and **utils**.

- The **common** package contains base classes and utility classes that are used throughout the application.
- The **data** package contains classes related to data handling, such as network calls and data models.
- The **di** package contains Dagger/Hilt modules used for dependency injection.
- The **ui** package contains the application's activities, fragments, and view models.
- The **utils** package contains various utility classes used throughout the application, such as network and UI utilities.

<p align="center">
  <img align="center" src="https://docs.google.com/uc?export=download&id=1U75J8FQt_cvNl4kaj8VcaW2wtwR9uqkN" width="40%" />
</p>


The `mob.nereek.hiltapp` project follows a well-organized and structured architecture that makes it easy to develop and maintain Android applications.

Overall, the structure and architecture of the `mob.nereek.hiltapp` project make it a great starting point for developing Android applications quickly and efficiently, with a well-organized codebase and a clear separation of concerns.

## Libraries Used
Several third-party libraries were used to facilitate the development of the MyNews application. Here is a list of these libraries and the reasons why they were chosen:

- **Kotlin Coroutines:** for asynchronous management of network calls and background tasks.

- **Flow:** for reactive programming and asynchronous data streams.

- **Android Architecture Components:** for implementing the MVVM architecture and managing the lifecycle of application components.

- **Dagger Hilt:** for dependency management and dependency injection.

- **Retrofit:** for retrieving data from the NewsAPI.org API.

- **OkHttp:** for managing HTTP requests and responses.

- **Chuck Interceptor:** for logging and viewing network requests and responses.

- **Moshi:** for serializing and deserializing JSON data.

- **Coil:** for loading images.

- **Material Components:** for the user interface and graphical design of the application.

## Adding API token to the project

To add the API key, you need to replace `APINEWS_KEY` with your actual News API key in the `build.gradle` file. You can get your API key by signing up for News API on their website: https://newsapi.org/register


```Gradle
android {
    ...
    defaultConfig {
        ...
        buildConfigField("String", "API_KEY", "\"your_api_key_here\"")
    }
}
```

After defining the `APINEWS_KEY` field, you can access its value from your code using `BuildConfig.APINEWS_KEY`.

## 🛠 Skills
Kotlin, Android SDK, MVVM Architecture, Android Architecture Components, Retrofit, Dagger Hilt, Coroutines, Flow, OkHttp, Moshi, Coil, Material Design, Git.

## License

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)




## Authors

- [Yassine Mourig](https://www.linkedin.com/in/yassine-mourig-computer-engineer/)

## Used By

This structure is used by the following companies:

- www.nereek.io (**YOFIFY LLC**)
