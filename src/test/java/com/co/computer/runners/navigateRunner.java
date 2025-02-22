package com.co.computer.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/navigatePage.feature",
        glue = "com.co.computer.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class navigateRunner {
}
