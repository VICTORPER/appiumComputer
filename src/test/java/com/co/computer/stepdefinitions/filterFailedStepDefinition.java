package com.co.computer.stepdefinitions;

import com.co.computer.exception.messageException;
import com.co.computer.models.filterComputer;
import com.co.computer.tasks.filterComputerTask;
import com.co.computer.utils.Constants;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.stream.Collectors;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class filterFailedStepDefinition {


    @When("I filter failed a computer")
    public void iFilterFailedAComputer(DataTable dataTable) {
        List<filterComputer> filterComputerList = dataTable.asMaps(String.class, String.class)
                .stream()
                .map(data -> new filterComputer(data.get("computername")))
                .collect(Collectors.toList());
        filterComputer filter = filterComputerList.get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(filterComputerTask.filterComputer(filter));
    }
    @Then("The system show alert message")
    public void theSystemShowAlertMessage() {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        TheWebPage.title(),
                        Matchers.containsString(Constants.NAME_FOUND)).orComplainWith(messageException.class, Constants.MessageExceptionCompare));

    }
}