package com.crm.comcast.Basetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.crm.generic.ObjectRepository.LoginPage;
import com.crm.generic.fileutility.ExcelUtility;
import com.crm.generic.fileutility.FileUtility;
import com.crm.generic.webdriverutility.JavaUtility;
import com.crm.generic.webdriverutility.Webdriverutility;

public class BaseClass 
{
	public  WebDriver driver;
	public  static WebDriver extradriver ;
	public FileUtility fiu =new FileUtility();
	public ExcelUtility exu=new ExcelUtility();
	public JavaUtility jau=new JavaUtility();
	public Webdriverutility wdu=new Webdriverutility();
	
	@BeforeClass(groups = "smoke")
	public void browserSetup( ) throws Throwable {
		String browsername =System.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browsername.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browsername.equals("edge")) {
			driver=new EdgeDriver();
		}
		else {
			//Default executed Browser
			driver=new ChromeDriver();
		}
		
		extradriver=driver;
		// Navigate to url
		String url=System.getProperty("url");
		driver.get(url);
		driver.manage().window().maximize();
		System.out.println("open Browser");
		

	}
	//@Parameters({"username","password"})
	@BeforeMethod(groups = "smoke")
	public void login() throws Throwable {
		//Entering  Login credentials
		LoginPage  loginpg =new LoginPage(driver);
		
		String username=System.getProperty("username");
		String password=System.getProperty("password");
//		
		loginpg.Login(username, password);
		System.out.println("login");
		
	}
	@AfterMethod(groups = "smoke")
	public void logout() {

		//Mousehover to signOut logo 
		Actions ac=new Actions(driver);
		
		ac.moveToElement(driver.findElement(By.xpath("(//td[@class='small'])[2]"))).perform();

		//Click on signout Button
		driver.findElement(By.partialLinkText("Sign Out")).click();

		System.out.println("log out");
	}

	@AfterClass(groups = "smoke")
	public void closeBrowser() {
		driver.quit();
		System.out.println("close Browser");
	}
}
