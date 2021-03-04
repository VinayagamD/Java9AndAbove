package com.vinaylogics.learnadvancejava.jdbc.basics.doas;

import com.vinaylogics.learnadvancejava.jdbc.basics.utils.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

public class BaseDao {
    private ConnectionManager connectionManager;
    private Connection connection;
    public BaseDao(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public Connection getConnection() {
        return connection;
    }

    public Connection openConnection() throws SQLException {
        connection = connectionManager.getConnection();
        return connection;
    };
}
