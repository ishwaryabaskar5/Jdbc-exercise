package com.stackroute.jdbc;

import java.sql.*;

public class EmployeeDemo {
	
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	
	public void getEmployeeDetail(){
		
		try {

//		    Load driver and register with driver manager
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(
//			Use Driver manager to get connection
//			Mysql default port is 3306
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Root@123");
			
//			create a sql statement
			Statement statement = connection.createStatement();
			
//			execute statement and store it in result set
			ResultSet resultSet = statement.executeQuery("select * from employee");){
			System.out.println("Employee details");
//			Iterating resultSet values
			while (resultSet.next()){
				System.out.println("Id: "+resultSet.getInt(1)+" name: "+resultSet.getString(2));
			}
			System.out.println();
			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
//		finally {
//			try {
//				connection.close();
//				resultSet.close();
//				statement.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
	}
	
	/*Print ResultSet in reverse order*/
	public void getEmployeeDetailsInReverse() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Root@123");
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from employee");){
				resultSet.last();
			System.out.println("Employee details in reverse order");
			System.out.println("Id: "+resultSet.getInt(1)+" name: "+resultSet.getString(2));
			while (resultSet.previous()){
				System.out.println("Id: "+resultSet.getInt(1)+" name: "+resultSet.getString(2));
			}
			System.out.println();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	/*Move ResultSet to second row and print in reverse order*/
	public void getEmployeeDetailsFromSecondRowInReverse() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Root@123");
		    Statement statement = connection.createStatement();
		    ResultSet resultSet = statement.executeQuery("select * from employee");){
			resultSet.absolute(2);
			System.out.println("Employee Details from second row in reverse order");
			System.out.println("Id: "+resultSet.getInt(1)+" name: "+resultSet.getString(2));
			while (resultSet.previous()){
				System.out.println("Id: "+resultSet.getInt(1)+" name: "+resultSet.getString(2));
			}
			System.out.println();
		} catch (SQLException e){
			e.printStackTrace();
		}
	
	}
	
	//Use PreparedStatement to display by name and gender
	
	public void getEmployeeDetailsByNameAndGender(String name,String gender) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Root@123");
		    PreparedStatement statement = connection.prepareStatement("select * from employee where name = ? and gender = ?");
		    ){

			statement.setString(1,name);
			statement.setString(2,gender);
			ResultSet resultSet = statement.executeQuery();
			System.out.println("Employee whose name is "+name+" and gender is "+gender);
			while (resultSet.next()){
				System.out.println("Id: "+resultSet.getInt(1)+" name: "+resultSet.getString(2)+
						" age: "+resultSet.getInt(3)+" gender: "+resultSet.getString(4));
			}
			System.out.println();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
}