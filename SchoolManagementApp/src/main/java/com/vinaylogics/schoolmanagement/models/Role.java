package com.vinaylogics.schoolmanagement.models;

public enum Role {
    TEACHER("TEACHER"),
    STUDENT("STUDENT");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
