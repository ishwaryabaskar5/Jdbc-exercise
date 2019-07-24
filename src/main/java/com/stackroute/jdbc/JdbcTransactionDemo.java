package com.stackroute.jdbc;

import java.sql.*;

public class JdbcTransactionDemo {
	
	EmployeeDemo employeeDemo;
	
	public void transactionDemo() {
		
		Connection connection = null;
		Statement statement = null;
		employeeDemo = new EmployeeDemo();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");
			statement = connection.createStatement();
			
			System.out.println("\n---------------------------------\nJdbcTransactionDemo Class\n---------------------------------\n");
			
//			disable auto commit
			connection.setAutoCommit(false);
			
//			execute statement
			statement.executeUpdate("insert into employee values(5,'Swedha',23,'female')");
			System.out.println("Table rows are not updated because autoCommit is false");
			employeeDemo.getEmployeeDetail();
			
//			commit
			connection.commit();
			System.out.println("Commit after adding a row");
			employeeDemo.getEmployeeDetail();
			
//			again execute statement
			statement.executeUpdate("insert into employee values(6,'Swathi',22,'female')");
			
//			creating savepoint object
			Savepoint savepoint = connection.setSavepoint();
			
//			again execute statement
			statement.executeUpdate("insert into employee values(7,'Sumathi',22,'female')");
			
//			rollback to save point
			connection.rollback(savepoint);
			
//			commit
			connection.commit();
			System.out.println("Rollback to the savepoint");
			employeeDemo.getEmployeeDetail();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
