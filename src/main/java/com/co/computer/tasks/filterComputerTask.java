package com.co.computer.tasks;

import com.co.computer.UI.addComputerUI;
import com.co.computer.UI.homePageUI;
import com.co.computer.models.Computer;
import com.co.computer.models.filterComputer;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class filterComputerTask implements Task {

    filterComputer filter;

    public filterComputerTask(filterComputer filter){
        this.filter = filter;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Enter.theValue(filter.getComputername()).into(homePageUI.NAME_COMPUTER_FIELD),
                Click.on((homePageUI.FILTER_BUTTON))

        );
    }
    public static filterComputerTask filterComputer(filterComputer filter) {
        return Tasks.instrumented(filterComputerTask.class, filter);
    }

}
