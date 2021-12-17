plugins {
    kotlin("jvm") version "1.6.0"
}

repositories {
    mavenCentral()
}

dependencies {
    val fluentleniumVersion = "4.8.0"
    val seleniumVersion = "3.141.59"
    val webdriverManagerVersion = "5.0.3"
    val jUnitVersion = "5.7.2"
    val julToSlf4jVersion = "1.7.28"
    val kotlinLoggerVersion = "1.7.6"
    val skrapeitVersion = "1.1.6"

    testImplementation(
        group = "org.seleniumhq.selenium",
        name = "selenium-java",
        version = seleniumVersion
    )
    testImplementation(
        group = "io.github.bonigarcia",
        name = "webdrivermanager",
        version = webdriverManagerVersion
    )
    testImplementation(
        group = "org.junit.jupiter",
        name = "junit-jupiter",
        version = jUnitVersion
    )
    testImplementation(
        group = "org.fluentlenium",
        name = "fluentlenium-junit-jupiter",
        version = fluentleniumVersion
    )
    testImplementation(
        group = "org.fluentlenium",
        name = "fluentlenium-assertj",
        version = fluentleniumVersion
    )
    testImplementation(
        group = "org.slf4j",
        name = "jul-to-slf4j",
        version = julToSlf4jVersion
    )
    testImplementation(
        group = "io.github.microutils",
        name = "kotlin-logging",
        version = kotlinLoggerVersion
    )
    testImplementation(
        group = "it.skrape",
        name = "skrapeit",
        version = skrapeitVersion
    )
}

tasks {
    withType<Test> {
        useJUnitPlatform()
        systemProperty("browser", System.getProperty("browser"))
    }
}
