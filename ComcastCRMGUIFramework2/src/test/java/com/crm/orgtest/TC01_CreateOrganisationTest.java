package com.crm.orgtest;

import org.testng.annotations.Test;

import com.crm.comcast.Basetest.BaseClass;
import com.crm.generic.ObjectRepository.HomePage;
import com.crm.generic.ObjectRepository.OrganisationPage;
import com.crm.generic.ObjectRepository.OrganizationInformationPage;

public class TC01_CreateOrganisationTest extends BaseClass
{

	@Test
	public void createorganisation() throws Throwable {
		
		wdu.waitForPageToLoad(driver);
		String accname = exu.getDataFromExcelFile("Organisation", 1, 2);
		int randomno=jau.getrandomnumber();
		String accountname = accname+randomno;
		//String accountname = "Qsp1875";
		
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
