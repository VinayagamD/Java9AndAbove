package com.vinaylogics.corejavatraining.oops.basics.polymorphism;

public class Dog extends Mammal{

    @Override
    public void speak() {
        super.speak();
        System.out.println("Barks");
    }
}
