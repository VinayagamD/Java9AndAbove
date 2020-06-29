package com.vinaylogics.springbasics.springunderstand.model;


public class EmailPost implements Post {
    @Override
    public void doPost() {
        System.out.println("Email Post");
    }
}
