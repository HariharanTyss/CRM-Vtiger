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

import com.mysql.jdbc.Driver;

public class TC01_CreateOrganizationTest
{
	static WebDriver driver ;
	public static void main(String[] args) throws IOException, SQLException 
	{
		System.setProperty("webdriver.gecko.driver", "./src/main/resources/Drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/Drivers/chromedriver.exe");

		Driver driver1=new Driver();
		DriverManager.registerDriver(driver1);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdata","root","root");
		//Launch Browser 
		String url = "" ;
		String browser = "";
		String unm = "" ;
		String pwd="" ;

		ResultSet uname = conn.createStatement().executeQuery("select uname from data where pswd='manager'");
		while(uname.next()) {
			unm=uname.getString("uname");
		}
		ResultSet pswd = conn.createStatement().executeQuery("select pswd from data where uname='admin'");
		while(pswd.next()) {
			pwd=pswd.getString("pswd");
		}
		ResultSet Url = conn.createStatement().executeQuery("select url from data where uname='admin'");
		while(Url.next()) {
			url=Url.getString("url");
		}
		ResultSet Browser = conn.createStatement().executeQuery("select browser from data where uname='admin'");
		while(Browser.next()) {
			browser=Browser.getString("browser");
		}
		conn.close();
		//Launch Browser 
		String browsername=browser;
		System.out.println(browsername);
		if(browsername.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browsername.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			//Default executed Browser
			driver=new ChromeDriver();
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
		driver.findElement(By.name("accountname")).sendKeys("Tyssss");

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
