package com.ustglobal.dev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcInsertion {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);

		try {

			// load the driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded....!");

			// Get Connection Via Driver
			String dbUrl = "jdbc:mysql://localhost:3306/ust_ty_db";

			System.out.println("enter the username and password");
			String user = sc.nextLine();
			String password = sc.nextLine();

			conn = DriverManager.getConnection(dbUrl, user, password);
			System.out.println("Connection Estalished........!");
			System.out.println("************************************");

			String query = "insert into users_info values(?,?,?,?)";
			ps = conn.prepareStatement(query);

			System.out.println("enter the userid");
			ps.setInt(1, Integer.parseInt(sc.nextLine()));

			System.out.println("enter the username");
			ps.setString(2, sc.nextLine());

			System.out.println("enter the email");
			ps.setString(3, sc.nextLine());

			System.out.println("enter the password");
			ps.setString(4, sc.nextLine());

			//int rs = ps.executeUpdate();
			int rs=ps.executeUpdate();

			// process the resultset via preparedstmnt
			if (rs > 0) {
				System.out.println("Query OK," + rs + " row affected");

			} else {
				System.out.println("someting went wrong");
			}

			
		} catch (Exception e) {
			System.out.println("someting went wrong");
			e.printStackTrace();
			
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

}
