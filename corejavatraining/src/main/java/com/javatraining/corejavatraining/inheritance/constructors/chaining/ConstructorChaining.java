package com.javatraining.corejavatraining.inheritance.constructors.chaining;

import java.time.LocalDate;

public class ConstructorChaining {

    String name;
    int age;
    LocalDate dob;

    public ConstructorChaining() {
        System.out.println("============================================");
        System.out.println("No Param Constructor");
    }

    public ConstructorChaining(String name) {
        this();
        System.out.println("Parameter Constructor with name");
        this.name = name;
    }

    public ConstructorChaining(String name, int age) {
        this(name);
        System.out.println("Parameter Constructor with name and age");
        this.age = age;
    }

    public ConstructorChaining(String name, int age, LocalDate dob) {
        this(name,age);
        System.out.println("Parameter Constructor with name,age and dob");
        this.dob = dob;
    }

}
