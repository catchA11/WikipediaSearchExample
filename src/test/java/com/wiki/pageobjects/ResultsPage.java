package com.wiki.pageobjects;

import com.wiki.enums.Language;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static com.wiki.steps.StepDefinitions.driver;

public class ResultsPage {
    private static final String FIRST_HEADING_ID = "firstHeading";
    private static final String LANGUAGE_OPTIONS_ID = "#p-lang-label";

    public String getFirstHeader() {
        WebElement firstHeading = driver.findElement(By.id(FIRST_HEADING_ID));
        return firstHeading.getText();
    }

    public WebElement findLinkToResultsIn(String languageDescription) {
        Language language = Language.lookUp(languageDescription);
        return driver.findElement(By.linkText(language.getLinkTitle()));
    }

    public boolean isLanguagesOptionControlDisplayed() {
        try {
            WebElement languageOptions = driver.findElement(By.cssSelector(LANGUAGE_OPTIONS_ID));
            return languageOptions.getText().contains("Languages");
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void changeLanguageTo(String language) {
        WebElement link = findLinkToResultsIn(language);
        link.click();
    }
}
