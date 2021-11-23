package com.vinaylogics.corejavatraining.oops.polymorphism;

public class Dog extends Mammal{

    @Override
    public void speak() {
        super.speak();
        System.out.println("Barks");
    }
}
