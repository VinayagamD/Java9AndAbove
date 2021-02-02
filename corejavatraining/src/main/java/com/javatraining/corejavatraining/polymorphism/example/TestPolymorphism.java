package com.javatraining.corejavatraining.polymorphism.example;

public class TestPolymorphism {

    public static void main(String[] args) {
        Object object = new SubDerived(); // polymorphism
        // SubDerived subDerived = new Object(); // This not possible because object does not c class metadata
        ((Base) object).testBaseMethod();
        ((Derived) object).testBaseMethod();
        ((Derived) object).testDerivedMethod();
        ((SubDerived)object).testBaseMethod();
        ((SubDerived)object).testDerivedMethod();
        ((SubDerived)object).testSubDerived();
    }
}
