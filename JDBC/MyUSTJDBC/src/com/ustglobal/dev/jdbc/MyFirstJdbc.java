package com.ustglobal.dev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class MyFirstJdbc {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet res = null;
		// Load the drivers
		try {
			java.sql.Driver div = new Driver();
			DriverManager.registerDriver(div);
			System.out.println("Driver Loaded....");

			// get connection via driver
			String dbUrl = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";

			conn = DriverManager.getConnection(dbUrl);
			System.out.println("Connection established.....");
			System.out.println("************************************");

			// Issue SQL Query via connection
			String query = "select * from users_info";
			stmt = conn.createStatement();
			res = stmt.executeQuery(query);

			// Process The Results Return by SQL Query

			while (res.next()) {

				int userid = res.getInt("userid");
				String username = res.getString("username");
				String email = res.getString("email");
				String password = res.getString("password");
				System.out.println("userid: " + userid);
				System.out.println("username: " + username);
				System.out.println("email: " + email);
				System.out.println("user Password: " + password);
				System.out.println("************************************");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            if(conn!=null) {
            	try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            
            if(stmt!=null) {
            	try {
            		stmt.close();
            	}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
            	}
            }
            
            if(res!=null) {
            	try {
            		res.close();
            	}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
            	}
            }
            
            
		}

	}

}
