package com.co.computer.UI;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class homePageUI {
    public static final Target NAME_COMPUTER_FIELD = Target.the("Campo para filtrar por nombre")
            .located(By.id("searchbox"));
    public static final Target FILTER_BUTTON = Target.the("Boton para buscar por el nombre filtrado")
            .located(By.id("searchsubmit"));

    public static final Target COMPUTER_DATABASE_LINK = Target.the("Computer database link")
            .located(By.xpath("//a[@class='fill' and @href='/computers']"));

    public static final Target NEXT_BUTTON = Target.the("Botón siguiente")
            .located(By.xpath("//li[contains(@class,'next')]/a"));

    public static final Target CURRENT_PAGE = Target.the("Página actual")
            .located(By.xpath("//div[@id='pagination']//li[@class='current']/a"));
    public static final Target DONE_MESSAGE = Target.the("Done message")
            .located(By.xpath("//div[@class='alert-message warning']/strong"));
}
