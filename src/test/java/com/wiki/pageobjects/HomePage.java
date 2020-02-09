package com.wiki.pageobjects;

import com.wiki.enums.Language;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.wiki.steps.StepDefinitions.driver;

public class HomePage {
    private static final String SEARCH_TEXT_BOX_ID = "searchInput";
    private static final String SEARCH_BUTTON_CLASS_NAME = "pure-button";
    private static final String LANGUAGE_DROPDOWN_ID = "searchLanguage";

    public void enterSearchString(WebDriver driver, String searchString) {
        WebElement searchTextField = driver.findElement(By.id(SEARCH_TEXT_BOX_ID));
        searchTextField.sendKeys(searchString);
    }

    public void clickSearch() {
        WebElement searchButton = driver.findElement(By.className(SEARCH_BUTTON_CLASS_NAME));
        searchButton.click();
    }

    public void setLanguage(Language language) {
        Select languageDropdown = new Select(driver.findElement(By.id(LANGUAGE_DROPDOWN_ID)));
        languageDropdown.selectByValue(language.getCode());
    }
}
