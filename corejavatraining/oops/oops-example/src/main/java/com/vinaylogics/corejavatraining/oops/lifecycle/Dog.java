package com.vinaylogics.corejavatraining.oops.lifecycle;

public class Dog {

    public void play(){
        System.out.println("Dog Plays");
    }

    public void bark(){
        System.out.println("Dog Runs");
    }

    public void run(){
        System.out.println("Dog Runs");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize");
        throw new NullPointerException();
    }
}
