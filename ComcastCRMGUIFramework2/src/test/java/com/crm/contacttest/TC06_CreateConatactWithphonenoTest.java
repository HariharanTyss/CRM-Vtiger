package com.crm.contacttest;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.comcast.Basetest.BaseClass;
import com.crm.generic.ObjectRepository.ContactInformationPage;
import com.crm.generic.ObjectRepository.ContactPage;
import com.crm.generic.ObjectRepository.HomePage;
import com.crm.generic.ObjectRepository.OrganisationPage;
import com.crm.generic.ObjectRepository.OrganizationInformationPage;

public class TC06_CreateConatactWithphonenoTest  extends BaseClass
{
	@Test(groups = "smoke")
	public void createContactwithPhone() throws Throwable 
	{
		wdu.waitForPageToLoad(driver);
		String accname = exu.getDataFromExcelFile("contact", 1, 3);
		String phoneno = exu.getDataFromExcelFile("contact", 1, 4);

		int randomno=jau.getrandomnumber();
		String accountname = accname+randomno;

		//Entering into Homepage
		HomePage homepg=new HomePage(driver);

		//click on Contact Link
		homepg.getcontactlink().click();

		//click on Create New Contact Logo
		ContactPage contactpg=new ContactPage(driver);
		contactpg.getCreatecontactlogo().click();

		//Enter the Contact Name
		ContactInformationPage contactinfopg=new ContactInformationPage(driver);

		//Enter the Contact Name
		contactinfopg.getlastnameTF().sendKeys(accountname);
		
		//Enter Phone Number
		contactinfopg.getphonenumberTF().sendKeys(phoneno);
		
		//Fetching parent address
		String prntwindow = driver.getWindowHandle();
		System.out.println(prntwindow);
		
		//click on link org logo
		contactinfopg.getlinkogrlogo().click();
		
		//Fetching all windows Address
		Set<String> allwindows = driver.getWindowHandles();
		allwindows.remove(prntwindow);
		
		//Switch control from parent to child
		for (String window : allwindows) 
		{
			System.out.println(window);
			driver.switchTo().window(window);
			driver.findElement(By.xpath("//a[contains(text(),'Qspider')]")).click();
		}

		//Switch Back control to parent
		driver.switchTo().window(prntwindow);

		//click on Save Button
		contactinfopg.getsaveButton().click();


		//verify the Contact Name is take or not

		String contactnamee = contactinfopg.getcontactname().getText();
		if(contactnamee.contains(accountname)) 
		{
			//verfify  Contact Name
			System.out.println(accountname+" is Created !! ");
		}
		else {
			System.out.println(accountname+" is Not created !!");
		}
		System.out.println("<<<Create Contact with Phone sucesss>>>");

	}

}
