package com.vinaylogics.springboot.springdatavalidation.exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message) {
        super(message);
    }
}
