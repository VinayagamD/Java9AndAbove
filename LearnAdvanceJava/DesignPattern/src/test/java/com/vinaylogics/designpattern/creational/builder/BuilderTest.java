package com.vinaylogics.designpattern.creational.builder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuilderTest {

    @Test
    @DisplayName("Test person builder with name creation")
    public void testBuilder_Name(){
        String expectedName = "Santhosh";
        Person person = new Person.PersonBuilder().name(expectedName).build();
        assertNotNull(person);
        assertNull(person.getDob());
        assertNull(person.getGender());
        assertNotNull(person.getName());
        assertSame( expectedName, person.getName());
    }

}