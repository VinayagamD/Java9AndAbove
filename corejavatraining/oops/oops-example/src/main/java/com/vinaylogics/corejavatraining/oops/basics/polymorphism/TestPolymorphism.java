package com.vinaylogics.corejavatraining.oops.basics.polymorphism;

public class TestPolymorphism {

    public static void main(String[] args) {
        Object human = new Human();
        System.out.println(human.toString());
        ((Mammal)human).speak();
        ((Human)human).speak();
        Object dog = new Dog();
        System.out.println(dog.toString());
        ((Dog)dog).speak();

    }
}
