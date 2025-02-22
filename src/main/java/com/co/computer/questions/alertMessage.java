package com.co.computer.questions;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.Alert;

public class alertMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(By.id("com.android.systemui:id/snackbar_text")).answeredBy(actor);

    }

    public static alertMessage es() {
        return new alertMessage();
    }
}
