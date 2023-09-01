package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDatabaseDataTest 
{
	public static void main(String[] args) throws SQLException 
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdata","root","root");
		
		//		Statement stat = conn.createStatement();
		//		ResultSet result = stat.executeQuery("select * from data");
		//		while(result.next()) 
		//		{
		//			System.out.println(result.getString(1));
		//		}
		//		
		
		ResultSet uname = conn.createStatement().executeQuery("select uname from data where pswd='manager'");
		while(uname.next()) {
			System.out.println("username: "+uname.getString("uname"));
		}
		ResultSet pswd = conn.createStatement().executeQuery("select pswd from data where uname='admin'");
		while(pswd.next()) {
			System.out.println("userpasswrd: "+pswd.getString("pswd"));
		}
		ResultSet url = conn.createStatement().executeQuery("select url from data where uname='admin'");
		while(url.next()) {
			System.out.println("url: "+url.getString("url"));
		}
		
		conn.close();

	}

}
