package config.annotations

import config.driver.Breakpoint
import config.driver.Driver

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class Browser(
    val dimension: Breakpoint = Breakpoint.DEFAULT,
    val use: Driver = Driver.DEFAULT
)

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class Screenshot
