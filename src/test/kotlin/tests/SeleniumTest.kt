package tests

import config.annotations.Browser
import config.annotations.Screenshot
import config.driver.Breakpoint
import config.driver.DriverFactory
import org.fluentlenium.adapter.junit.jupiter.FluentTest
import org.fluentlenium.configuration.ConfigurationProperties
import org.fluentlenium.core.FluentPage
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.Dimension
import org.openqa.selenium.WebDriver
import java.time.Duration.ofSeconds

open class SeleniumTest : FluentTest() {

    private val timeout = Integer.getInteger("page_load_timeout", 30).toLong()

    private val driverFactory = DriverFactory()

    private fun requestedDriver() = javaClass.getAnnotation(Browser::class.java)?.use

    override fun newWebDriver(): WebDriver {
        return driverFactory.get(requestedDriver()).apply {
            manage().timeouts().pageLoadTimeout(ofSeconds(timeout))
            manage().timeouts().implicitlyWait(ofSeconds(timeout))
            manage().timeouts().scriptTimeout(ofSeconds(timeout))
            manage().window().maximize()
        }
    }

    @BeforeEach
    fun setUp() {
        screenshotMode = screenshotMode()
        screenshotPath = "build/screenshots"
        awaitAtMost = 30_000
    }

    private fun screenshotMode(): ConfigurationProperties.TriggerMode {
        if (javaClass.getAnnotation(Screenshot::class.java) != null) {
            return ConfigurationProperties.TriggerMode.MANUAL
        }
        return ConfigurationProperties.TriggerMode.AUTOMATIC_ON_FAIL
    }

    @BeforeEach
    fun changeBrowserDimension() {
        javaClass.getAnnotation(Browser::class.java)?.let {
            if (it.dimension != Breakpoint.DEFAULT) {
                driver.manageWindowSize(it.dimension)
            }
        }
    }

    private fun WebDriver.manageWindowSize(dimension: Breakpoint) {
        when (dimension) {
            Breakpoint.SMALL -> windowResizeTo(359)
            Breakpoint.MEDIUM -> windowResizeTo(599)
            Breakpoint.LARGE -> windowResizeTo(959)
            Breakpoint.XLARGE -> windowResizeTo(1199)
            Breakpoint.XXLARGE -> windowResizeTo(1280)
            Breakpoint.FULLSCREEN -> manage().window().fullscreen()
            else -> manage().window().maximize()
        }
    }

    private fun WebDriver.windowResizeTo(width: Int, height: Int = 800) {
        manage().window().size = Dimension(width, height)
    }

    inline operator fun <reified T : FluentPage> T.invoke(func: T.() -> Unit) = with(T::class) {
        apply { func() }
    }
}
