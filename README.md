# Basic Selenium Project

This Project is an example Selenium test project with **[FluentLenium](https://fluentlenium.com)** and [Gradle](https://gradle.org) written in **[Kotlin](https://kotlinlang.org)**.
>#### ℹ️ FluentLenium is a website automation framework which extends Selenium to write reliable and resilient UI functional tests.

Used Testrunner is [JUnit 5](https://junit.org/junit5) and it uses the [webdrivermanager](https://github.com/bonigarcia/webdrivermanager) which carries out the management (i.e., download, setup, and maintenance) 
of the drivers required by Selenium.

In addition this projekt has tests using **[skrape{it}](https://github.com/skrapeit/skrape.it)**.
>#### ℹ️ skrape{it} is a Kotlin-based HTML/XML testing and web scraping library. It can analyze and extract HTML including client-side rendered DOM trees

#### Run tests

The tests can be executed with the following command:

* Chrome Headless (default) `./gradlew clean test`
* Chrome `./gradlew clean test -Dbrowser=chrome`
* Firefox `./gradlew clean test -Dbrowser=firefox`
* Opera `./gradlew clean test -Dbrowser=opera`
---

##### @Browser
Overwrite used (default) browser by annotating test classes or test methods with:

    @Browser(use = CHROME)

This will always execute the annotated tests with the selected browser, and will overwrite the default browser.

The Browser windows dimension could also be set with:

    @Browser(dimension = XLARGE)

---

#### Take Screenshots
If a test fails a screenshots will automatically be taken and stored under `build/screenshots`.

---

#### Highlight Clicked Elements
When running a tests and clicking an element it will be highlighted with a red border. This is really helpful to easily understand what
a test is doing.
