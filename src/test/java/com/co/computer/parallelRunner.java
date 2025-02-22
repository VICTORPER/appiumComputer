package com.co.computer;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.co.computer.stepdefinitions",
        //tags = "@Regression", // Puedes cambiarlo según tus necesidades
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true
)
public class parallelRunner {
}
