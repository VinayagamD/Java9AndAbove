package com.vinaylogics.corejavatraining.packages.demo.enums;

public enum Data{
    DAY1("day1"),
    DAY2("day2"),
    DAY3("day3");

    private final String day;

    Data(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }
}
