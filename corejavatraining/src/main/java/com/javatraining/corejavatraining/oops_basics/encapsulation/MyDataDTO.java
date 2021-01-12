package com.javatraining.corejavatraining.oops_basics.encapsulation;

public class MyDataDTO {

    private Long id;
    private String name = "Test Name";

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
