package com.javatraining.corejavatraining.training.cs;

import java.util.Scanner;

public class LeapYear {

    /*
     * Every 4 years once you will get a leap year
     * divide year by 4 should be zero
     * year is divisible by 100 then that should be divisible by 400
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to my Leap Year application");
        String continueData;
        do {
            System.out.println("Enter year to check leap year or not");
            // Require year
            int year = scanner.nextInt();
            // If year divisible by 100 it should divisible by 400
            // or Year should be divisible by 4
            if((year%100 == 0 && year%400 ==0)||year%4==0){
                System.out.println("Entered year "+year+" is a leap year");
            } else {
                // else not a leap year
                System.out.println("Entered year "+year+" is not a leap year");
            }
            System.out.println("Enter yes or y to continue the application");
            continueData = scanner.next();
        }while (continueData.equalsIgnoreCase("y") || continueData.equalsIgnoreCase("Yes"));

        System.out.println("Thank you for using the leap year application");
        System.out.println("Visit us again :)");
    }
}
