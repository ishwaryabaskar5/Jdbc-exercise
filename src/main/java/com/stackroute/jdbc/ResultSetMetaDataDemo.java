package com.stackroute.jdbc;

import java.sql.*;

public class ResultSetMetaDataDemo {
	
	public void resultSetMetaDataMethodsDemo(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
//		connection, statement and resultset variable declaration and initialization
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from employee");) {
		
//			create meta data object for resultSet
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			System.out.println("\n---------------------------------\nResultSetMetaDataDemo Class\n---------------------------------\n");
			System.out.println("Total number of column in employee table: "+resultSetMetaData.getColumnCount());
			System.out.println("Table Name: "+resultSetMetaData.getTableName(1));
			System.out.println("First column name: "+resultSetMetaData.getColumnName(1));
			System.out.println("First column type: "+resultSetMetaData.getColumnType(1));
			System.out.println("Wrapper class name of second column "+resultSetMetaData.getColumnClassName(2));
			System.out.println("SQL data type of second column: "+resultSetMetaData.getColumnTypeName(2));
			
			
		} catch (
		SQLException e) {
			e.printStackTrace();
		}
		
	
		}
}
