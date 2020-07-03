package com.vinaylogics.learnadvancejava.jdbc.util;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Connection Manager Util Class")
class ConnectionManagerDDLTest {

    ConnectionManager connectionManager;

    @BeforeEach
    void setUp() {
        connectionManager = ConnectionManager.getInstance();
    }

    @DisplayName("TEST to Create Table")
    @Test
    void testCreateTable(){
        String sql = "CREATE TABLE test_data2( "+
         " id INTEGER NOT NULL AUTO_INCREMENT, " +
                " name VARCHAR(150) NOT NULL, " +
        " CONSTRAINT td_pk PRIMARY KEY (id) " +
       ");";
        connectionManager.execute(
                sql,
                (Assertions::assertTrue)
        );
    }

    @DisplayName("TEST to Alter Table")
    @Test
    void testUpdateTable(){
        testCreateTable();
        String sql = "ALTER TABLE test_data2 " +
                "    ADD COLUMN surname VARCHAR(100) AFTER id; ";
        connectionManager.execute(
                sql,
                (Assertions::assertTrue)
        );
    }

    @DisplayName("TEST to Alter Table")
    @Test
    void testDropTable(){
        testCreateTable();
        String sql = "DROP TABLE test_data2 ";
        connectionManager.execute(
                sql,
                (Assertions::assertTrue)
        );
    }

    @AfterEach
    void tearDown(){
        connectionManager.execute(
                "DROP TABLE IF EXISTS test_data2 ",
                (Assertions::assertTrue)
        );
    }
}