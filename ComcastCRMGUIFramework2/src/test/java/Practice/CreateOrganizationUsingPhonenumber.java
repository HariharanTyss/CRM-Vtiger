package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

public class CreateOrganizationUsingPhonenumber 
{

	static WebDriver driver ;
	public static void main(String[] args) throws IOException, SQLException 
	{
		System.setProperty("webdriver.gecko.driver", "./src/main/resources/Drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/Drivers/chromedriver.exe");
		
		//Common Data From Properties file
		FileInputStream fis1=new FileInputStream("./src/test/resources/Testdata/data.properties");
		Properties p=new Properties();
		p.load(fis1);

		String url = p.getProperty("url");
		String browser = p.getProperty("browser");
		String unm = p.getProperty("unm");
		String pwd = p.getProperty("pwd");
		String email = p.getProperty("email");

		//Launch Browser
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		// Navigate to url
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Enter Login credential
		driver.findElement(By.name("user_name")).sendKeys(unm);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		
		//click on loginbutton
		driver.findElement(By.id("submitButton")).click();
		
		//click on Organisation Link
		driver.findElement(By.xpath("(//a[contains(text(),'Organizations')])[1]")).click();

		//click on Create Organisation Logo
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		//Enter the Organisation Name
		driver.findElement(By.name("accountname")).sendKeys("Tyss");
		
		//Find the Industry DropDown
		WebElement industrydropdown = driver.findElement(By.name("industry"));
		
		//Select Energy Option
		Select select1=new Select(industrydropdown);
		select1.selectByVisibleText("Energy");
		
		//Find the TypeDropdown
		WebElement actypedropdown = driver.findElement(By.name("accounttype"));
		
		//Select type Dropdown
		Select select2=new Select(actypedropdown);
		select2.selectByVisibleText("Analyst");
		
		//
		driver.findElement(By.id("phone")).sendKeys("9876543210");

		//click on Save Button
		driver.findElement(By.name("button")).click();

		//verify the organisation Name is take or not
		try {
			WebElement orgname = driver.findElement(By.xpath("//div[@id='tblOrganizationInformation']/table/tbody/tr[1]/td[2]"));
			if(orgname.isDisplayed()) {
				//verfify  organisation Name
				System.out.println(orgname.getText().trim()+" is Created ");
			}
		}
		catch (Exception e) {
			driver.switchTo().alert().accept();		
			System.out.println("Organisation Not created/Organization Name Already Exists!");
		}

		//Mousehover to signOut logo
		Actions ac=new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();

		//Click on signout Button
		driver.findElement(By.partialLinkText("Sign Out")).click();

		driver.quit();
	}

}
