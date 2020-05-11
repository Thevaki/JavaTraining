package com.Test.SingletonExample_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class FileManager {
	private static volatile FileManager fileManager; //=new FileManager();
	private static volatile Connection connection;
	
	private FileManager() {
		if(fileManager != null) {
		   throw new RuntimeException("Please use getFileManager method");	
		}
		
	}

	public static FileManager getFileManager() {
		if(fileManager == null) {
			synchronized(FileManager.class){
				if(fileManager == null) {
					fileManager = new FileManager();
				}
			}
		}
		
		return fileManager;
	}

	public Connection getConnection() {
		
		if(connection == null) {
			synchronized(FileManager.class){
				if(connection == null) {
					String url = "jdbc:derby:memory:singleton;create=true";
					try {
						connection = DriverManager.getConnection(url);
					}catch(SQLException e ) {
						e.printStackTrace();
					}
				}
			}
		}
		return connection;
	}
}
