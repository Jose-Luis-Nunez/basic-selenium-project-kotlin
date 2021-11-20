package pageobject.check24

import org.fluentlenium.core.annotation.PageUrl
import org.fluentlenium.core.domain.FluentWebElement
import org.openqa.selenium.support.FindBy
import pageobject.AbstractScreen

@PageUrl("https://www.check24.de/")
class Check24StartPage : AbstractScreen() {

    @FindBy(css = ".c24-cookie-consent-notice-buttons .c24-cookie-consent-button:nth-child(2)")
    private lateinit var acceptCookiesButton: FluentWebElement

    @FindBy(css = "input[name='q']")
    private lateinit var searchfield: FluentWebElement

    fun acceptCookies() {
        clickOnElement(acceptCookiesButton)
    }

    fun searchForProduct(product: String) {
        searchfield.type(product)
        searchfield.submit()
    }
}
