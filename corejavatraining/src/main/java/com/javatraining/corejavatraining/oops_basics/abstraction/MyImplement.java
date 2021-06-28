package com.javatraining.corejavatraining.oops_basics.abstraction;

public class MyImplement extends MyAbstract implements MyInterface, MyMarker{
    @Override
    public void testMethod2() {
        System.out.println("Test Method2");
    }

    @Override
    public void testMethod3() {
        System.out.println("Test Method3");
    }

    @Override
    public void test() {
        System.out.println("Test");
    }
}
