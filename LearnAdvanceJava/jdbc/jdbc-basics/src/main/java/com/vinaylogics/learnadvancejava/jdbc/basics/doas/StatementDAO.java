package com.vinaylogics.learnadvancejava.jdbc.basics.doas;

import com.vinaylogics.learnadvancejava.jdbc.basics.models.TestData;
import com.vinaylogics.learnadvancejava.jdbc.basics.utils.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StatementDAO extends BaseDao {

    public StatementDAO() {
        super(ConnectionManager.getInstance("test_jdbc"));
    }


    public List<TestData> getTestDataList(){
        List<TestData> testData = new ArrayList<>();
        String sql = "SELECT * FROM test_data;";
        try(Connection connection = openConnection();
            Statement  statement   = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
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
        String sql = "SELECT * FROM test_data WHERE id="+id+";";
        try(Connection connection = openConnection();
            Statement  statement   = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()){
                testData = new TestData(resultSet.getLong("id"),resultSet.getString("name"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return testData;
    }

    public TestData saveTestData(TestData testData){
        String sql = "INSERT INTO test_data(name) VALUES ('"+testData.getName()+"');";
        try(Connection connection = openConnection();
            Statement  statement   = connection.createStatement();
           ){
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

    public TestData updateTestData(TestData testData){
        String sql = "UPDATE test_data SET name='"+testData.getName()+"' WHERE id="+testData.getId()+";";

        try(Connection connection = openConnection();
            Statement  statement  = connection.createStatement();
        ){
            statement.executeUpdate(sql);
            return testData;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public boolean deleteTestData(TestData testData){
        String sql = "DELETE FROM test_data WHERE id="+testData.getId()+";";

        try(Connection connection = openConnection();
            Statement  statement  = connection.createStatement();
        ){
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }
}
