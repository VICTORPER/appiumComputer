package com.co.computer.stepdefinitions;

import com.co.computer.tasks.navigateTask;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

public class navigatePageStepDefinition {
    @When("I do click on the next button")
    public void iDoClickOnTheNextButton() {
        OnStage.theActorInTheSpotlight().attemptsTo(navigateTask.untilPage40());
    }
    @Then("I´m on page")
    public void iMOnPage() {


    }


}
