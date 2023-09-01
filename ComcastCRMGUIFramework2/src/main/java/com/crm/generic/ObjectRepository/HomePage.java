package com.crm.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	//a[contains(text(),'Organizations')])[1]

			public HomePage(WebDriver driver)
			{
				PageFactory.initElements( driver,this);
			}

			@FindBy(partialLinkText = "Organizations")
			private WebElement organizationslink;
			
			@FindBy(partialLinkText = "Sign Out")
			private WebElement signoutlink;
			
			@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
			private WebElement signoutlogo;

			@FindBy(partialLinkText  = "Contacts")
			private WebElement contactlink;

			public WebElement getorganizationslink() {
				return organizationslink;
			}

			public WebElement getcontactlink() {
				return contactlink;
			}
			public WebElement getsignoutlogo() {
				return signoutlogo;
			}
			public WebElement getsignoutlink() {
				return signoutlink;
			}
}
