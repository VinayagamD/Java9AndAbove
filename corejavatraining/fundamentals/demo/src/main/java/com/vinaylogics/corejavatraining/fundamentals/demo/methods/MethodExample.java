package com.vinaylogics.corejavatraining.fundamentals.demo.methods;

public class MethodExample {

    public static void main(String[] args) {
        dummyFunction();
        printMessage("Java Session for Vishal and Akbar");
        printMessage("Welcome to Java Class");
        System.out.println(getMessage());
        System.out.println(isEven(2)?"Even": "Odd");
        System.out.println(isEven(9)?"Even": "Odd");

        // function overloading

        test();
        test(10);
        test("Java");
        test(10,20);
    }

    /**
     * This is the dummy function to show dummy function example
     */
    static void dummyFunction(){
        System.out.println("Inside Dummy Function");
    }

    // Work around/hard function

    /**
     * This message helps to print the passed message
     * @param message : to be printed in the console
     */
    static void printMessage(String message){
        System.out.println(message);
    }

    /**
     * These methods help to return custom message
     * @return message in string type
     */
    static String getMessage(){
        return "Welcome to Java Class Session";
    }

    // Smart Function

    /**
     * This method helps to check given number is even or odd
     * @param input : number to check
     * @return true if input is even else false
     */
    static boolean isEven(int input){
        return input%2 == 0;
    }

    // method overloading
    static void  test(){
        System.out.println("Test");
    }

    /*
    static int test(){
        return 0;
    }
    */
    static void test(int a){
        System.out.println("Int a ="+a);
    }

    static void test(String a){
        System.out.println("String a = "+a);
    }

    static void test(int a, int b){
        System.out.println("Int a = "+a+", Int b = "+b);
    }
}
