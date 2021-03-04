package com.vinaylogics.learnadvancejava.jdbc.designpattern.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Prepared Statement DML")
class PreparedStatementConnectionTest {
    JDBCConnection connection;

    @BeforeEach
    void setUp() {
        connection = ConnectionFactory.createConnection(ConnectionFactory.Type.PREPARED_STATEMENT);
    }

    @DisplayName("Prepared Statement to get all rows")
    @Test
    void testGetAllRows(){
        String sql = "SELECT * FROM test_data";
        connection.executeQuery(sql,(result -> {
            assertNotNull(result);
            while (result.next()){
                System.out.print(" | " + result.getInt("id") + " | ");
                System.out.println(" | "+result.getString("name")+ " | ");
                System.out.println("===================== Record Next ==========================");
            }
        }));
    }


    @DisplayName("Test for value id test")
    @ParameterizedTest(name = "For id {0} is tested.")
    @ValueSource(ints = {1,2,3,4,5})
    void testForIndividualRecord(int id){
        String sql = "SELECT * FROM test_data WHERE id = ?;";
        connection.executeQuery(sql,(result -> {
            assertNotNull(result);
            while (result.next()){
                System.out.print(" | " + result.getInt("id") + " | ");
                System.out.println(" | "+result.getString("name")+ " | ");
                System.out.println("===================== Record Next ==========================");
            }
        }), id);
    }

    @DisplayName("Test for insertion")
    @ParameterizedTest(name = "For name {0} insertion is tested.")
    @ValueSource(strings = {"suresh", "mahesh", "choudary", "deepti","Santhu"})
    void testForInsertion(String name){
        String sql = "INSERT INTO test_data(name) VALUES ( ?);";
        connection.executeUpdate(sql,(result -> {
            assertTrue(result > 0);
        }), name);
    }

    @DisplayName("Test for updating")
    @ParameterizedTest(name = "For name {0} insertion is tested.")
    @ValueSource(ints = {1,2,3,4,5})
    void testForUpdate(int id){
        String sql = "UPDATE test_data SET name = ? WHERE id = ? ;";
        connection.executeUpdate(sql,(result -> {
            assertTrue(result > 0);
        }),"updateName"+id, id);
    }

    @AfterEach
    void tearDown() {
    }
}