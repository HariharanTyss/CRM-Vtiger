package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class StaleDemo {
	

public static void main(String[] args) {
	
	WebDriver driver=new ChromeDriver();
	driver.get("https://demowebshop.tricentis.com/books?orderby=6");
	
	bookPage p=new bookPage(driver);
	
	WebElement sortBy = p.getsortBy();
	Select s=new Select(sortBy);
	s.selectByVisibleText("Price: Low to High");
	
	WebElement sortBy2 = p.getsortBy();
	Select s2=new Select(sortBy);
	//s2.selectByVisibleText("Price: Low to High");
	s2.selectByIndex(0);
	driver.quit();
	
}
}
