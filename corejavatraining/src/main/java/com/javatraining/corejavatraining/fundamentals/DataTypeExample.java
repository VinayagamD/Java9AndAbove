package com.javatraining.corejavatraining.fundamentals;

public class DataTypeExample {


    public static class ExampleInnerClass {

    }

    public interface ExampleInterface {
        void sayHi();
    }

    public static void main(String[] args) {
        // Real Numbers
        int i = 1;
        long l = 2L;
        short s = 1;
        byte b = 1;

        // Decimal
        float f = 1.3f;
        double d = 1.3;

        // char
        char a = 'c';

        // boolean
        boolean cond = false;

        // String
        String string = "Hello";

        // Classes
        ExampleInnerClass exampleInnerClass = new ExampleInnerClass();

        // Interfaces
        ExampleInterface exampleInterface = new ExampleInterface() {
            @Override
            public void sayHi() {
                System.out.println("Anonymous object");
            }
        };

        // Array
        int[] intArray = new int[10];
        int[] intArray2 = {0,1,2,3,4,5,6,7,8};
        String[] stringArray = {"a", "b","c"};
    }
}
