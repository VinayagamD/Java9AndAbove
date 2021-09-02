package com.vinaylogics.corejavatraining.fundamentals.example_demo.calculator;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalculatorDemo {
    private static final Scanner SCAN = new Scanner(System.in, StandardCharsets.UTF_8);

    private static final Map<Integer,String> OPTION_MENU =
            new HashMap<>() {{
                put(1, "Addition");
                put(2, "Subtraction");
                put(3, "Multiplication");
                put(4, "Division");
                put(5, "Modulus");
            }};

    public void welcomeMessage(){
        displayLine();
        System.out.println("Welcome to Calculator Application");
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

    public void displayMenu(){
        System.out.println("Use Below Mention for operation");
        displayLine();
        OPTION_MENU.forEach((key,value) -> System.out.println(key +"\t:\t" + value));
        displayLine();
    }

    public int askMenu(){
        System.out.println("Choose any one of the above option");
        return SCAN.nextInt();
    }

    public boolean validMenu(int option){
        return OPTION_MENU.containsKey(option);
    }

    public void displayMessage(String message, boolean error) {
        if (error) {
            System.err.println(message);
        } else {
            System.out.println(message);
        }
    }

    public int askInput(int option, String input){
        System.out.println("Enter input "+input+" for selected operation "+OPTION_MENU.get(option)+".");
        return SCAN.nextInt();
    }

    public boolean validateInput(int option, int input2){
        if(option == 4 || option == 5){
            return input2 != 0;
        }

        return true;
    }

    public int processOperation(int option, int input1, int input2){
        return switch (option){
            case 1 -> processAddition(input1, input2);
            case 2 -> processSubtraction(input1, input2);
            case 3 -> processMultiplication(input1, input2);
            case 4 -> processDivision(input1, input2);
            case 5 -> processModulus(input1, input2);
            default -> -1;
        };
    }

    public int processAddition(int input1, int input2){
        return input1 + input2;
    }

    public int processSubtraction(int input1, int input2){
        return input1 - input2;
    }

    public int processMultiplication(int input1, int input2){
        return input1 * input2;
    }

    public int processDivision(int input1, int input2){
        return input1 / input2;
    }

    public int processModulus(int input1, int input2){
        return input1 % input2;
    }

    public void displayOutput(int option, int input1, int input2,int result){
        System.out.println();
        displayDash();
        displayMessage("For the operation "+ OPTION_MENU.get(option) , false);
        displayDash();
        displayMessage("Provided Inputs ", false);
        displayMessage("Input1 --> " + input1, false);
        displayMessage("Input2 --> " + input2, false);
        displayDash();
        displayMessage("Result:", false);
        displayMessage(String.valueOf(result), false);
        displayDash();
        System.out.println();
    }

    public boolean askToContinue(){
        System.out.println();
        displayDash();
        System.out.println();
        displayMessage("Enter yes or y to perform another operation.", false);
        String enteredValue = SCAN.next();
        System.out.println();
        return enteredValue.equalsIgnoreCase("Yes") || enteredValue.equalsIgnoreCase("y");
    }

    public void runApplication(){
        welcomeMessage();
        do {
            displayMenu();
            int selectedOption = askMenu();
            if (validMenu(selectedOption)) {
                int input1 = askInput(selectedOption, "input1");
                int input2 = askInput(selectedOption, "input2");
                if (validateInput(selectedOption, input2)) {
                    int result = processOperation(selectedOption, input1, input2);
                    displayOutput(selectedOption, input1, input2, result);
                } else {
                    displayMessage("You have selected invalid input2 = 0 for prescribed operation "
                            + OPTION_MENU.get(selectedOption), true);
                }
            } else {
                displayMessage("You have selected invalid menu", true);
            }
        }while (askToContinue());
        thankYouMessage();
        SCAN.close();
    }

    public static void main(String[] args) {
        CalculatorDemo calculatorDemo = new CalculatorDemo();
        calculatorDemo.runApplication();
    }
}
