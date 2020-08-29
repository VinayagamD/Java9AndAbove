package com.vinaylogics.learnadvancejava.jdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementConnection extends JDBCConnection{

    PreparedStatementConnection() {
        super(ConnectionManager.getInstance("test_jdbc"));
    }

    @Override
    public void execute(String sql, ExecuteCallback callback, Object... objects) {
        try(Connection connection = openConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            for (int i = 0; i < objects.length; i++) {
                statement.setString(i+1, String.valueOf(objects[i]));
            }
            statement.execute();
            callback.execute(true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            callback.execute(false);
        }
    }

    @Override
    public void executeUpdate(String sql, ExecuteUpdateCallback callback, Object... objects) {
        try(Connection connection = openConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            for (int i = 0; i < objects.length; i++) {
                statement.setString(i+1, String.valueOf(objects[i]));
            }
           callback.execute(statement.executeUpdate());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            callback.execute(-1);
        }
    }

    @Override
    public void executeQuery(String sql, ExecuteQueryCallback callback, Object... objects) {
        try(Connection connection = openConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            for (int i = 0; i < objects.length; i++) {
                statement.setString(i+1, String.valueOf(objects[i]));
            }
            ResultSet resultSet = statement.executeQuery();
            callback.execute(resultSet);
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                callback.execute(null);
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }
}
