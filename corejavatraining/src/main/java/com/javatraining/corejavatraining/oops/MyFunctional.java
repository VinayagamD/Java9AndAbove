package com.javatraining.corejavatraining.oops;

@FunctionalInterface
public interface MyFunctional {
    void applyRegister();

    default void testDefaultMethod(){
        System.out.println("Test Default Method");
    }

    static void testStaticMethod(){
        System.out.println("Test Static Method");
    }

//    void anotherMethod(); // This is not allowed in functional interface
}
