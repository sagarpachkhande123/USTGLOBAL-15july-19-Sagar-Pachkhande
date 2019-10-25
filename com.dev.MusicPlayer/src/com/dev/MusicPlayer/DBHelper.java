package com.dev.MusicPlayer;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBHelper {
	static Connection conn;
	

	static Connection getConnection()
	{
		try {
			
			if(conn!=null)
			{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Driver Successfully Loaded..");
				
				String dburl = "jdbc:mysql://localhost:3306/MusicPlayer";
				String filePath = "D:\\QSP Banglore\\Core JAVA\\Servlet\\db.properties";

				FileReader reader = new FileReader(filePath);
				Properties properties = new Properties();
				properties.load(reader);
				
				conn = DriverManager.getConnection(dburl, properties);

				System.out.println("Connection Successfully Established..");

				System.out.println("************************************");
				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		
		return conn;
		
	}

}
