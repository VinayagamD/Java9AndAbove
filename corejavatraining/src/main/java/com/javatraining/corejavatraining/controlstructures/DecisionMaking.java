package com.javatraining.corejavatraining.controlstructures;

public class DecisionMaking {

    public static void main(String[] args) {
        checkIfCondition();
        checkIfElseBlockCondition();
        checkIfElseIfBlock();
        checkSwitchCase();
    }

    private static void checkSwitchCase() {
        String day = "";
        switch (day) {
            case "Mon":
                System.out.println("Monday");
                break;
            case "Tue":
                System.out.println("Tue");
            /*case  "Tuesday":
                System.out.println("Tuesday");*/
                break;
            case "Wed":
                System.out.println("Wednesday");
                break;
            case "Thu":
                System.out.println("Thursday");
                break;
            case "Fri":
                System.out.println("Friday");
                break;
            case "Sat":
                System.out.println("Saturday");
                break;
            case "Sun":
                System.out.println("Sunday");
                break;
           default:
                System.out.println(" Wrong Day chosen");
        }
    }

    private static void checkIfElseIfBlock() {
        int a = 10;
        if (a < 5) {
            System.out.println("A is less than 5");
        }else if(a == 5){
            System.out.println("a is equal to 5");
        } else if (a > 5 && a < 10) {
            System.out.println("A is greater than 5 and less than 10");
        } else if(a==10) {
            System.out.println(" A is 10");
        } else {
            System.out.println(" A is greater than 10");
        }
    }

    private static void checkIfElseBlockCondition() {
        if (true) {
            System.out.println("If else if block executed");
        } else {
            System.out.println("If else else block executed");
        }
    }

    private static void checkIfCondition() {
        if (true) {
            System.out.println("If true");
        }

        if (false) {
            System.out.println("Never executed block");
        }

        if (true) /*{*/
            System.out.println("Single Statement");
           /* System.out.println("This statement will execute since it is not under control structure");
        }*/
    }
}
