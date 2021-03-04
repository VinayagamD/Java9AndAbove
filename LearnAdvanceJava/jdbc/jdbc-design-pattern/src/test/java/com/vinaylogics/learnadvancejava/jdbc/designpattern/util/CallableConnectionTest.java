package com.vinaylogics.learnadvancejava.jdbc.designpattern.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Call Stored Procedure Demo")
class CallableConnectionTest {
    JDBCConnection connection;

    @BeforeEach
    void setUp() {
        connection = ConnectionFactory.createConnection(ConnectionFactory.Type.CALLABLE_STATEMENT);
    }

    @DisplayName("Call Books Demo")
    @Test
    void callSelectStoreProcedure(){
        String SQL ="CALL display_book();";
        connection.executeQuery(SQL,(result -> {
            assertNotNull(result);
            while (result.next()){
                System.out.print(" | " + result.getInt("id") + " | ");
                System.out.println(" | "+result.getString("name")+ " | ");
                System.out.println("===================== Record Next ==========================");
            }
        }));
    }

    @AfterEach
    void tearDown() {
    }
}