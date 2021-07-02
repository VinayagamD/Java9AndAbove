package com.javatraining.corejavatraining.training.patterns;

import java.io.IOException;

public class RunPatterns {

    public static void main(String[] args) throws IOException {
        OptionStar star = new PatternOption();
        star.askOption();
        Application application = star.getStar(star.getOptions());
        application.runApplication();
    }
}
