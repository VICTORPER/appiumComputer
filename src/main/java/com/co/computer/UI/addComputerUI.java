package com.co.computer.UI;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class addComputerUI {

    public static final Target ADD_BUTTON = Target.the("Botón de ADD")
            .located(By.id("add"));

    public static final Target NAME_FIELD = Target.the("campo de usuario")
            .located(By.id("name"));

    public static final Target INTRODUCED_FIELD = Target.the("INICIO")
            .located(By.id("introduced"));

    public static final Target DISCONTINUED_FIELD = Target.the("Campo discontinuo")
            .located(By.id("discontinued"));

    public static final Target COMPANY_FIELD = Target.the("Campo company")
            .located(By.id("company"));
    public static final Target BUTTON_CONFIRM = Target.the("Boton confirmar")
            .located(By.cssSelector("input[type='submit']"));
    public static final Target Compare = Target.the("Capture name")
            .locatedBy("//em[text()='Nothing to display']");
}
