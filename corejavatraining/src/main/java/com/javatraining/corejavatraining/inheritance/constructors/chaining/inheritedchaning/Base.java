package com.javatraining.corejavatraining.inheritance.constructors.chaining.inheritedchaning;

import java.time.LocalDate;

public class Base {

    String name;
    int age;
    LocalDate dob;

    public Base() {
        System.out.println("============================================");
        System.out.println("No Param Constructor");
    }

    public Base(String name) {
        this();
        System.out.println("Parameter Constructor with name");
        this.name = name;
    }

    public Base(String name, int age) {
        this(name);
        System.out.println("Parameter Constructor with name and age");
        this.age = age;
    }

    public Base(String name, int age, LocalDate dob) {
        this(name,age);
        System.out.println("Parameter Constructor with name,age and dob");
        this.dob = dob;
    }
}
