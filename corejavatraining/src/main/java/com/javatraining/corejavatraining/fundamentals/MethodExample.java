package com.javatraining.corejavatraining.fundamentals;

/**
 * This class provides the method classification example
 */
public class MethodExample {

    /**
     * This method is the starting method in the java console
     * @param args : command line arguments passed during running
     */
    public static void main(String[] args) {
        dummyFunction();
        System.out.println(workAroundFunction());
        workAroundFunction(10, 20L);
        System.out.println(sum(10,20));
    }

    private static int sum(int a, int b) {
        return a+b;
    }

    private static void workAroundFunction(int i, long l) {
        System.out.println("Int i = "+i);
        System.out.println("Long l = "+l);
    }

    /**
     * This work around function with string return type
     * @return fixed String value provided
     */
    private static String workAroundFunction() {
        return "Work Around Function";
    }

    /**
     * This example function to show dummy function
     */
    private static void dummyFunction() {
        System.out.println("Hello to dummy function");
    }

}
