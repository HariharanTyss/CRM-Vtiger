package demo;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.Basetest.DemoBaseclass;
//@Listeners(com.crm.generic.listenerimplements.ListenerImplementation.class)
public class DemoTest1 extends DemoBaseclass
{
	@Test
	public void demotest1()
	{
		
		System.out.println(" DEMO TEST 1");
		
		Assert.fail();
	}

	
	

}
