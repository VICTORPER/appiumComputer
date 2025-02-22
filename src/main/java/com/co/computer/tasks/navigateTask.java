package com.co.computer.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.co.computer.UI.homePageUI.CURRENT_PAGE;
import static com.co.computer.UI.homePageUI.NEXT_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class navigateTask implements Task {

    private static final int TARGET_PAGE = 40;

    @Override
    public <T extends Actor> void performAs(T actor) {
        int currentPage = 1; // Inicializamos en página 1
        int lastPage = 0; // Para detectar si nos quedamos atrapados

        while (currentPage < TARGET_PAGE) {
            // Extraer número de la página actual
            String currentPageText = Text.of(CURRENT_PAGE).answeredBy(actor);
            currentPage = extractPageNumber(currentPageText);

            System.out.println("Página actual: " + currentPage);

            // Si la página no avanza después de un intento, salimos del loop
            if (currentPage == lastPage) {
                System.out.println("Advertencia: La página no está avanzando. Saliendo del loop.");
                break;
            }
            lastPage = currentPage;

            // Si aún no estamos en la página 40, intentamos avanzar
            if (currentPage < TARGET_PAGE) {
                actor.attemptsTo(
                        WaitUntil.the(NEXT_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
                        Click.on(NEXT_BUTTON)
                );
            }
        }

        System.out.println("Se alcanzó la página " + currentPage + " o se detuvo la navegación.");
    }


    private int extractPageNumber(String pageText) {
        try {
            String[] parts = pageText.split(" ");
            int firstItem = Integer.parseInt(parts[1]); // "Displaying 1 to 10 of 574" → toma "1"
            return (firstItem - 1) / 10 + 1; // Convierte el índice en número de página
        } catch (Exception e) {
            System.out.println("Error al extraer número de página. Usando 1 por defecto.");
            return 1;
        }
    }

    public static navigateTask untilPage40() {
        return instrumented(navigateTask.class);
    }
}
