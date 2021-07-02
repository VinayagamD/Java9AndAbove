package com.javatraining.corejavatraining.training.patterns;

public class PatternOption implements OptionStar {

    @Override
    public void askOption() {
        System.out.println("Enter Options for Patterns for below list");
        System.out.println("1 : for Star Pyramid");
        System.out.println("2 : for Star Diamond");
        System.out.println("3 : for Custom Pyramid");
        System.out.println("4 : for Custom Diamond");
    }

    @Override
    public int getOptions() {
        return BasePattern.getScanner().nextInt();
    }

    @Override
    public Application getStar(int option) {
        return switch (option) {
            case 1 -> new StarPyramid();
            case 2 -> new StarDiamond();
            case 3 -> new CustomPyramid();
            default -> new CustomDiamond();
        };
    }
}
