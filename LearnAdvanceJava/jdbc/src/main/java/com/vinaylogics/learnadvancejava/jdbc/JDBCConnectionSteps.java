package com.vinaylogics.learnadvancejava.jdbc;

import java.sql.*;

public class JDBCConnectionSteps {

    /*
        1. Load the driver Eg. Driver
        2. Create Connection String and authentication values
        3. Create Queries
        4. Create Connections
        5. Create Statement / PreparedStatement / CallableStatement
        6. Extract Result / int / boolean
        7. Clean the jdbc connections reverse direction of opened jdbc interface
     */

    // Load the jdbc driver
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Connection Strings
        // url
        String url = "jdbc:mysql://localhost:3306/test_jdbc";
        // username
        String username = "vinay";
        // password
        String password = "drago";
        String sql = "SELECT * FROM test_data;";
        // Create Connections, statement, result sets
        try(Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()){
                System.out.print(" | " + resultSet.getInt("id") + " | ");
                System.out.println(" | "+resultSet.getString("name")+ " | ");
                System.out.println("===================== Record Next ==========================");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
