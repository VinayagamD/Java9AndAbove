package com.javatraining.corejavatraining.inheritance.overriding;

public class Derived extends Base{

    @Override
    public void testName() {
        System.out.println("Sub class test name method");
    }

    @Override
    public void testAge() {
        this.testName();
        super.testAge();
        System.out.println("Sub class test age method");
    }
}
