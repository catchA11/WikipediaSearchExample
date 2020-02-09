package com.wiki.steps;

import com.wiki.BrowserDriver;
import com.wiki.enums.Language;
import com.wiki.pageobjects.ResultsPage;
import com.wiki.pageobjects.HomePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.wiki.enums.Language.ENGLISH;
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

    @When("^a search is entered with (English|French|German) as selected language$")
    public void enterSearchString(String languageDescription) {
        language = Language.lookUp(languageDescription);
        homePage.setLanguage(language);
        homePage.enterSearchString(driver, language.getSearchText());
        homePage.clickSearch();
    }

    @Then("^the results page title matches the search string$")
    public void verifyResultsTileMatchesSearch() {
        verifyResultsTitle(language.getSearchText());
    }

    private void verifyResultsTitle(String expectedTitle) {
        String pageTitle = resultsPage.getFirstHeader();
        assertThat(pageTitle).containsIgnoringCase(expectedTitle);
    }

    @And("^search results page is available in other languages$")
    public void verifyOptionProvidedToDisplayResultsInMultipleLanguages() {
        assertThat(resultsPage.isLanguagesOptionControlDisplayed())
                .withFailMessage("Option to display search results in other languages not found")
                .isTrue();
    }

    @When("^the option is chosen to display the results in (.*)$")
    public void displayResultsInLanguage(String language) {
        resultsPage.changeLanguageTo(language);
    }

    @Then("^the results are displayed in (.*)$")
    public void verifyResultsDisplayedIn(String languageDescription) {
        language = Language.lookUp(languageDescription);
        verifyResultsTitle(language.getSearchText());
    }

    @And("^a link is provided to display the results in English$")
    public void verifyLinkToEnglishResults() {
        WebElement link = resultsPage.findLinkToResultsIn("English");
        link.click();
        verifyResultsTitle(ENGLISH.getSearchText());
    }
}
