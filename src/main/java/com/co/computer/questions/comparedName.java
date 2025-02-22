package com.co.computer.questions;

import com.co.computer.UI.addComputerUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class comparedName implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(addComputerUI.Compare).answeredBy(actor);
    }
    public static comparedName compare(){
        return new comparedName();
    }
}

