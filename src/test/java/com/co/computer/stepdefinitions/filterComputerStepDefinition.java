package com.co.computer.stepdefinitions;

import com.co.computer.UI.homePageUI;
import com.co.computer.exception.messageException;
import com.co.computer.models.Computer;
import com.co.computer.models.filterComputer;
import com.co.computer.questions.comparedName;
import com.co.computer.tasks.addComputerTask;
import com.co.computer.tasks.filterComputerTask;
import com.co.computer.utils.Constants;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.Ensure;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.stream.Collectors;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class filterComputerStepDefinition {
    @Given("I am on the computer database page")
    public void iAmOnTheComputerDatabasePage() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Open.url("http://computer-database.gatling.io/computers?f=computer"));
    }
    @When("I filter a computer by his name")
    public void iFilterAComputerByHisName(DataTable dataTable) {
        List<filterComputer> filterComputerList = dataTable.asMaps(String.class, String.class)
                .stream()
                .map(data -> new filterComputer(data.get("computername")))
                .collect(Collectors.toList());
        filterComputer filter = filterComputerList.get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(filterComputerTask.filterComputer(filter));
    }
    @Then("The system only should show me the register filtered")
    public void theSystemOnlyShouldShowMeTheRegisterFiltered() {

        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        TheWebPage.title(),
                        Matchers.containsString(Constants.NAME_FOUND)).orComplainWith(messageException.class, Constants.MessageExceptionCompare));
    }

}
