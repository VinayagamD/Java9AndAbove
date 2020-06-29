package com.vinaylogics.springbasics.springunderstand.model;

import java.io.Serializable;

public class StudentDI implements Serializable {

    private Address address;

    public StudentDI(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
