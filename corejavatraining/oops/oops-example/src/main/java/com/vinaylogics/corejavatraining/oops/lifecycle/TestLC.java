package com.vinaylogics.corejavatraining.oops.lifecycle;

public class TestLC {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.play();
        dog.run();
        dog.bark();

        {
            Dog dog1 = new Dog();
            dog1.play();
            dog1.run();
            dog1.bark();
        }

//        dog1 // Invisible
        dog = null; // unreachable
//        dog.bark();
        System.gc();
//        Runtime.getRuntime().gc();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Dog Clean");
        throw new NullPointerException();
    }
}
