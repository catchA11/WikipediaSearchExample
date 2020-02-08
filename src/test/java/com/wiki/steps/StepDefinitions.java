package com.wiki.steps;

import com.wiki.BrowserDriver;
import com.wiki.enums.Language;
import com.wiki.pageobjects.ResultsPage;
import com.wiki.pageobjects.HomePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitions {
    BrowserDriver browserDriver = new BrowserDriver();
    HomePage homePage = new HomePage();
    ResultsPage resultsPage = new ResultsPage();
    public static WebDriver driver;
    private static Language language;

    @Before
    public void openWikiHomePage() {
        String PATH = "http://www.wikipedia.org";

        driver = browserDriver.getBrowserDriver();
        driver.get(PATH);
    }

    @After
    public void cleanUp() {
        browserDriver.closeBrowser();
    }

    @Given("^a search string is entered with (English|French) as selected language$")
    public void enterSearchString(String languageDescription) {
        language = Language.lookUp(languageDescription);
        homePage.setLanguage(language);
        homePage.enterSearchString(driver, language.getSearchText());
    }

    @When("^the search button is clicked$")
    public void clickSearchButton() {
        homePage.clickSearch();
    }

    @Then("^the results page title matches the search string$")
    public void verifyResultsTileMatchesSearch() {
        String pageTitle = resultsPage.getFirstHeader();
        assertThat(pageTitle).isEqualToIgnoringCase(language.getSearchText());
    }
}
