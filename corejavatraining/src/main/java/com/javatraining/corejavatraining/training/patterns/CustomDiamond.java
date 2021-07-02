package com.javatraining.corejavatraining.training.patterns;

import java.io.IOException;

public class CustomDiamond extends BaseStar implements Application{

    @Override
    public String getPatternName() {
        return "Custom Diamond";
    }

    @Override
    public void runApplication() throws IOException {
        welcomeMessage();
        do{
            askRows();
            askPatterns();
            travelRows(getRows());
            travelRemainingRows(getRows());
        }while (continueApp());
        thankYouMessage();
        close();
    }
}
