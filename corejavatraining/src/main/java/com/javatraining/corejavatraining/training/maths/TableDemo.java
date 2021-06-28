package com.javatraining.corejavatraining.training.maths;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TableDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.println("Welcome to table program");
        String option;
        do {
            System.out.println("Enter number to get the tables");
            int data = scanner.nextInt();
            for (int i = 1; i <= 10; i++) {
                System.out.println(data + "\tx\t" + i + "\t=\t" + data * i);
            }
            System.out.println();
            System.out.println("Print yes or y to have another table");
            option = scanner.next();
        } while (option.equals("yes") || option.equals("y") || option.equals("Yes")
                || option.equals("YES") || option.equals("Y"));

        System.out.println("Thanks for using our table application. Visit us back!!! :)");
    }
}
