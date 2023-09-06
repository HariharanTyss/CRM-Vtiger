package demo;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.Basetest.BaseClass;

public class DemoTest 
{
	@Test
	public void demotest2() throws InterruptedException
	{
		String url = System.getProperty("url");
		String unm = System.getProperty("unm");
		String pwd = System.getProperty("pwd");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		
		driver.findElement(By.name("user_name")).sendKeys(unm);
		Thread.sleep(1000);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		Thread.sleep(1000);
		driver.findElement(By.id("submitButton")).click();
		driver.quit();
		
	}

}
