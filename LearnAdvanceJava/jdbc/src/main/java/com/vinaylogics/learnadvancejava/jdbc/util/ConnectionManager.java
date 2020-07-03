package com.vinaylogics.learnadvancejava.jdbc.util;

import java.sql.*;

public class ConnectionManager {
    private static final Object LOCK = new Object();

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private interface ConnectionString {
        String URL = "jdbc:mysql://localhost:3306/test_jdbc";
        String USER = "vinay";
        String PASSWORD = "drago";
    }
    private ConnectionManager(){

    }

    private static  ConnectionManager instance ;

    public static ConnectionManager getInstance() {
        if(instance == null){
            synchronized (LOCK){
                if(instance == null){
                    instance = new ConnectionManager();
                }
            }
        }
        return instance;
    }

    @FunctionalInterface
    public interface ExecuteCallback{
        void execute(boolean result);
    }

    @FunctionalInterface
    public interface ExecuteQueryCallback{
        void execute(ResultSet result) throws SQLException;
    }

    @FunctionalInterface
    public interface ExecuteUpdateCallback{
        void execute(int result);
    }

    public void execute(String sql, ExecuteCallback callback){
        try(Connection connection = DriverManager.getConnection(ConnectionString.URL, ConnectionString.USER, ConnectionString.PASSWORD);
            Statement statement = connection.createStatement()){
            statement.execute(sql);
            callback.execute(true);
        } catch (SQLException e) {
            e.printStackTrace();
            callback.execute(false);
        }
    }

    public void executeQuery(String sql, ExecuteQueryCallback callback){
        try(Connection connection = DriverManager.getConnection(ConnectionString.URL, ConnectionString.USER, ConnectionString.PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
            callback.execute(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                callback.execute(null);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void executeUpdate(String sql, ExecuteUpdateCallback callback){
        try(Connection connection = DriverManager.getConnection(ConnectionString.URL, ConnectionString.USER, ConnectionString.PASSWORD);
            Statement statement = connection.createStatement()){
            callback.execute(statement.executeUpdate(sql));
        } catch (SQLException e) {
            e.printStackTrace();
            callback.execute(-1);
        }
    }

}