package com.vinaylogics.learnadvancejava.jdbc.designpattern.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class JDBCConnection {

    protected ConnectionManager connectionManager;
    protected Connection connection;

    public JDBCConnection(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
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

    Connection openConnection() throws SQLException{
        connection = connectionManager.getConnection();
        return connection;
    };

    abstract  public <T> void execute(String sql,ExecuteCallback callback, T... t);

    abstract  public <T> void executeUpdate(String sql, ExecuteUpdateCallback callback, T... t);

    abstract  public <T>void executeQuery(String sql, ExecuteQueryCallback callback, T... t);

}
