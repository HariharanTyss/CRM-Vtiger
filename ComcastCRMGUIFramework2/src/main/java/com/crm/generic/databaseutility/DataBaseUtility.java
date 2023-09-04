package com.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DataBaseUtility 
{
	Connection conn;
	public void getConnectToDataBase(String url,String unm,String pwd) throws SQLException 
	{
		Driver driver=new Driver();
		
		DriverManager.registerDriver(driver);
	
		conn = DriverManager.getConnection(url, unm, pwd);
	}
	public ResultSet executeSelectQuery(String query) throws SQLException 
	{
		return conn.createStatement().executeQuery(query);
		
	}
	public int executeNonSelectQuery(String query) throws SQLException 
	{
		return conn.createStatement().executeUpdate(query);
	}
	public void closeConnection() throws SQLException
	{
		conn.close();
	}
}
