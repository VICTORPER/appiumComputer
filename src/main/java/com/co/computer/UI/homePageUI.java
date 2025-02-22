package com.co.computer.UI;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class homePageUI {
    public static final Target NAME_COMPUTER_FIELD = Target.the("Campo para filtrar por nombre")
            .located(By.id("searchbox"));
    public static final Target FILTER_BUTTON = Target.the("Boton para buscar por el nombre filtrado")
            .located(By.id("searchsubmit"));

    public static final Target Compare = Target.the("Capture name")
            .locatedBy("//em[text()='Nothing to display']");

    public static final Target NEXT_BUTTON = Target.the("Botón siguiente")
            .located(By.xpath("//li[contains(@class,'next')]/a"));

    private static final Target PAGE_40 = Target.the("Página 40")
            .located(By.xpath("//div[@id='pagination']//li[@class='current']/a[contains(text(),'391 to 400')]"));

    public static final Target CURRENT_PAGE = Target.the("Página actual")
            .located(By.xpath("//div[@id='pagination']//li[@class='current']/a"));

}
