package com.javatraining.corejavatraining.inheritance.constructors.chaining.inheritedchaning;

public class Derived2 extends Base2{
    public Derived2(String name) {
        // System.out.println("Test Name");
        super(name);
    }

    public Derived2(){
        super("");
    }
}
