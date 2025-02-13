package com.wiki;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        plugin = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json"},
        features = {"classpath:com.wiki/features"},
        glue = {"classpath:com/wiki/steps"}
)
public class RunCucumberTest {
}
