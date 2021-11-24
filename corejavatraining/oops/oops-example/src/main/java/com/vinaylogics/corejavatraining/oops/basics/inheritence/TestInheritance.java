package com.vinaylogics.corejavatraining.oops.basics.inheritence;

public class TestInheritance {
    public static void main(String[] args) {
//        Base base = new SubClass();
//        SubClass subClass = new Base();
        Base base = new Base();
        base.baseMethod();
        SubClass subClass = new SubClass();
        subClass.subMethod();
        subClass.baseMethod();
    }
}
