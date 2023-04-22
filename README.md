
![Logo](https://docs.google.com/uc?export=download&id=1G3EsOGtZ1YpC5AwkFYuBcvwVWybces42)
# News App

**News App** is a simple Android application that displays the latest news for United States and France, using the **NewsAPI.org** API.

## Architecture
The project follows the MVVM architecture and consists of several packages, including **common**, **data**, **di**, **ui**, and **utils**.

- The **common** package contains base classes and utility classes that are used throughout the application.
- The **data** package contains classes related to data handling, such as network calls and data models.
- The **di** package contains Dagger/Hilt modules used for dependency injection.
- The **ui** package contains the application's activities, fragments, and view models.
- The **utils** package contains various utility classes used throughout the application, such as network and UI utilities.



![App structure](https://docs.google.com/uc?export=download&id=1U75J8FQt_cvNl4kaj8VcaW2wtwR9uqkN
)

The `mob.nereek.hiltapp` project follows a well-organized and structured architecture that makes it easy to develop and maintain Android applications.

Overall, the structure and architecture of the `mob.nereek.hiltapp` project make it a great starting point for developing Android applications quickly and efficiently, with a well-organized codebase and a clear separation of concerns.

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



## Screenshots

![App Screenshot](https://docs.google.com/uc?export=download&id=1wpOd2nGvvw01Xfe7iBksZ6MzFhqJG9YO
)

![App Screenshot](https://docs.google.com/uc?export=download&id=17LBT5VeYSL5q54Z7sOfwJjVxmr5_pFvC
)

![App Screenshot](https://docs.google.com/uc?export=download&id=1Bx8H1mdlnSqnXD8h7fOKljTTK501NDZ-
)

![App Screenshot](https://docs.google.com/uc?export=download&id=1yZtYpuFudBjGnZQe5drQNIN-u3bfHflZ
)
## 🛠 Skills
Kotlin, Android SDK, MVVM Architecture, Android Architecture Components, Retrofit, Dagger Hilt, Coroutines, Flow, OkHttp, Moshi, Coil, Material Design, Git.

## License

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)




## Authors

- [Yassine Mourig](https://www.linkedin.com/in/yassine-mourig-computer-engineer/)

## Used By

This structure is used by the following companies:

- www.nereek.io (**YOFIFY LLC**)
