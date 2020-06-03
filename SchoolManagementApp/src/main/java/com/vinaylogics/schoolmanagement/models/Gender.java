package com.vinaylogics.schoolmanagement.models;

public enum Gender {
    MALE("MALE"),
    FEMALE("FEMALE"),
    OTHERS("OTHERS");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
