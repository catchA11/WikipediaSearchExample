package com.wiki.steps;

import com.wiki.BrowserDriver;
import com.wiki.pageobjects.WikipediaHomePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class StepDefinitions {
    BrowserDriver browserDriver = new BrowserDriver();
    WikipediaHomePage wikiHomePage = new WikipediaHomePage();
    public static WebDriver driver;

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

    @Given("^a search string is entered with English as selected language$")
    public void enterSearchString() {
        wikiHomePage.enterSearchString(driver, "testing");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("^the search button is clicked$")
    public void clickSearchButton() {
        wikiHomePage.clickSearch();
    }

    @Then("^the results page title matches the search string$")
    public void verifyResultsTileMatchesSearch() {

    }
}
