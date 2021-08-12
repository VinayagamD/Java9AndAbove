package com.vinaylogics.learnadvancedjava.junit.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    Util util;

    @BeforeEach
    void setUp() {
        util = new Util();
    }

    @ParameterizedTest(name = "Test for the string data = {0}")
    @ValueSource(strings = {"Usha","Java", "junit"})
    void testToUpper_Success(String data) {
        String expected = data.toUpperCase();
        String actual = util.toUpper(data);
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Test to upper negative scenario")
    void testToUpper_ForNullData(){
        try{
            util.toUpper(null);
            fail("Expected to fail with NPE");
        }catch (NullPointerException e){
            assertNotNull(e);
            assertEquals("Null Data not accepted",e.getMessage());
        }
    }

    @RepeatedTest(value = 10)
    @DisplayName("Test to upper negative scenario")
    void testToUpper_ForNullDataFor10Times(){
        try{
            util.toUpper(null);
            fail("Expected to fail with NPE");
        }catch (NullPointerException e){
            assertNotNull(e);
            assertEquals("Null Data not accepted",e.getMessage());
        }
    }
}