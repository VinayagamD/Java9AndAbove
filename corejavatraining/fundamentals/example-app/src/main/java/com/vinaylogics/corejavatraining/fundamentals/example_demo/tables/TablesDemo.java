package com.vinaylogics.corejavatraining.fundamentals.example_demo.tables;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TablesDemo {
    private static final Scanner SCAN = new Scanner(System.in, StandardCharsets.UTF_8);

    public void welcomeMessage(){
        displayLine();
        System.out.println("Welcome to Tables Application");
        System.out.println("Enjoy our application");
        displayLine();
    }

    public void displayLine(){
        System.out.println("****************************************************");
    }

    public void displayDash(){
        System.out.println("----------------------------------------------------");
    }

    public void thankYouMessage(){
        displayLine();
        System.out.println("Thank you for using our application");
        System.out.println("Visit Us Back");
        displayLine();
    }
}
