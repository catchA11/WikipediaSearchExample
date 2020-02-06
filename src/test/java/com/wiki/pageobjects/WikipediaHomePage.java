package com.wiki.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static com.wiki.steps.StepDefinitions.driver;

public class WikipediaHomePage {
    private static final String SEARCH_TEXT_BOX_ID = "searchInput";
    private static final String SEARCH_BUTTON_CLASS_NAME = "pure-button";

    public void enterSearchString(WebDriver driver, String searchString) {
        WebElement searchTextField = driver.findElement(By.id(SEARCH_TEXT_BOX_ID));
        searchTextField.sendKeys(searchString);
    }

    public void clickSearch() {
        WebElement searchButton = driver.findElement(By.className(SEARCH_BUTTON_CLASS_NAME));
        searchButton.click();
    }
}
