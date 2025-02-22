package com.co.computer.questions;

import com.co.computer.UI.homePageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class messageDone implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(homePageUI.DONE_MESSAGE).answeredBy(actor);
    }
    public static messageDone done(){
        return new messageDone();
    }
 }

