package com.vinaylogics.learnadvancejava.jdbc.designpattern.util;

import java.sql.*;

public class CallableConnection extends JDBCConnection{
    CallableConnection() {
        super(ConnectionManager.getInstance("books"));
    }

    @Override
    public <T> void execute(String sql, ExecuteCallback callback, T... t) {

    }

    @Override
    public <T> void executeUpdate(String sql, ExecuteUpdateCallback callback, T... t) {

    }

    @Override
    public <T> void executeQuery(String sql, ExecuteQueryCallback callback, T... t) {
        try(Connection connection = openConnection();
            CallableStatement statement = connection.prepareCall(sql);
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
}
