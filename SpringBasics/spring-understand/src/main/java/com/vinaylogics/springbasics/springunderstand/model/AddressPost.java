package com.vinaylogics.springbasics.springunderstand.model;

public class AddressPost implements Post {
    @Override
    public void doPost() {
        System.out.println("Address Post");
    }
}
