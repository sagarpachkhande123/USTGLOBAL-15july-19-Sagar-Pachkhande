package com.dev.musicplayer;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class MusicIntImplement implements MusicInterface {

	Scanner sc = new Scanner(System.in);
	public static Connection conn = null;
	PreparedStatement ps = null;
	ResultSet res = null;

	// search song
	@Override
	public void searchSong() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded...!");

			String dbUrl = "jdbc:mysql://localhost:3306/MusicPlayer";
			String filePath = "C:\\Users\\Sukanya\\Documents\\db.properties";

			FileReader reader = new FileReader(filePath);

			Properties prop = new Properties();
			prop.load(reader);

			conn = DriverManager.getConnection(dbUrl, prop);

			//String query = "select * from MusicFiles where Song_ID=?";
			String query=prop.getProperty("my.search");
			ps = conn.prepareStatement(query);
			System.out.println("enter Song_ID");
			ps.setInt(1, Integer.parseInt(sc.nextLine()));
			res = ps.executeQuery();

			// Process The Results Return by SQL Query
			int n = 0;

			while (res.next()) {
				int Song_Id = res.getInt("Song_ID");
				String Song_Title = res.getString("Song_Title");
				String Artist_Name = res.getString("Artist_Name");
				String Album_Name = res.getString("Album_Name");
				String Song_Location = res.getString("Song_Location");
				String Description = res.getString("Description");

				System.out.println("Song found.....!!!!!!!!!!!!");
				System.out.println("Song_Id: " + Song_Id);
				System.out.println("Song_Title: " + Song_Title);
				System.out.println("Artist_Name: " + Artist_Name);
				System.out.println(" Album_Name: " + Album_Name);
				System.out.println(" Song_Locatio: " + Song_Location);
				System.out.println(" Description: " + Description);
				System.out.println("************************************");
				n = 1;
			}

			if (n == 1) {

			}

			else {
				System.out.println("Song not found...");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// show all song

	@Override
	public void showAllSong() {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			String dbUrl = "jdbc:mysql://localhost:3306/MusicPlayer";
			String filePath = "C:\\Users\\Sukanya\\Documents\\db.properties";

			FileReader reader = new FileReader(filePath);

			Properties prop = new Properties();
			prop.load(reader);

			conn = DriverManager.getConnection(dbUrl, prop);

			//String query = "select Song_Title from MusicFiles";

			String query=prop.getProperty("my.show");
			
			ps = conn.prepareStatement(query);
			res = ps.executeQuery();

			// Process The Results Return by SQL Query
			while (res.next()) {

				String Song_Title = res.getString("Song_Title");

				System.out.println("Song_Title: " + Song_Title);

				System.out.println("************************************");

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	// play all song
	@Override
	public void playAllSong() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded...!");

			String dbUrl = "jdbc:mysql://localhost:3306/MusicPlayer";
			String filePath = "C:\\Users\\Sukanya\\Documents\\db.properties";

			FileReader reader = new FileReader(filePath);

			Properties prop = new Properties();
			prop.load(reader);

			conn = DriverManager.getConnection(dbUrl, prop);

			//String query = "select * from MusicFiles order by Song_ID asc";

			String query=prop.getProperty("my.playall");
			ps = conn.prepareStatement(query);
			res = ps.executeQuery();

			// Process The Results Return by SQL Query
			while (res.next()) {
				int Song_Id = res.getInt("Song_ID");
				String Song_Title = res.getString("Song_Title");
				String Artist_Name = res.getString("Artist_Name");
				String Album_Name = res.getString("Album_Name");
				String Song_Location = res.getString("Song_Location");
				String Description = res.getString("Description");

				System.out.println("Song_Id: " + Song_Id);
				System.out.println("Song_Title: " + Song_Title);
				System.out.println("Artist_Name: " + Artist_Name);
				System.out.println(" Album_Name: " + Album_Name);
				System.out.println(" Song_Locatio: " + Song_Location);
				System.out.println(" Description: " + Description);
				System.out.println("************************************");

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	// play random song

	@Override
	public void playRandomSong() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded...!");

			String dbUrl = "jdbc:mysql://localhost:3306/MusicPlayer";
			String filePath = "C:\\Users\\Sukanya\\Documents\\db.properties";

			FileReader reader = new FileReader(filePath);

			Properties prop = new Properties();
			prop.load(reader);

			conn = DriverManager.getConnection(dbUrl, prop);

			//String query = "select * from MusicFiles order by RAND() LIMIT 1";

			String query=prop.getProperty("my.playrandom");
			ps = conn.prepareStatement(query);
			res = ps.executeQuery();

			// Process The Results Return by SQL Query
			while (res.next()) {
				int Song_Id = res.getInt("Song_ID");
				String Song_Title = res.getString("Song_Title");
				String Artist_Name = res.getString("Artist_Name");
				String Album_Name = res.getString("Album_Name");
				String Song_Location = res.getString("Song_Location");
				String Description = res.getString("Description");

				System.out.println("Song_Id: " + Song_Id);
				System.out.println("Song_Title: " + Song_Title);
				System.out.println("Artist_Name: " + Artist_Name);
				System.out.println(" Album_Name: " + Album_Name);
				System.out.println(" Song_Locatio: " + Song_Location);
				System.out.println(" Description: " + Description);
				System.out.println("************************************");

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	// play particular song
	@Override
	public void playParticularSong() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded...!");

			String dbUrl = "jdbc:mysql://localhost:3306/MusicPlayer";
			String filePath = "C:\\Users\\Sukanya\\Documents\\db.properties";

			FileReader reader = new FileReader(filePath);

			Properties prop = new Properties();
			prop.load(reader);

			conn = DriverManager.getConnection(dbUrl, prop);

			//String query = "select * from MusicFiles where Song_Title=?";

			String query=prop.getProperty("my.playparticular");
			ps = conn.prepareStatement(query);
			System.out.println("enter Song_Title");

			ps.setString(1, sc.nextLine());
			res = ps.executeQuery();

			// Process The Results Return by SQL Query
			while (res.next()) {
				int Song_Id = res.getInt("Song_ID");
				String Song_Title = res.getString("Song_Title");
				String Artist_Name = res.getString("Artist_Name");
				String Album_Name = res.getString("Album_Name");
				String Song_Location = res.getString("Song_Location");
				String Description = res.getString("Description");

				System.out.println("Song_Id: " + Song_Id);
				System.out.println("Song_Title: " + Song_Title);
				System.out.println("Artist_Name: " + Artist_Name);
				System.out.println(" Album_Name: " + Album_Name);
				System.out.println(" Song_Locatio: " + Song_Location);
				System.out.println(" Description: " + Description);
				System.out.println("************************************");

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	// Add song

	@Override
	public void addSong() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded...!");

			String dbUrl = "jdbc:mysql://localhost:3306/MusicPlayer";
			String filePath = "C:\\Users\\Sukanya\\Documents\\db.properties";

			FileReader reader = new FileReader(filePath);

			Properties prop = new Properties();
			prop.load(reader);

			conn = DriverManager.getConnection(dbUrl, prop);

			//String query = "insert into MusicFiles values(?,?,?,?,?,?)";
			
			String query=prop.getProperty("my.insert");
			ps = conn.prepareStatement(query);

			System.out.println("enter the Song_ID");
			ps.setInt(1, Integer.parseInt(sc.nextLine()));

			System.out.println("enter the Song_Title ");
			ps.setString(2, sc.nextLine());

			System.out.println("enter the Atrist_Name");
			ps.setString(3, sc.nextLine());

			System.out.println("enter the Album_Name");
			ps.setString(4, sc.nextLine());

			System.out.println("enter the Song_Location");
			ps.setString(5, sc.nextLine());

			System.out.println("enter the Description");
			ps.setString(6, sc.nextLine());
			
			int rs=ps.executeUpdate();

			// process the resultset via preparedstmnt
			if (rs > 0) {
				System.out.println("Query OK," + rs + " row affected");

			} else {
				System.out.println("someting went wrong");
			}


		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	// update song
	@Override
	public void editSong() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded...!");

			String dbUrl = "jdbc:mysql://localhost:3306/MusicPlayer";
			String filePath = "C:\\Users\\Sukanya\\Documents\\db.properties";

			FileReader reader = new FileReader(filePath);

			Properties prop = new Properties();
			prop.load(reader);

			conn = DriverManager.getConnection(dbUrl, prop);

			//String query = "update MusicFiles set Song_Title=? where Song_ID=? ";
			
			String query=prop.getProperty("my.edit");
			
			ps = conn.prepareStatement(query);

			System.out.println("enter the new  Song_Title");
			ps.setString(1, sc.nextLine());

			System.out.println("enter Song_ID");
			ps.setInt(2, Integer.parseInt(sc.nextLine()));

			// int rs = ps.executeUpdate();
			int rs = ps.executeUpdate();

			// process the resultset via preparedstmnt
			if (rs > 0) {
				System.out.println("Query OK," + rs + " row updated");

			} else {
				System.out.println("someting went wrong");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// delete song

	@Override
	public void deleteSong() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded...!");

			String dbUrl = "jdbc:mysql://localhost:3306/MusicPlayer";
			String filePath = "C:\\Users\\Sukanya\\Documents\\db.properties";

			FileReader reader = new FileReader(filePath);

			Properties prop = new Properties();
			prop.load(reader);

			conn = DriverManager.getConnection(dbUrl, prop);

			//String query = "delete from MusicFiles where Song_ID=? ";

			String query=prop.getProperty("my.delete");
			ps = conn.prepareStatement(query);

			System.out.println("enter Song_ID");
			ps.setInt(1, Integer.parseInt(sc.nextLine()));

			// int rs = ps.executeUpdate();
			int rs = ps.executeUpdate();

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