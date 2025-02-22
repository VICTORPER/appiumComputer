package com.co.computer.stepdefinitions;

import com.co.computer.exception.messageException;
import com.co.computer.questions.comparedName;
import com.co.computer.tasks.navigateTask;
import com.co.computer.utils.Constants;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class navigatePageStepDefinition {
    @When("I do click on the next button")
    public void iDoClickOnTheNextButton() {
        OnStage.theActorInTheSpotlight().attemptsTo(navigateTask.untilPage40());
    }
    @Then("I´m on page")
    public void iMOnPage() {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        comparedName.compare(),
                        Matchers.containsString(Constants.NAME_FOUND)).orComplainWith(messageException.class, Constants.MessageExceptionCompare));

    }


}
