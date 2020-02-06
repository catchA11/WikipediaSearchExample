package com.wiki.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikipediaHomePage {
    private static final String SEARCH_TEXTBOX_ID = "searchInput";

    public void enterSearchString(WebDriver driver, String searchString) {
        WebElement searchTextField = driver.findElement(By.id(SEARCH_TEXTBOX_ID));
        searchTextField.sendKeys(searchString);
    }
}
