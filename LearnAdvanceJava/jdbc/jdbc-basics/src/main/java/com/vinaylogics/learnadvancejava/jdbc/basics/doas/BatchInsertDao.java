package com.vinaylogics.learnadvancejava.jdbc.basics.doas;

import com.vinaylogics.learnadvancejava.jdbc.basics.models.Book;
import com.vinaylogics.learnadvancejava.jdbc.basics.models.TestData;
import com.vinaylogics.learnadvancejava.jdbc.basics.utils.ConnectionManager;

import java.sql.*;
import java.util.List;

public class BatchInsertDao extends BaseDao{
    public BatchInsertDao() {
        super(ConnectionManager.getInstance("test_jdbc"));
    }

    public void insertList(List<TestData> testData){
        String sql = "INSERT INTO test_data(name) VALUES ('%s');";
        try(Connection connection = openConnection();
            Statement statement   = connection.createStatement();
        ){
            connection.setAutoCommit(false);
            testData.forEach(data -> {
                try {
                    statement.addBatch(String.format(sql, data.getName()));
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                try {
                    statement.executeBatch();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                var index = testData.indexOf(data);
                if (index % 10 == 0){
                    try {
                        connection.commit();
                        System.out.println("Commit Successful at index "+index);
                    } catch (SQLException exception) {
                        exception.printStackTrace();
                    }
                }
            });
            try {
                connection.commit();
                System.out.println("Commit Successful at index final");
            } catch (SQLException exception) {
                exception.printStackTrace();
            }

        } catch (SQLException exception) {
            exception.printStackTrace();

        }

    }

    public void savePointList(List<TestData> testData){
        String sql = "INSERT INTO test_data(name) VALUES ('%s');";
        try(Connection connection = openConnection();
            Statement statement   = connection.createStatement();
        ){
            connection.setAutoCommit(false);
            for (TestData data : testData) {
                try {
                    statement.addBatch(String.format(sql, data.getName()));

                    statement.executeBatch();

                var index = testData.indexOf(data);
                Savepoint savePoint = null;
                if (index % 10 == 0) {

                        connection.commit();

                        System.out.println("Commit Successful at index " + index);
                        savePoint = connection.setSavepoint("index" + index);

                }
                if (index == 50) {

                        connection.rollback(savePoint);

                    return;
                }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
            try {
                connection.commit();
                System.out.println("Commit Successful at index final");
            } catch (SQLException exception) {
                exception.printStackTrace();
            }

        } catch (SQLException exception) {
            exception.printStackTrace();

        }

    }
}
