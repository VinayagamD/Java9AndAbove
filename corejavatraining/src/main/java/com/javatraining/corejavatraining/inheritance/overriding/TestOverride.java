package com.javatraining.corejavatraining.inheritance.overriding;

public class TestOverride {

    public static void main(String[] args) {
        System.out.println("When called base object");
        Base base = new Base();
        base.testName();
        base.testAge();

        System.out.println("When called by derived object");
        base = new Derived();
        base.testName();
        base.testAge();

    }
}
