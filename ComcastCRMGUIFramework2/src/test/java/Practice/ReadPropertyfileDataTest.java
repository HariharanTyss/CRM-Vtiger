package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadPropertyfileDataTest {

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis1=new FileInputStream("./src/test/resources/Testdata/data.properties");
		Properties p=new Properties();
		p.load(fis1);

		//step3: Get the Value form Json File by passing Key 
		String url = p.getProperty("url");
		String browser = p.getProperty("browser");
		String unm = p.getProperty("unm");
		String pwd = p.getProperty("pwd");
		String email = p.getProperty("email");
		
		//Print on Console
		System.out.println(url);
		System.out.println(browser);
		System.out.println(unm);
		System.out.println(pwd);
		System.out.println(email);
		

	}

}
