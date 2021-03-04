package com.vinaylogics.learnadvancejava.jdbc.basics.doas;

import com.vinaylogics.learnadvancejava.jdbc.basics.models.TestData;
import com.vinaylogics.learnadvancejava.jdbc.basics.utils.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDao extends BaseDao{
    public TransactionDao() {
        super(ConnectionManager.getInstance("test_jdbc"));
    }

    public TestData saveRecordNotCommit(TestData testData){
        String sql = "INSERT INTO test_data(name) VALUES ('"+testData.getName()+"');";
        try(Connection connection = openConnection();
            Statement statement   = connection.createStatement();
        ){
            connection.setAutoCommit(false);
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                testData.setId(rs.getLong(1));
            }
            return testData;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public TestData saveRecordCommit(TestData testData){
        String sql = "INSERT INTO test_data(name) VALUES ('"+testData.getName()+"');";
        try(Connection connection = openConnection();
            Statement statement   = connection.createStatement();
        ){
            connection.setAutoCommit(false);
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                testData.setId(rs.getLong(1));
            }
            connection.commit();
            return testData;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }

    }

    public TestData saveRecordRollback(TestData testData){
        String sql = "INSERT INTO test_data(name) VALUES ('"+testData.getName()+"');";
        try(Connection connection = openConnection();
            Statement statement   = connection.createStatement();
        ){
            connection.setAutoCommit(false);
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                testData.setId(rs.getLong(1));
            }
            connection.rollback();
            return testData;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
