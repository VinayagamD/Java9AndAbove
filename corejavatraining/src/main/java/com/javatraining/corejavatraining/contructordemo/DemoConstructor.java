package com.javatraining.corejavatraining.contructordemo;

public class DemoConstructor {
    int data;
    String name;
    /*public DemoConstructor(int data, String name) {
        this.data = data;
        this.name = name;
    }*/

    public static void main(String[] args) {
        new DemoConstructor();
        Child child = new Child();
    }
}
