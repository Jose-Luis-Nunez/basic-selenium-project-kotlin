package tests.check24

import config.annotations.Browser
import config.driver.Breakpoint
import org.fluentlenium.assertj.FluentLeniumAssertions.assertThat
import org.fluentlenium.core.annotation.Page
import org.junit.jupiter.api.Test
import pageobject.check24.Check24ResultPage
import pageobject.check24.Check24StartPage
import tests.SeleniumTest

@Browser(dimension = Breakpoint.XXLARGE)
class Check24Test : SeleniumTest() {

    @Page
    lateinit var startPage: Check24StartPage

    @Page
    lateinit var resultPage: Check24ResultPage

    @Test
    fun `test search for product`() {
        startPage {
            goTo(this)
            acceptCookies()
            searchForProduct("PS5")
        }
        assertThat(resultPage.getHeader()).isDisplayed
    }

}
