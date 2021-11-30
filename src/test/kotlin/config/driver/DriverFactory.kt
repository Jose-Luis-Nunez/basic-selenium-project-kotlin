package config.driver

import config.utils.PropertiesReader
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.Proxy
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.edge.EdgeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.logging.LogType
import org.openqa.selenium.logging.LoggingPreferences
import org.openqa.selenium.opera.OperaDriver
import org.openqa.selenium.opera.OperaOptions
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.safari.SafariDriver
import org.openqa.selenium.safari.SafariOptions
import java.util.logging.Level

class DriverFactory {
    private val userAgent = PropertiesReader().getProp("chrome.user.agent") ?: "unsupported"

    fun get(requestedDriver: Browsers?): WebDriver {
        return webDriver(requestedDriver)
    }

    private fun webDriver(requestedDriver: Browsers?): WebDriver {
        return when (requestedDriver) {
            Browsers.CHROME_HEADLESS -> chromeHeadless()
            Browsers.CHROME -> chrome()
            Browsers.FIREFOX -> firefox()
            Browsers.FIREFOX_HEADLESS -> firefoxHeadless()
            Browsers.SAFARI -> safari()
            Browsers.OPERA -> opera()
            Browsers.EDGE -> edge()
            Browsers.DEFAULT,
            null -> default()
        }.exhaustive
    }

    private val <T> T.exhaustive: T
        get() = this

    private fun firefox(): WebDriver {
        WebDriverManager.firefoxdriver().setup()
        return FirefoxDriver(firefoxOptions())
    }

    private fun firefoxHeadless(): WebDriver {
        WebDriverManager.firefoxdriver().setup()
        return FirefoxDriver(firefoxOptions().setHeadless(true))
    }

    private fun chrome(): WebDriver {
        val proxyString = "213.136.89.121:80"
        val proxy = Proxy()
        proxy.httpProxy = proxyString
        proxy.sslProxy = proxyString
        chromeOptions().setCapability("proxy", proxy);
        WebDriverManager.chromedriver().setup()
        return ChromeDriver(chromeOptions())
    }

    private fun chromeHeadless(): WebDriver {
        WebDriverManager.chromedriver().setup()
        return ChromeDriver(chromeOptions().setHeadless(true))
    }

    private fun opera(): WebDriver {
        WebDriverManager.operadriver().setup()
        return OperaDriver(operaOptions())
    }

    private fun safari(): WebDriver {
        return SafariDriver(safariOptions())
    }

    private fun edge(): WebDriver {
        WebDriverManager.edgedriver().setup()
        return EdgeDriver(edgeOptions())
    }

    private fun default(): WebDriver {
        return webDriver(getDefaultBrowser())
    }

    private fun getDefaultBrowser(): Browsers {
        val invokedBrowser = System.getProperty("browser").orEmpty()

        if (invokedBrowser.isNotBlank()) {
            return Browsers.byString(invokedBrowser)
        }

        val defaultBrowser: String = PropertiesReader().getProp("default.browser") ?: "unsupported"

        return Browsers.byString(defaultBrowser)
    }

    private fun firefoxOptions() = FirefoxOptions().merge(capabilities())
    private fun operaOptions() = OperaOptions().merge(capabilities())
    private fun safariOptions() = SafariOptions().merge(capabilities())
    private fun edgeOptions() = EdgeOptions().merge(capabilities())
    private fun chromeOptions() = ChromeOptions()
        .addArguments("--disable-gpu")
        .addArguments("--dns-prefetch-disable")
        .addArguments("disable-infobars")
        .addArguments("--disable-extensions")
        .addArguments("--disable-dev-shm-usage")
        .addArguments("--start-maximized")
        .addArguments("--disable-popup-blocking")
        .addArguments("--lang=de")
        .addArguments("--incognito")
        .addArguments("--ignore-certificate-errors")
        .addArguments("user-agent=$userAgent")
        .merge(capabilities())

    private fun capabilities(): DesiredCapabilities {
        val capabilities = DesiredCapabilities()
        val logPrefs = LoggingPreferences().apply { enable(LogType.BROWSER, Level.ALL) }

        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs)
        capabilities.isJavascriptEnabled = true

        return capabilities
    }
}
