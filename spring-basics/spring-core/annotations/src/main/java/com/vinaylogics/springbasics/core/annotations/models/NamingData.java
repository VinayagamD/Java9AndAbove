package com.vinaylogics.springbasics.core.annotations.models;

public class NamingData {

    private String name;

    public NamingData(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NamingData{" +
                "name='" + name + '\'' +
                '}';
    }
}
