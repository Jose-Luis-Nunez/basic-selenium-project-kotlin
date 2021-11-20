package tests.github

import config.annotations.Browser
import config.driver.Breakpoint
import org.fluentlenium.core.annotation.Page
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import pageobject.github.GithubStartPage
import tests.SeleniumTest

@Browser(dimension = Breakpoint.XXLARGE)
class GithubTest : SeleniumTest() {

    @Page
    lateinit var startPage: GithubStartPage

    @Disabled
    @Test
    fun `test search for product`() {
        startPage {
            goTo(this)
            searchForUser("jose-luis-nunez")
        }
    }
}
