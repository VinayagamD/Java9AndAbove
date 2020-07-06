package com.vinaylogics.learnadvancejava.jdbc.util;

import com.vinaylogics.learnadvancejava.jdbc.exceptions.FactoryException;

public class ConnectionFactory {

    public enum Type{
        STATEMENT,
        PREPARED_STATEMENT,
        CALLABLE_STATEMENT
    }

    private ConnectionFactory(){

    }

    public static JDBCConnection createConnection(Type type){
        JDBCConnection connection = null;
        switch (type){
            case STATEMENT:
                connection = new StatementConnection();
                break;
            case PREPARED_STATEMENT:
                connection = new PreparedStatementConnection();
                break;
            case CALLABLE_STATEMENT:
                connection = new CallableConnection();
                break;
            default:
                throw new FactoryException("Type not suitable");
        }

        return connection;
    }
}
