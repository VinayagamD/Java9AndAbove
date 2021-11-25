package com.vinaylogics.corejavatraining.oops.inheritance.constructorchaining;

public class ConstructorChaining {

    public ConstructorChaining() {
        System.out.println("No Param Constructor");
    }
    public ConstructorChaining(int x) {
        this();
        System.out.println(x);
        System.out.println("Constructor with single param");
    }

    public ConstructorChaining(int x, int y) {
        this(x);
        System.out.println(y);
        System.out.println("Constructor with two param");
    }

}
