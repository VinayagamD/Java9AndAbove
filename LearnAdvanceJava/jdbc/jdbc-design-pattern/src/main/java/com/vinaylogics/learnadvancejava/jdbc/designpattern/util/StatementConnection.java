package com.vinaylogics.learnadvancejava.jdbc.designpattern.util;

import java.sql.*;
import java.util.concurrent.Executors;

public class StatementConnection extends JDBCConnection{
     StatementConnection() {
        super(ConnectionManager.getInstance("test_jdbc"));
    }

    @Override
    public void execute(String sql, ExecuteCallback callback, Object... objects) {
        try(Connection connection = openConnection();
            Statement statement = connection.createStatement()){
            statement.execute(sql);
            callback.execute(true);
        } catch (SQLException e) {
            e.printStackTrace();
            callback.execute(false);
        }
    }

    @Override
    public void executeUpdate(String sql, ExecuteUpdateCallback callback, Object... objects) {
        try(Connection connection = openConnection();
            Statement statement = connection.createStatement()){
            connection.setAutoCommit(false);
            callback.execute(statement.executeUpdate(sql));
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            callback.execute(-1);
            try {
                connection.rollback();
                connection.abort(Executors.newSingleThreadExecutor());
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void executeQuery(String sql, ExecuteQueryCallback callback,Object... objects) {
        try(Connection connection = openConnection();
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
}
