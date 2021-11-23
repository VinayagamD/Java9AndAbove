package com.vinaylogics.corejavatraining.oops.polymorphism;

public class Mammal implements Animal{
    @Override
    public void speak() {
        System.out.println("Mammal does not have specific sound");
    }
}
