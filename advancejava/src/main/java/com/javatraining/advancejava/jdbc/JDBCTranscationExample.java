/**
 * 
 */
package com.javatraining.advancejava.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author vinay
 *
 */
public class JDBCTranscationExample {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// 1. Create Connection String
		String url = "jdbc:mysql://localhost:3306/students";
		// 2. ADD USER CREDENTIALS 
		String username = "root";
		String password = "drago";
		String sql = "INSERT INTO students(roll_no, name, phone_no) VALUES (1239, 'test27', 'testphone');";
		String sql2 = "INSERT INTO students(roll_no, name, phone_no) VALUES (1240, 'test28', 'testphone');";
		Connection con = null;Statement statement = null;
		Savepoint savepoint = null;
		try/*(Connection con = DriverManager.getConnection(url, username, password);
			Statement statement = con.createStatement())*/{
			con = DriverManager.getConnection(url, username, password);
			 statement= con.createStatement();
		// 3. JDBC CONNECTIONS
			con.setAutoCommit(false);
			statement.addBatch(sql);
			 savepoint = con.setSavepoint("Record1");
			statement.addBatch(sql2);
			 savepoint = con.setSavepoint("Record2");
			int[] exe = statement.executeBatch();
			for (int i = 0; i < exe.length; i++) {
				System.out.println(exe[i]);
			}
			con.commit();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(con != null && savepoint!= null) {
				try {
					con.rollback();
//					con.rollback(savepoint);
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			}

		}finally {
			try {
				if(statement != null)
					statement.close();
				if(con != null)
					con.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		// 6. CLOSE ALL THE CONNECTIONS

	}

}
