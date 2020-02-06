package com.wiki.steps;

import com.wiki.BrowserDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;

public class StepDefinitions {
    BrowserDriver browserDriver = new BrowserDriver();
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

    }
}
