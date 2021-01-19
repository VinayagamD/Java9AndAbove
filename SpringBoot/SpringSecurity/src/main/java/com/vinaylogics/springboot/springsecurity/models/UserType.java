package com.vinaylogics.springboot.springsecurity.models;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum UserType {
    ADMIN,
    USER
}
