package com.javatraining.corejavatraining.oopsdetails.polymorphism;

public class CompileTime {

    public static int multiply(int a, int b){
        return a*b;
    }

    public static double multiply(double a, double b){
        return a*b;
    }

    int iMultiply(int a, int b){
        return a*b;
    }
    double iMultiply(double a, double b){
        return a*b;
    }


    public static void main(String[] args) {
        CompileTime compileTime = new CompileTime();
        System.out.println(multiply(10,20));
        System.out.println(compileTime.iMultiply(10,20));
        System.out.println(multiply(10.5,20.6));
        System.out.println(compileTime.iMultiply(10.5,20.6));
    }
}
