package Practice;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromXmlTest 
{
	@Test
	public void readDataFromXml(XmlTest test) 
	{
		//step3: Get the Value form xml File by passing Key 
		String url = test.getParameter("url");
		String browser = test.getParameter("browser");
		String unm = test.getParameter("unm");
		String pwd = test.getParameter("pwd");
		String email = test.getParameter("email");

		//Print on Console
		System.out.println(url);
		System.out.println(browser);
		System.out.println(unm);
		System.out.println(pwd);
		System.out.println(email);




	}

}
