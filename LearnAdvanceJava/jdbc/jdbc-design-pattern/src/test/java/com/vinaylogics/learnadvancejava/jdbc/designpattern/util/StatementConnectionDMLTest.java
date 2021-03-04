package com.vinaylogics.learnadvancejava.jdbc.designpattern.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Test Statement Connection DML")
public class StatementConnectionDMLTest {

    JDBCConnection connection;

    @BeforeEach
    void setUp() {
        connection = ConnectionFactory.createConnection(ConnectionFactory.Type.STATEMENT);
    }

    @DisplayName("Test DML FOR ALL RECORD")
    @Test
    void testForAllRecord(){
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
        String sql = "SELECT * FROM test_data WHERE id = "+id+";";
        connection.executeQuery(sql,(result -> {
            assertNotNull(result);
            while (result.next()){
                System.out.print(" | " + result.getInt("id") + " | ");
                System.out.println(" | "+result.getString("name")+ " | ");
                System.out.println("===================== Record Next ==========================");
            }
        }));
    }

    @DisplayName("Test for insertion")
    @ParameterizedTest(name = "For name {0} insertion is tested.")
    @ValueSource(strings = {"suresh", "mahesh", "choudary", "deepti", "Santhosh"})
    void testForInsertion(String name){
        String sql = "INSERT INTO test_data(name) VALUES ( '"+ name+"');";
        connection.executeUpdate(sql,(result -> {
            assertTrue(result > 0);
        }));
    }

    @DisplayName("Test for updating")
    @ParameterizedTest(name = "For name {0} insertion is tested.")
    @ValueSource(ints = {1,2,3,4,5})
    void testForUpdate(int id){
        String sql = "UPDATE test_data SET name = 'updateName"+id+"' WHERE id = "+id+" ;";
        connection.executeUpdate(sql,(result -> {
            assertTrue(result > 0);
        }));
    }

 @DisplayName("Test for insertion")
    @ParameterizedTest(name = "For name {0} insertion is tested.")
    @ValueSource(ints = {56,57,58,59,60})
    void testForDelete(int id){
        String sql = "DELETE FROM  test_data WHERE id = "+id+" ;";
     connection.executeUpdate(sql,(result -> {
            assertTrue(result > 0);
        }));
    }



    @AfterEach
    void tearDown() {

    }
}
