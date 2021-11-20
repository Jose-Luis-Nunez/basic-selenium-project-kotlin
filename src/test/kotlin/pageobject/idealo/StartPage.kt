package pageobject.idealo

import org.fluentlenium.core.annotation.PageUrl
import org.fluentlenium.core.domain.FluentWebElement
import org.openqa.selenium.support.FindBy
import pageobject.AbstractScreen

@PageUrl("https://www.idealo.de/")
class StartPage : AbstractScreen() {

    @FindBy(css = "input[name='q']")
    private lateinit var searchfield: FluentWebElement

    fun searchForProduct(product: String) {
        searchfield.type(product)
        searchfield.submit()
    }
}
