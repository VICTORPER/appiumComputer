package com.co.computer.tasks;

import com.co.computer.UI.addComputerUI;
import com.co.computer.models.Computer;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class addComputerTask implements Task {

    Computer computer;

    public addComputerTask(Computer computer){
        this.computer = computer;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Click.on((addComputerUI.ADD_BUTTON)),
                Enter.theValue(computer.getName()).into(addComputerUI.NAME_FIELD),
                Enter.theValue(computer.getIntroduced()).into(addComputerUI.INTRODUCED_FIELD),
                Enter.theValue(computer.getDiscontinued()).into(addComputerUI.DISCONTINUED_FIELD),
                SelectFromOptions.byVisibleText(computer.getCompany()).from(addComputerUI.COMPANY_FIELD),
                Click.on((addComputerUI.BUTTON_CONFIRM))

        );
    }
    public static addComputerTask addComputer(Computer computer) {
        return Tasks.instrumented(addComputerTask.class, computer);
    }

}
