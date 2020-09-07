package com.javatraining.corejavatraining.contructordemo;

public class Parent {

    private String data;

    public Parent(String data) {
        this();
        System.out.println("Param constructor data "+data);
        this.data = data;
    }

    public Parent(){
        System.out.println("No Param Constructor");
    }
}
