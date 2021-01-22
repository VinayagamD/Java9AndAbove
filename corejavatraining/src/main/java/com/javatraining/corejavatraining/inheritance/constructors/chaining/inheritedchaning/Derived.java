package com.javatraining.corejavatraining.inheritance.constructors.chaining.inheritedchaning;

import java.time.LocalDate;

public class Derived extends Base{
    String name;
    public Derived() {
    }

    public Derived(String name) {
        super(name);
    }

    public Derived(String name, int age) {
        super(name, age);
    }

    public Derived(String name, int age, LocalDate dob) {
        super(name, age, dob);
    }

    public void testName(String name, int age){
        this.name = name;
        super.name = name;
        this.age = age;
    }
}
