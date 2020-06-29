package com.vinaylogics.springbasics.springunderstand.model;

import java.io.Serializable;

public class Student implements Serializable {

    private Address address;

    Student(){
        this.address = new Address();
    }


    public Address getAddress() {
        return address;
    }

}
