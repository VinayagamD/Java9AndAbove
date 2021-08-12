package com.vinaylogics.learnadvancejava.jdbc.designpattern.util;

import java.sql.*;

public record ConnectionManager(String dbName) {
    private static final Object LOCK = new Object();

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private interface ConnectionString {
        String URL = "jdbc:mysql://localhost:3306/";
        String USER = "vinay";
        String PASSWORD = "drago";
    }

    private static ConnectionManager instance;

    public static ConnectionManager getInstance(String dbName) {
        if (instance != null && !dbName.equals(instance.dbName)) {
            instance = null;
        }
        if (instance == null) {
            synchronized (LOCK) {
                if (instance == null) {
                    instance = new ConnectionManager(dbName);
                }
            }
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(ConnectionString.URL + dbName, ConnectionString.USER, ConnectionString.PASSWORD);
    }

}