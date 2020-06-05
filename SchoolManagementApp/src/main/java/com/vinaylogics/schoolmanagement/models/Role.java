package com.vinaylogics.schoolmanagement.models;

import com.google.gson.annotations.SerializedName;

public enum Role {
    @SerializedName("TEACHER")
    TEACHER("TEACHER"),
    @SerializedName("STUDENT")
    STUDENT("STUDENT");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
