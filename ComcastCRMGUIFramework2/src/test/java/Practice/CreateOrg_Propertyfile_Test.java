package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrg_Propertyfile_Test
{
	static WebDriver driver ;
	public static void main(String[] args) throws IOException 
	{
		System.setProperty("webdriver.gecko.driver", "./src/main/resources/Drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/Drivers/chromedriver.exe");

		FileInputStream fis1=new FileInputStream("./src/test/resources/Testdata/data.properties");
		Properties p=new Properties();
		p.load(fis1);

		//Launch Browser 
		String browsername=p.getProperty("browser");
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
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//Enter Login credential
		driver.findElement(By.name("user_name")).sendKeys(p.getProperty("unm"));
		driver.findElement(By.name("user_password")).sendKeys(p.getProperty("pwd"));

		//click on loginbutton
		driver.findElement(By.id("submitButton")).click();

		//click on Organisation Link
		driver.findElement(By.xpath("(//a[contains(text(),'Organizations')])[1]")).click();

		//click on Create Organisation Logo
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		//Enter the Organisation Name
		driver.findElement(By.name("accountname")).sendKeys("Tyss123434");

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
