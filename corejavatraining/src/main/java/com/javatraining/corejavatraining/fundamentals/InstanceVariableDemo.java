package com.javatraining.corejavatraining.fundamentals;

public class InstanceVariableDemo {

    private String a;

    public static void main(String[] args) {
        int a = 0;
        InstanceVariableDemo ivDemo = new InstanceVariableDemo();
        System.out.println(ivDemo.a);
        System.out.println(a);
        System.out.println(ivDemo.b);
        System.out.println(ivDemo);
        System.out.println(ivDemo.getClass().getName());
        System.out.println(Integer.toHexString(ivDemo.hashCode()));
    }

    private double b;
}
