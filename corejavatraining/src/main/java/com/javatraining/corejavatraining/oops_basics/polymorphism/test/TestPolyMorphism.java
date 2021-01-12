package com.javatraining.corejavatraining.oops_basics.polymorphism.test;

import com.javatraining.corejavatraining.oops_basics.polymorphism.Base;
import com.javatraining.corejavatraining.oops_basics.polymorphism.Derived;

public class TestPolyMorphism {

    public static void main(String[] args) {
        Object base = new Derived();
        ((Base)base).testMethod();
        ((Derived) base).testSubMethod();
    }
}
