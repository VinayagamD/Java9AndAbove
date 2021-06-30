package com.javatraining.corejavatraining.oops_basics.constructors;

public class Sample {

    int data;
    String message;

    // Overridden No Param Constructor
    public Sample() {
        System.out.println("No Param  Constructor");
    }

    // Overload
    public Sample(int data) {
        System.out.println("Parametrized Constructor with int data ="+data);
        this.data = data;
    }

    public Sample(String message) {
        System.out.println("Parametrized Constructor with string message ="+message);
        this.message = message;
    }

    public Sample(int data, String message) {
        System.out.println("Parametrized Constructor with int data ="+data+" and message="+message);
        this.data = data;
        this.message = message;
    }

    public static void main(String[] args) {
        Sample sample = new Sample();
        System.out.println(sample.data);
        System.out.println(sample.message);

        sample = new Sample(10);
        System.out.println(sample.data);
        System.out.println(sample.message);

        sample = new Sample("10");
        System.out.println(sample.data);
        System.out.println(sample.message);

        sample = new Sample(10,"10");
        System.out.println(sample.data);
        System.out.println(sample.message);
    }
}
