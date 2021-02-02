package com.javatraining.corejavatraining.abtsraction.interface_types;

public class TestInterface {

    public static void main(String[] args) {
        EgInterface egInterface = new EgInterface() {
            @Override
            public void testMethod() {

            }
        };

        MyFunctionalInterface myFunctionalInterface = () -> {
            System.out.println("Test Method");
        };
        MyFunctionalInterface myFunctionalInterface2 = () -> System.out.println("Test Method");
    }
}
