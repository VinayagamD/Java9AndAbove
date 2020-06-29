package com.vinaylogics.springbasics.springunderstand.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("To Test the DI")
class StudentDITest {

    @DisplayName("Test Creration Object depends on concrete object")
    @Test
    public void testCreateDIObject(){
        Address address = new Address();
        assertNotNull(address);
        StudentDI studentDI = new StudentDI(address);
        assertNotNull(studentDI);
    }
}