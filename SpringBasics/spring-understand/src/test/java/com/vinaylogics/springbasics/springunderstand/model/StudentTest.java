package com.vinaylogics.springbasics.springunderstand.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Understand Dependency Injection")
class StudentTest {

    @DisplayName("Test Without Dependency Injection")
    @Test
    public void testCreateStudent(){
        Student student = new Student();
        assertNotNull(student);
        assertNotNull(student.getAddress());
    }

}