package pageobject

import org.fluentlenium.core.FluentPage
import org.fluentlenium.core.domain.FluentList
import org.fluentlenium.core.domain.FluentWebElement
import java.util.concurrent.TimeUnit

private const val WAIT_TIME = 30L

abstract class AbstractScreen : FluentPage() {

    fun FluentWebElement.type(text: String) {
        waitUntilElementPresent(this)
        this.scrollIntoView()
        this.clear()
        this.click()
        waitUntilElementPresent(this)
        this.write(text)
    }

    fun clickOnElement(element: FluentWebElement) {
        waitUntilElementPresent(element)
        element.scrollIntoView()
        element.click()
    }

    fun waitUntilElementPresent(element: FluentWebElement) {
        await().atMost(WAIT_TIME, TimeUnit.SECONDS).until(element).present()
    }

    fun waitUntilElementDisplayed(element: FluentWebElement) {
        await().atMost(WAIT_TIME, TimeUnit.SECONDS).until(element).displayed()
    }

    fun waitUntilElementDisplayed(elements: FluentList<FluentWebElement>) {
        await().atMost(WAIT_TIME, TimeUnit.SECONDS).until(elements).displayed()
    }

    fun waitUntilElementNotDisplayed(element: FluentWebElement) {
        await().atMost(WAIT_TIME, TimeUnit.SECONDS).until(element).not().displayed()
    }

    fun waitUntilElementClickable(element: FluentWebElement) {
        await().atMost(WAIT_TIME, TimeUnit.SECONDS).until(element).clickable()
    }
}
