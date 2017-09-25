package com.cg.donation.DbUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
	
	public static Connection getConnection() throws SQLException, IOException {
		 
		Connection conn = null;
		Properties prop=readDonation();
		String url=prop.getProperty("url");
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		return conn=DriverManager.getConnection(url,username,password);
	}
	
	public static Properties readDonation() throws IOException {
		Properties p=new Properties();
		FileReader fr=new FileReader("Donation.properties");
		p.load(fr);
		return p;
	}

}
