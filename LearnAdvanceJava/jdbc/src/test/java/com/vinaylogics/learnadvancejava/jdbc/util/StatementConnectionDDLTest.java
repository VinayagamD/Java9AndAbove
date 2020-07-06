package com.vinaylogics.learnadvancejava.jdbc.util;

import org.junit.jupiter.api.*;

@DisplayName("Test Statement Connection DDL")
class StatementConnectionDDLTest {
    JDBCConnection connection;

    @BeforeEach
    void setUp() {
        connection = ConnectionFactory.createConnection(ConnectionFactory.Type.STATEMENT);
    }

    @DisplayName("TEST to Create Table")
    @Test
    void testCreateTable(){
        String sql = "CREATE TABLE test_data2( "+
                " id INTEGER NOT NULL AUTO_INCREMENT, " +
                " name VARCHAR(150) NOT NULL, " +
                " CONSTRAINT td_pk PRIMARY KEY (id) " +
                ");";
        connection.execute(
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
        connection.execute(
                sql,
                (Assertions::assertTrue)
        );
    }

    @DisplayName("TEST to Drop Table")
    @Test
    void testDropTable(){
        testCreateTable();
        String sql = "DROP TABLE test_data2 ";
        connection.execute(
                sql,
                (Assertions::assertTrue)
        );
    }

    @AfterEach
    void tearDown(){
        connection.execute(
                "DROP TABLE IF EXISTS test_data2 ",
                (Assertions::assertTrue)
        );
    }
}