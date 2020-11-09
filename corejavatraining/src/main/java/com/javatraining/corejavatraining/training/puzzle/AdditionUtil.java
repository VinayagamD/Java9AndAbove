/*
    This class requirement to add 2 numbers provide by user and print the result
    1) Create a 2 variable to take input from the user num1 and num2
    2) Store addition result of num1 and num2 to result i.e., sum = num1 + num2
    3) print the result 'sum' in console
 */

package com.javatraining.corejavatraining.training.puzzle;

import java.util.Scanner;

/**
 * This AdditionUtils class helps us to add number provided by the user
 */
public class AdditionUtil {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * This function helps to take input from the user
     * @param data input number
     * @return entered input for data as int
     * @throws RuntimeException when user enters other integer
     */
    public int getUserInput(String data){
        System.out.println("Read input for "+data);
        return scanner.nextInt();
    }

    /**
     * This is the business logic function to add data
     * @param data1 : input 1 for addition
     * @param data2 : input 2 for addition
     * @return sum of the result data1 and data2
     */
    public int processResult(int data1, int data2){
        return data1+data2;
    }

    /**
     * This function used to print final result of data
     * @param result : result of the addition
     */
    public void printResult(int result){
        System.out.println("The result of addition = " + result);
    }

    /**
     * This is the application function to run algorithm
     */
    public void runUtilApplication(){
        // Get User Input
        int data1 = getUserInput("data1");
        int data2 = getUserInput("data2");
        // Process the result
        int result = processResult(data1, data2);
        // Print the result
        printResult(result);
    }
    public static void main(String[] args) {
      AdditionUtil additionUtil = new AdditionUtil();
      additionUtil.runUtilApplication();
    }
}
