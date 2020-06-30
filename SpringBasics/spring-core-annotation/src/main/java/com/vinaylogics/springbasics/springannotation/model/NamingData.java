package com.vinaylogics.springbasics.springannotation.model;

public class NamingData {

    private String names;

    public NamingData(String names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "NamingData{" +
                "names='" + names + '\'' +
                '}';
    }
}
