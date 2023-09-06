package com.crm.contacttest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.comcast.Basetest.BaseClass;
import com.crm.generic.ObjectRepository.ContactInformationPage;
import com.crm.generic.ObjectRepository.ContactPage;
import com.crm.generic.ObjectRepository.HomePage;
import com.crm.generic.fileutility.ExcelUtility;
import com.crm.generic.listenerimplements.ListenerImplementation;
import com.crm.generic.webdriverutility.Webdriverutility;
@Listeners(com.crm.generic.listenerimplements.ListenerImplementation.class)
public class TC04_CreateContactTest extends BaseClass
{
	@Test(groups = "smoke")
	public void createContact() throws Throwable 
	{
		wdu.waitForPageToLoad(driver);
		//click on Contact Link in home page
		HomePage homepg=new HomePage(driver);
		homepg.getcontactlink().click();
		ListenerImplementation.test.log(Status.PASS, "Clicked Contact link in Header");

		//Click on Create Contaact Logo in Contact page
		ContactPage contactpg=new ContactPage(driver);
		contactpg.getCreatecontactlogo().click();
		ListenerImplementation.test.log(Status.PASS, "Clicked Create Contactlogo link in Header");

		//Enter the Conatct name in last Name Textfield
		ExcelUtility excel=new ExcelUtility();
		String contactname = excel.getDataFromExcelFile("contact", 1, 3);
		ContactInformationPage contactInfoPg=new ContactInformationPage(driver);
		contactInfoPg.getlastnameTF().sendKeys(contactname);
		ListenerImplementation.test.log(Status.PASS, "Entered Contact lastname ");

		System.out.println("createContact");

	}

}
