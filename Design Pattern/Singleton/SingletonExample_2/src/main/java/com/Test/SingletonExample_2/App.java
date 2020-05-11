package com.Test.SingletonExample_2;

import java.sql.Connection;

public class App 
{
    public static void main( String[] args )
    {
    	long start;
		long end;
		
		FileManager fileManager =  FileManager.getFileManager();
		System.out.println(fileManager);
		
		start = System.currentTimeMillis();
		Connection connection = fileManager.getConnection();
		end =System.currentTimeMillis();
		
		System.out.println(end-start);
		
		
		
		FileManager fileManager1 =  FileManager.getFileManager();
		
		start = System.currentTimeMillis();
		Connection connection_1 = fileManager1.getConnection();
		end = System.currentTimeMillis();
		
		System.out.println(end -start);
		
    }
}
