package com.co.computer.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.co.computer.UI.homePageUI.NEXT_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class navigateTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        int currentPage = 1; // Comenzamos desde la página 1
        int targetPage = 40;

        while (currentPage < targetPage) {
            // Espera hasta que el botón Next sea visible antes de hacer clic
            actor.attemptsTo(WaitUntil.the(NEXT_BUTTON, isVisible()).forNoMoreThan(5).seconds());
            actor.attemptsTo(Click.on(NEXT_BUTTON));

            currentPage++; // Aumentamos el contador de página
        }
    }

    public static navigateTask untilPage40() {
        return instrumented(navigateTask.class);
    }
}
