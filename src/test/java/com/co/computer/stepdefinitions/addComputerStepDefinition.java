package com.co.computer.stepdefinitions;

import com.co.computer.UI.addComputerUI;
import com.co.computer.exception.messageException;
import com.co.computer.models.Computer;
import com.co.computer.questions.comparedName;
import com.co.computer.questions.messageDone;
import com.co.computer.tasks.addComputerTask;
import com.co.computer.utils.Constants;
import com.co.computer.utils.SetUp;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class addComputerStepDefinition {

    private AndroidDriver driver;
    SetUp driver1;

    @Before
    public void setUp() {
        driver = SetUp.configureDriver(); // Configura el driver de Appium antes de ejecutar las pruebas
        OnStage.setTheStage(new Cast());
        OnStage.theActorCalled("usuario").can(BrowseTheWeb.with(driver));

    }
    @Given("Eli is on the computer database page")
    public void eliIsOnTheComputerDatabasePage() {
               OnStage.theActorInTheSpotlight().attemptsTo(
                Open.url("http://computer-database.gatling.io/computers?f=computer")
        );
    }
    @When("he adds a new computer with the following details:")
    public void heAddsANewComputerWithTheFollowingDetails(DataTable dataTable) {
        List<Computer> computerList = dataTable.asMaps(String.class, String.class)
                .stream()
                .map(data -> new Computer(data.get("name"), data.get("introduced"), data.get("discontinued"), data.get("company")))
                .collect(Collectors.toList());
        Computer computer = computerList.get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(addComputerTask.addComputer(computer));

    }
    @Then("he should see a success message")
    public void heShouldSeeASuccessMessage() {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        messageDone.done(),
                        Matchers.containsString(Constants.NAME_COMPARATION)).orComplainWith(messageException.class, Constants.MessageExceptionCompare));
    }


}
