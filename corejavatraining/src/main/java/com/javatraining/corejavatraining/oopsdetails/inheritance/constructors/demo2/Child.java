package com.javatraining.corejavatraining.oopsdetails.inheritance.constructors.demo2;

public class Child extends Parent{

    /**
     * Example 1 Constructor Matching Parent
     * @param a : to initialize parent constructor
     */
    public Child(int a) {
        super(a);
    }

    /**
     * Example 2: No param Constructor,
     * Constructor Not Matching Parent
     */
    public Child(){
        super(10);
    }
}
