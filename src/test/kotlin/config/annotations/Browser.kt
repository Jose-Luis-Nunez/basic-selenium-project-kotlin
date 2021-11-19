package config.annotations

import config.driver.Breakpoint

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class Browser(
    val dimension: Breakpoint = Breakpoint.DEFAULT,
    val use: Browsers = Browsers.DEFAULT
)

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class Screenshot
