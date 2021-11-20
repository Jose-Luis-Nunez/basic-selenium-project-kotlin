package pageobject.github

import org.fluentlenium.core.annotation.PageUrl
import org.fluentlenium.core.domain.FluentWebElement
import org.openqa.selenium.support.FindBy
import pageobject.AbstractScreen

@PageUrl("https://github.com/")
class GithubStartPage : AbstractScreen() {

    @FindBy(css = "input[name='q']")
    private lateinit var searchfield: FluentWebElement

    fun searchForUser(user: String) {
        searchfield.type(user)
        searchfield.submit()
    }
}
