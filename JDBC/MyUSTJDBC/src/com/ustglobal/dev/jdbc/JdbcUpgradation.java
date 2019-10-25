package com.ustglobal.dev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcUpgradation {

	public static void main(String[] args) {

		Scanner sc =new Scanner(System.in);
		PreparedStatement ps = null;
		Connection conn=null;
		try {
			//load driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded...!");

			// Get Connection Via Driver
			String dbUrl = "jdbc:mysql://localhost:3306/ust_ty_db";

			System.out.println("enter the username and password");
			String user = sc.nextLine();
			String password = sc.nextLine();

			conn = DriverManager.getConnection(dbUrl, user, password);
			System.out.println("Connection Estalished........!");
			System.out.println("************************************");

			//issue Sql query

			String query="update users_info set email=? where userid=? AND password=? ";
			ps=conn.prepareStatement(query);

			System.out.println("enter the new email add");
			ps.setString(1,sc.nextLine());

			System.out.println("enter user id");
			ps.setInt(2,Integer.parseInt(sc.nextLine()));

			System.out.println("enter the password");
			ps.setString(3,sc.nextLine());

			//int rs = ps.executeUpdate();
			int rs=ps.executeUpdate();

			// process the resultset via preparedstmnt
			if (rs > 0) {
				System.out.println("Query OK," + rs + " row updated");

			} else {
				System.out.println("someting went wrong");
			}


		} catch (Exception e) {

			e.printStackTrace();
		}finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}



		}

	}
}