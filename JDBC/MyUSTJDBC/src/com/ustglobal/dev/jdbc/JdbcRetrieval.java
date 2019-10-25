package com.ustglobal.dev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class JdbcRetrieval {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		Scanner sc=new Scanner(System.in);
		// Load the drivers
		try {
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

			
			// Issue SQL Query via connection
			String query = "select * from users_info where userid=?";
			
			ps=conn.prepareStatement(query);
			
			System.out.println("enter user id");
			ps.setInt(1,Integer.parseInt(sc.nextLine()));
			
			res=ps.executeQuery();
			
			// Process The Results Return by SQL Query
			while(res.next()) {
				int userid = res.getInt("userid");
				String username = res.getString("username");
				String email = res.getString("email");
				String password1 = res.getString("password");
				System.out.println("userid: " + userid);
				System.out.println("username: " + username);
				System.out.println("email: " + email);
				System.out.println("user Password: " + password1);
				System.out.println("************************************");
				
			}
			
			
			}catch (Exception e) {
				System.out.println("someting went wrong");
				e.printStackTrace();
				
			} finally {
				if(conn!=null) {
					try {
						conn.close();
					} catch (Exception e) {
						
						e.printStackTrace();
					}
				}

				if(ps!=null) {
					try {
						ps.close();
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
