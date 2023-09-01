package com.crm.generic.webdriverutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriverutility 
{
		

	
	public void waitForPageToLoad(WebDriver driver)
	{

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void waitForElementPresent(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	public void switchToWindow(WebDriver driver,String window)
	{
		String parentwindow = driver.getWindowHandle();
		driver.switchTo().window(window);
	}
	public void selectDropdown(WebDriver driver,WebElement dropdwn,String option)
	{
		Select sel=new Select(dropdwn);
	    sel.selectByVisibleText(option);
	}
	public void selectDropdown(WebDriver driver,WebElement dropdwn,int optionindex)
	{
		Select sel=new Select(dropdwn);
	    sel.selectByIndex(optionindex);
	}

	public void mouseHoverToElement(WebDriver driver,WebElement element) 
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(element).perform();
	}


}
