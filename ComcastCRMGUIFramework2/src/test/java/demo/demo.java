package demo;


import java.sql.SQLException;

import com.crm.generic.databaseutility.DataBaseUtility;
import com.crm.generic.fileutility.FileUtility;


public class demo
{
	
	public static void main(String[] args) throws Throwable {
  
		FileUtility flib=new FileUtility();
		System.out.println(flib.getDataFromPropertyFile("url"));
		System.out.println(flib.getDataFromJsonFile("url"));
		
//		DataBaseUtility dlib=new DataBaseUtility();
//		dlib.getDatabaseConnection("jdbc:mysql://localhost:3306/testdata", "root", "root");
		
//		ResultSet uname = dlib.executeSelectQuery("select uname from data where pswd='manager'");
//		while(uname.next()) {
//			System.out.println("username: "+uname.getString("uname"));
//		}
//		dlib.closeDatabaseConnection();
//		
//		DataBaseUtility dlib=new DataBaseUtility();
//		dlib.getDatabaseConnection("jdbc:mysql://localhost:3306/testdata", "root", "root");
//		System.out.println(dlib.executeSelectQuery("select uname from data where pswd='manager'"));
////		
	}

}
