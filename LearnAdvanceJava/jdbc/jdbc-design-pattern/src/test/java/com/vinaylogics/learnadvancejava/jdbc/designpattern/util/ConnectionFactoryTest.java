package com.vinaylogics.learnadvancejava.jdbc.designpattern.util;

import com.vinaylogics.learnadvancejava.jdbc.designpattern.exceptions.FactoryException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Creation for database connection factory")
class ConnectionFactoryTest {

    @DisplayName("Should pass non-null enum values as method parameters")
    @ParameterizedTest(name = "{index} => For Statement=''{0}''")
    @EnumSource(ConnectionFactory.Type.class)
    void testCreateConnection(ConnectionFactory.Type type) {
        try {
            ConnectionFactory.createConnection(type);
        }catch (FactoryException exception){
            fail("Exception Not Allowed for valid type", exception);
        }
    }

    @DisplayName("Invalid Type Throw Exception")
    @Test
    void testCreateConnection_FailedType(){
        try {
            ConnectionFactory.createConnection(null);
            fail("Expected Exception");
        }catch (FactoryException exception){
            assertTrue(exception!= null);
            assertEquals(exception.getMessage(),"Type should not be null");
        } catch (NullPointerException exception){
            fail("Unexpected exception", exception);
        }
    }
}