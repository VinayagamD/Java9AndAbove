package com.javatraining.corejavatraining.oops_basics.inheritance;

public class Derived extends Base{

    @Override
    public void testMethod() {
        System.out.println("Test Method From Derived");
    }

    public void testSubMethod(){
        System.out.println("Sub Method from Derived");
    }
}
