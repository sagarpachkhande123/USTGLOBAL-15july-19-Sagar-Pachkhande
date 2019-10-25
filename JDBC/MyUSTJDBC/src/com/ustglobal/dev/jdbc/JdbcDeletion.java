package com.ustglobal.dev.jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class JdbcDeletion {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded...!");
			
			String dbUrl = "jdbc:mysql://localhost:3306/ust_ty_db";
			String filePath="C:\\Users\\Sukanya\\Documents\\db.properties";
			 
			FileReader reader=new  FileReader(filePath);
			
			Properties prop=new Properties();
			prop.load(reader);
			
			conn=DriverManager.getConnection(dbUrl,prop);
			System.out.println("Connection Estalished........!");
			System.out.println("************************************");
			
			//Issue sql query
			String query="delete from users_info where userid=? and password=?";
			
			ps=conn.prepareStatement(query);
			
			System.out.println("enter user id");
			ps.setInt(1,Integer.parseInt(sc.nextLine()));

			System.out.println("enter the password");
			ps.setString(2,sc.nextLine());

			//int rs = ps.executeUpdate();
			int rs=ps.executeUpdate();

			// process the resultset via preparedstmnt
			if (rs > 0) {
				System.out.println("Query OK," + rs + " row deleted");

			} else {
				System.out.println("someting went wrong");
			}

			
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
