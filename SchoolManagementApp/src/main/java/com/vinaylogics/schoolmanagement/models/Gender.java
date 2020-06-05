package com.vinaylogics.schoolmanagement.models;

import com.google.gson.annotations.SerializedName;

public enum Gender {
    @SerializedName("MALE")
    MALE("MALE"),
    @SerializedName("FEMALE")
    FEMALE("FEMALE"),
    @SerializedName("OTHERS")
    OTHERS("OTHERS");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
