package com.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.comcast.Basetest.BaseClass;
import com.crm.generic.ObjectRepository.HomePage;
import com.crm.generic.ObjectRepository.LoginPage;
import com.crm.generic.ObjectRepository.OrganisationPage;
import com.crm.generic.ObjectRepository.OrganizationInformationPage;
import com.crm.generic.fileutility.ExcelUtility;
import com.crm.generic.fileutility.FileUtility;
import com.crm.generic.webdriverutility.Webdriverutility;

public class TC02_CreateOrganizationwithIndustryTest extends BaseClass
{
	@Test
	public void createOrgwithIndustry() throws Throwable 
	{
		wdu.waitForPageToLoad(driver);
		String accname = exu.getDataFromExcelFile("Organisation", 1, 2);
		String industry_option = exu.getDataFromExcelFile("Organisation", 1, 4);
		String account_option = exu.getDataFromExcelFile("Organisation", 1, 5);
		
		int randomno=jau.getrandomnumber();
		String accountname = accname+randomno;

		//Entering into Homepage
		HomePage homepg=new HomePage(driver);

		//click on Organisation Link
		homepg.getorganizationslink().click();

		//click on Create NewOrganisation Logo
		OrganisationPage orgpg= new OrganisationPage(driver);
		orgpg.getCreateOrganizationlogo().click();

		//Enter the Organisation Name
		OrganizationInformationPage orginfopg=new OrganizationInformationPage(driver);

		//Enter the Organisation Name
		orginfopg.getaccountnameTF().sendKeys(accountname);

		//select third Option in Acount Type Dropdown

		wdu.selectDropdown( driver,orginfopg.getactypedropdown(), 3);

		//Select Energy Option in industry Type Dropdown
		wdu.selectDropdown(driver,orginfopg.getindustrydropdown(), "Energy");

		//click on Save Button
		orginfopg.getsaveButton().click();
		
		//verify the organisation Name is take or not
		try {
			boolean orgname = orginfopg.getorganisationname().isDisplayed();
			if(orgname) {
				//verfify  organisation Name
				System.out.println(accountname+" is Created ");
			}
		}
		catch (Exception e) {
			driver.switchTo().alert().accept();
			System.out.println("Organisation Not created/Organization Name Already Exists!");
		}

	}

}
