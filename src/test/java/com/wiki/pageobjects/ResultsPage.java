package com.wiki.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static com.wiki.steps.StepDefinitions.driver;


public class ResultsPage {

    public String getFirstHeader() {
        WebElement firstHeading = driver.findElement(By.id("firstHeading"));
        return firstHeading.getText();
    }

    public WebElement findLinkToResultsInEnglish() {
        WebElement link = driver.findElement(By.linkText("English"));
        return link;
    }

    public boolean isLanguagesOptionControlDisplayed() {
        try {
            WebElement languageOptions = driver.findElement(By.cssSelector("#p-lang-label"));
            return languageOptions.getText().contains("Languages");
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
