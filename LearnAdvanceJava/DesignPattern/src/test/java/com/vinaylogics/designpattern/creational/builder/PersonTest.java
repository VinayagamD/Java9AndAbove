package com.vinaylogics.designpattern.creational.builder;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;

class PersonTest {

    private Faker faker;

    @BeforeEach
    public void setUp(){
        faker = new Faker();
    }

    @Test
    public void testCreatePerson(){
        Person person = new Person.PersonBuilder()
                .name(faker.name().name())
                .dob(LocalDate.ofInstant(faker.date().birthday().toInstant(), ZoneId.systemDefault()))
                .gender(Gender.FEMALE)
                .build();
        Assertions.assertNotNull(person);
        Assertions.assertNotNull(person.getName());
        Assertions.assertNotNull(person.getDob());
        Assertions.assertNotNull(person.getGender());
        Assertions.assertNull(person.getJobType());
        Assertions.assertNull(person.getNationality());
    }

}