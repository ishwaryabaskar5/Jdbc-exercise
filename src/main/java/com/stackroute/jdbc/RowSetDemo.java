package com.stackroute.jdbc;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class RowSetDemo {
	
	public void rowSetMethodsDemo() {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			
			System.out.println("\n---------------------------------\nRowSetDemo Class\n---------------------------------\n");
			
			//Creating and Executing RowSet
			JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
			rowSet.setUrl("jdbc:mysql://localhost:3306/employee");
			rowSet.setUsername("root");
			rowSet.setPassword("Root@123");
			
			rowSet.setCommand("select * from employee");
			rowSet.execute();
			
			while (rowSet.next()) {
				// Generating cursor Moved event
				System.out.println("Id: " + rowSet.getInt(1));
				System.out.println("Name: " + rowSet.getString(2));
				System.out.println("Age: " + rowSet.getString(3));
			}
			
	} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

