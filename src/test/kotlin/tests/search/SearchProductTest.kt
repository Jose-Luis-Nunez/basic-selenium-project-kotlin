package tests.search

import config.annotations.Browser
import config.annotations.Browsers
import config.driver.Breakpoint
import org.fluentlenium.assertj.FluentLeniumAssertions.assertThat
import org.fluentlenium.core.annotation.Page
import org.junit.jupiter.api.Test
import pageobject.search.OffersPage
import pageobject.search.ProductPage
import pageobject.search.StartPage
import tests.SeleniumTest

@Browser(dimension = Breakpoint.XXLARGE)
class SearchProductTest : SeleniumTest() {

    @Page
    lateinit var startPage: StartPage

    @Page
    lateinit var productPage: ProductPage

    @Page
    lateinit var offersPage: OffersPage

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
