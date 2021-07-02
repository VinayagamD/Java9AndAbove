package com.javatraining.corejavatraining.training.patterns;

import java.io.IOException;

public class StarPyramid extends BaseStar implements Application{

    @Override
    public String getPatternName() {
        return "Star Pyramid";
    }

    @Override
    public void runApplication() throws IOException {
        welcomeMessage();
        do{
            askRows();
            setPattern("*");
            travelRows(getRows());
        }while (continueApp());
        thankYouMessage();
        close();
    }
}
