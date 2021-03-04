package com.vinaylogics.learnadvancejava.jdbc.basics.doas;

import com.vinaylogics.learnadvancejava.jdbc.basics.models.TestData;
import com.vinaylogics.learnadvancejava.jdbc.basics.utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrepareStatementDAO extends BaseDao {

    public PrepareStatementDAO() {
        super(ConnectionManager.getInstance("test_jdbc"));
    }


    public List<TestData> getTestDataList(){
        List<TestData> testData = new ArrayList<>();
        String sql = "SELECT * FROM test_data;";
        try(Connection connection = openConnection();
            PreparedStatement statement   = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()){
            while (resultSet.next()){
                testData.add(new TestData(resultSet.getLong("id"),resultSet.getString("name")));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return testData;
    }

    public TestData getTestData(Long id){
        TestData testData = null;
        String sql = "SELECT * FROM test_data WHERE id=?;";
        try(Connection connection = openConnection();
            PreparedStatement statement   = connection.prepareStatement(sql);
            ){
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                testData = new TestData(resultSet.getLong("id"),resultSet.getString("name"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return testData;
    }

    public TestData saveTestData(TestData testData){
        String sql = "INSERT INTO test_data(name) VALUES (?) ;";
        try(Connection connection = openConnection();
            PreparedStatement  statement   = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ){
            statement.setString(1, testData.getName());
            statement.executeUpdate();
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

    public TestData updateTestData(TestData testData){
        String sql = "UPDATE test_data SET name=? WHERE id=?;";

        try(Connection connection = openConnection();
            PreparedStatement  statement  = connection.prepareStatement(sql);
        ){
            statement.setString(1, testData.getName());
            statement.setLong(2, testData.getId());
            statement.executeUpdate();
            return testData;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public boolean deleteTestData(TestData testData){
        String sql = "DELETE FROM test_data WHERE id=?;";

        try(Connection connection = openConnection();
            PreparedStatement  statement  = connection.prepareStatement(sql);
        ){
            statement.setLong(1, testData.getId());
            statement.executeUpdate();
            return true;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }
}
