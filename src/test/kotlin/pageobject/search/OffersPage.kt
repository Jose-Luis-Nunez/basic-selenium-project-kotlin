package pageobject.search

import org.fluentlenium.core.domain.FluentList
import org.fluentlenium.core.domain.FluentWebElement
import org.openqa.selenium.support.FindBy
import pageobject.AbstractScreen

private const val FIRST_OFFER = 0

class OffersPage : AbstractScreen() {

    @FindBy(css = ".productOffers-listItemOfferLink")
    private lateinit var offersList: FluentList<FluentWebElement>

    fun getProductOffer(): FluentWebElement {
        waitUntilElementDisplayed(offersList)
        return offersList[FIRST_OFFER]
    }
}
