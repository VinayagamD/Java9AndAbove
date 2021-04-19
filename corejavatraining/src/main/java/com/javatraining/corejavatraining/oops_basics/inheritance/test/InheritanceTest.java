package com.javatraining.corejavatraining.oops_basics.inheritance.test;

import com.javatraining.corejavatraining.oops_basics.inheritance.Base;
import com.javatraining.corejavatraining.oops_basics.inheritance.Derived;

public class InheritanceTest {
    public static void main(String[] args) {
        Base base = new Base();
        base.testMethod();
        Derived derived = new Derived();
        derived.testMethod();
        derived.testSubMethod();
        base = new Derived();
        base.testMethod();
    }
}
