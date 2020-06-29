package com.vinaylogics.springbasics.springunderstand.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Loose Coupling Implementation")
class StudentDILooseCoupleTest {

    @Test
    void testCreateEmailPost() {
        Post post = new EmailPost();
        assertNotNull(post);
        assertTrue(post instanceof  EmailPost);
        StudentDILooseCouple studentDILooseCouple = new StudentDILooseCouple(post);
        assertNotNull(studentDILooseCouple);
    }

    @Test
    void testCreateAddressPost() {
        Post post = new AddressPost();
        assertNotNull(post);
        assertTrue(post instanceof  AddressPost);
        StudentDILooseCouple studentDILooseCouple = new StudentDILooseCouple(post);
        assertNotNull(studentDILooseCouple);
    }
}