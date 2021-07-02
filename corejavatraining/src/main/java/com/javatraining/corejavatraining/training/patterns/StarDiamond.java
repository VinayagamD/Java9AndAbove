package com.javatraining.corejavatraining.training.patterns;

import java.io.IOException;

public class StarDiamond extends BaseStar implements Application{
    @Override
    public String getPatternName() {
        return "Star Diamond";
    }

    @Override
    public void runApplication() throws IOException {
        welcomeMessage();
        do{
            askRows();
            setPattern("*");
            travelRows(getRows());
            travelRemainingRows(getRows());
        }while (continueApp());
        thankYouMessage();
        close();
    }
}
