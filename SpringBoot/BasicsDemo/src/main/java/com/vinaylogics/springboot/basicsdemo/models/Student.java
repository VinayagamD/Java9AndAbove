package com.vinaylogics.springboot.basicsdemo.models;

import lombok.Data;

@Data
public class Student {

    Person person;

    public Student() {
    }

    public Student(Person person) {
        this.person = person;
    }

}
