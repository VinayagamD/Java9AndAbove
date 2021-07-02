package com.javatraining.corejavatraining.training.patterns;

import java.io.IOException;

public class CustomPyramid extends BaseStar implements Application{

    @Override
    public String getPatternName() {
        return "Custom Pyramid";
    }

    @Override
    public void runApplication() throws IOException {
        welcomeMessage();
        do{
            askRows();
            askPatterns();
            travelRows(getRows());
        }while (continueApp());
        thankYouMessage();
        close();
    }
}
