package pageobject.idealo

import org.fluentlenium.core.domain.FluentList
import org.fluentlenium.core.domain.FluentWebElement
import org.openqa.selenium.support.FindBy
import pageobject.AbstractScreen

private const val FIRST_ELEMENT = 0

class ProductPage : AbstractScreen() {

    @FindBy(css = ".offerList-item-description:nth-child(1)")
    private lateinit var productTile: FluentList<FluentWebElement>

    fun selectFirstProductTile() {
        val firstElement = productTile[FIRST_ELEMENT]
        clickOnElement(firstElement)
    }
}
