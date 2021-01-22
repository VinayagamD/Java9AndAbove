package com.javatraining.corejavatraining.inheritance.constructors.chaining;

import java.time.LocalDate;

public class TestConstructorChain {

    private String name;

    public static void main(String[] args) {
        ConstructorChaining chaining = new ConstructorChaining();
        chaining = new ConstructorChaining("Test Name");
        chaining = new ConstructorChaining("Test Name", 25);
        chaining = new ConstructorChaining("Test Name", 25, LocalDate.now());
    }

    public void setName(String name) {
        this.name = name;
    }
}
