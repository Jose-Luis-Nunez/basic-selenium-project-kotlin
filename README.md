# Basic Selenium Project
![master](https://github.com/Jose-Luis-Nunez/basic-selenium-project-kotlin/actions/workflows/run_tests.yml/badge.svg?branch=master)

This Project is an example Selenium test project with **[FluentLenium](https://fluentlenium.com)** and [Gradle](https://gradle.org) written in **[Kotlin](https://kotlinlang.org)**.

Used Testrunner is [JUnit 5](https://junit.org/junit5) and it uses the [webdrivermanager](https://github.com/bonigarcia/webdrivermanager) which carries out the management (i.e., download, setup, and maintenance) 
of the drivers required by Selenium.

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
