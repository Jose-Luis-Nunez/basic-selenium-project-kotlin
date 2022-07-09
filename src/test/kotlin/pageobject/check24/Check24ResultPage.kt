package pageobject.check24

import org.fluentlenium.core.domain.FluentWebElement
import org.openqa.selenium.support.FindBy
import pageobject.AbstractScreen

class Check24ResultPage : AbstractScreen() {

    @FindBy(css = ".result-header__headline")
    private lateinit var header: FluentWebElement

    fun getHeader(): FluentWebElement {
        waitUntilElementDisplayed(header)
        return header
    }
}
