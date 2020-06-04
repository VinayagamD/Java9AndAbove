package com.vinaylogics.schoolmanagement.repositories.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseManager {
   private static Connection con = null;

   static {
       String url = "jdbc:mysql://localhost:3306/SchoolManagements";
       String name = "vinay";
       String password = "drago";
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           con = DriverManager.getConnection(url, name, password);
       }catch (ClassNotFoundException | SQLException e){
           e.printStackTrace();
       }
   }

    public static Connection getCon() {
        return con;
    }
}
