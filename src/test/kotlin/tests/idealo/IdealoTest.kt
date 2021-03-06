package tests.idealo

import org.fluentlenium.assertj.FluentLeniumAssertions.assertThat
import org.fluentlenium.core.annotation.Page
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import pageobject.idealo.OffersPage
import pageobject.idealo.ProductPage
import pageobject.idealo.StartPage
import tests.utils.SeleniumTest

class IdealoTest : SeleniumTest() {

    @Page
    lateinit var startPage: StartPage

    @Page
    lateinit var productPage: ProductPage

    @Page
    lateinit var offersPage: OffersPage

    @Disabled
    @Test
    fun `test search for product`() {
        startPage {
            goTo(this)
            searchForProduct("PS5")
        }
        productPage {
            selectFirstProductTile()
        }
        assertThat(offersPage.getProductOffer()).isDisplayed
    }
}
