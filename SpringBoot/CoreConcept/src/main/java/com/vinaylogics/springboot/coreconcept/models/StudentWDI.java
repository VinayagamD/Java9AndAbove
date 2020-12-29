package com.vinaylogics.springboot.coreconcept.models;

public class StudentWDI {
    Address address;

    public StudentWDI() {
    }

    public StudentWDI(Address address) {
        if(address == null)
            throw new NullPointerException("Address Cannot Be Null");
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
