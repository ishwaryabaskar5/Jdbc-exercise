package com.stackroute.jdbc;

import java.sql.*;

public class JdbcBatchDemo {
	
	EmployeeDemo employeeDemo;
	
	public void batchExecution() {
		
		Connection connection = null;
		Statement statement = null;
		Statement statement1 = null;
		employeeDemo = new EmployeeDemo();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");
			
			System.out.println("\n---------------------------------\nJdbcBatchDemo Class\n---------------------------------\n");
			
			statement = connection.createStatement();
			statement.addBatch("insert into employee values(5,'Swedha',23,'female')");
			statement.addBatch("insert into employee values(6,'Swathi',22,'female')");
			
			statement.executeBatch();
			System.out.println("After adding 2 rows");
			employeeDemo.getEmployeeDetail();
			
			statement1 = connection.createStatement();
			statement1.addBatch("delete from employee where name = 'Swedha'");
			statement1.addBatch("delete from employee where name = 'Swathi'");
			
			statement1.executeBatch();
			System.out.println("After removing 2 rows");
			employeeDemo.getEmployeeDetail();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				statement.close();
				statement1.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}