package demo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.Basetest.BaseClass;

public class DemoTest 
{
	@Test
	public void demotest2()
	{
		String url=System.getProperty("unm");
		String pwd=System.getProperty("pwd");
		
		System.out.println(url);
		System.out.println(pwd);
		System.out.println(" DEMO TEST 2");
		//Assert.fail();
		
	}

}
