plugins {
    kotlin("jvm") version "1.7.10"
}

repositories {
    mavenCentral()
}

dependencies {
    val fluentleniumVersion = "5.0.4"
    val seleniumVersion = "4.2.2"
    val webdriverManagerVersion = "5.2.0"
    val jUnitVersion = "5.7.2"
    val julToSlf4jVersion = "1.7.28"
    val kotlinLoggerVersion = "1.7.6"

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
    implementation("com.willowtreeapps.assertk:assertk:0.25")
}

tasks {
    withType<Test> {
        useJUnitPlatform()
        systemProperty("browser", System.getProperty("browser"))
    }
}
