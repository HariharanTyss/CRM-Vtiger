package demo;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.crm.comcast.Basetest.DemoBaseclass;

public class DemoTest extends DemoBaseclass
{
	@Test
	public void demotest1() throws IOException, Throwable {
		WebDriver driver= new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		
		Thread.sleep(2000);
		EventFiringWebDriver efwd=new EventFiringWebDriver(driver);
		
		File src = efwd.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/ss1.png");
		
		FileHandler.copy(src, dest);
		driver.quit();
		System.out.println(" DEMO TEST 1");
	}

	
	

}
