package com.vinaylogics.learnadvancejava.jdbc.basics.doas;

import com.vinaylogics.learnadvancejava.jdbc.basics.models.Book;
import com.vinaylogics.learnadvancejava.jdbc.basics.utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CallableStatementDao extends BaseDao{
    public CallableStatementDao() {
        super(ConnectionManager.getInstance("books"));
    }

    public List<Book> getAllBooks(){
        List<Book> books = new ArrayList<>();
        String sql = "CALL  display_book();";
        try(Connection connection = openConnection();
            CallableStatement statement   = connection.prepareCall(sql);
            ResultSet resultSet = statement.executeQuery()){
            while (resultSet.next()){
                books.add(Book.builder()
                        .setId(resultSet.getLong("id"))
                        .setIsbn(resultSet.getLong("isbn"))
                        .setName(resultSet.getString("name"))
                        .setAuthorId(resultSet.getLong("author_id"))
                        .setEdNum(resultSet.getLong("ed_num"))
                        .setPrice(resultSet.getDouble("price"))
                        .setPages(resultSet.getInt("pages"))
                        .build());
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return books;
    }

    public Double displayMaxBookPrice(){
        List<Book> books = new ArrayList<>();
        String sql = "CALL  disp_max(?);";
        try(Connection connection = openConnection();
            CallableStatement statement   = connection.prepareCall(sql);
            ){
            statement.registerOutParameter(1, Types.DOUBLE);

            statement.executeQuery();
            return statement.getDouble(1);

        } catch (SQLException exception) {
            exception.printStackTrace();
            return 0.0;
        }

    }

}
