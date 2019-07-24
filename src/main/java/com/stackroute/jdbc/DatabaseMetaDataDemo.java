package com.stackroute.jdbc;

import java.sql.*;

public class DatabaseMetaDataDemo {
	
	public void databaseMetaDataMethodsDemo(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

//		connection, statement and resultset variable declaration and initialization
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");) {
			
			DatabaseMetaData metaData = connection.getMetaData();
			
			System.out.println("\n---------------------------------\nDatabaseMetaDataDemo Class\n---------------------------------\n");
			System.out.println("Driver Name: "+metaData.getDriverName());
			System.out.println("Driver Version: "+metaData.getDriverVersion());
			System.out.println("UserName: "+metaData.getUserName());
			System.out.println("Database Product Name: "+metaData.getDatabaseProductName());
			System.out.println("Database Product Version: "+metaData.getDatabaseProductVersion());
			System.out.println("Numeric Functions : "+metaData.getNumericFunctions());
			System.out.println("Url : "+metaData.getURL());
			
			
		} catch (
				SQLException e) {
			e.printStackTrace();
		}
	}
}
