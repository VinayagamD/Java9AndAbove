package com.javatraining.corejavatraining.training.patterns;

import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;

public abstract class BasePattern implements Closeable {
    private static final Scanner SCANNER = new Scanner(System.in);

    private int rows;
    private String pattern;
    /**
     * Print Welcome Message
     */
    public void welcomeMessage(){
        System.out.println("Welcome to Pattern application");
    }

    /**
     * This method helps to return pattern name
     * @return pattern Name
     */
    public abstract String getPatternName();

    public boolean continueApp(){
        System.out.println("Do you want to continue "+getPatternName()+"?");
        System.out.println("Then Press Yes or Y");
        String option = SCANNER.next();
        return option.equalsIgnoreCase("Yes") || option.equalsIgnoreCase("Y");
    }

    public void askRows(){
        System.out.println("Enter number of rows for printing pattern "+getPatternName());
        rows = SCANNER.nextInt();
    }



    /**
     * This method helps to print the thank you application
     */
    public void thankYouMessage(){
        System.out.println("Thank you for using the pattern application");
        System.out.println("Visit us again :)");
    }

    public static Scanner getScanner() {
        return SCANNER;
    }

    public int getRows() {
        return rows;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public void close() throws IOException {
        SCANNER.close();
    }
}
