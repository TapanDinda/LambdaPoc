package com.tkd.net.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBManager {

	static private Connection conn = null;
	static{
		String configName = System.getProperty("appEnv");
		InputStream is = null;
		try{
			if (configName != null) {
				Path path = Paths.get(configName);
				if(path.toFile().exists()){
					is =  Files.newInputStream(path);
				}
			}
			if(is == null){
				is = ClassLoader.getSystemResourceAsStream("application.properties");
				//is = ClassLoader.getSystemResourceAsStream("db.properties");
			}			
			Properties props = new Properties();		
			props.load(is);		
			Class.forName( props.getProperty("driverClassName"));
			conn = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {is.close();} catch (IOException e) {}
		}
	}
	
	public static Connection getConnection(){
		return conn;
	}
}
