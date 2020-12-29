package com.vinaylogics.springboot.coreconcept.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This Class provides to unit test for Dependency Injection
 *
 * @see Test
 * @see DisplayName
 *
 * <hr>
 * <a href="https://junit.org/junit5/">Junit 5<a/> <br>
 * <a href="https://junit.org/junit5/docs/current/api/">Javadoc<a/> <br>
 * <a href="https://junit.org/junit5/docs/current/user-guide/">UserGuide<a/> <br>
 *
 * @author vinay
 * @since 24-12-2020
 */
class DITest {

    /**
     * (non-javadoc)
     * {@link StudentWODI}
     */
    @Test
    @DisplayName("To Object Creation Without Dependency Injection")
    public void testObjectCreation_WithoutDI_AddressNull(){
        StudentWODI studentWODI = new StudentWODI();
        assertNotNull(studentWODI);
        assertNull(studentWODI.getAddress());
    }

    /**
     * (non-javadoc)
     * {@link StudentWODI#setAddress(Address)}
     */
    @Test
    @DisplayName("To Object Creation Without Dependency Injection With Actual Address")
    public void testObjectCreation_WithoutDI_WithAddress(){
        Address expected = new Address();

        StudentWODI studentWODI = new StudentWODI();
        studentWODI.setAddress(expected);
        assertNotNull(studentWODI);
        assertNotNull(studentWODI.getAddress());
        Address actual = studentWODI.getAddress();
        assertEquals(expected,actual);
    }

    /**
     * (non-javadoc)
     * {@link StudentWDI}
     */
    @Test
    @DisplayName("Test Student Object Creation With Dependency")
    public void testStudentWDI_Creation_WithDI(){
        Address expected = new Address();
        StudentWDI studentWDI = new StudentWDI(expected);
        assertNotNull(studentWDI);
        assertNotNull(studentWDI.getAddress());
        Address actual = studentWDI.getAddress();
        assertEquals(expected,actual);
    }

    /**
     * (non-javadoc)
     * {@link StudentWDI}
     * @see NullPointerException
     */
    @Test
    @DisplayName("Test Student Object Creation With Dependency When Address is Null")
    public void testStudentWDI_Creation_WithDI_WhenAddressIsNull(){
        try{
            StudentWDI studentWDI = new StudentWDI(null);
            fail("Expected Null Pointer Exception");
        }catch (NullPointerException e){
            assertNotNull(e.getMessage());
            assertFalse(e.getMessage().isEmpty());
            assertEquals(e.getMessage(), "Address Cannot Be Null");
        }
    }

    /**
     * (non-javadoc)
     * {@link StudentWDI}
     */
    @Test
    @DisplayName("Test Student Object Creation With Dependency")
    public void testStudentWDI_Creation_WithDISetter(){
        Address expected = new Address();
        StudentWDI studentWDI = new StudentWDI();
        studentWDI.setAddress(expected);
        assertNotNull(studentWDI);
        assertNotNull(studentWDI.getAddress());
        Address actual = studentWDI.getAddress();
        assertEquals(expected,actual);
    }

    /**
     * (non-javadoc)
     * {@link StudentWDI}
     */
    @Test
    @DisplayName("Test Student Object Creation With Dependency")
    public void testStudentWDI_Creation_WithDIProperties(){
        Address expected = new Address();
        StudentWDI studentWDI = new StudentWDI();
        studentWDI.address= expected;
        assertNotNull(studentWDI);
        assertNotNull(studentWDI.getAddress());
        Address actual = studentWDI.getAddress();
        assertEquals(expected,actual);
    }
}