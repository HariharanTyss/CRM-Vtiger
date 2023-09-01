package com.crm.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	public OrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}

	@FindBy(name = "accountname")
	private WebElement accountnameTF;
	
	@FindBy(id = "phone")
	private WebElement phonenumberTF;
	
	@FindBy(name = "button")
	private WebElement saveButton;

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement organisationname;
	
	@FindBy(name = "industry")
	private WebElement industrydropdown;
	
	@FindBy(name = "accounttype")
	private WebElement actypedropdown;
	
	public WebElement getphonenumberTF() {
		return phonenumberTF;
	}

	public WebElement getactypedropdown() {
		return actypedropdown;
	}
	
	public WebElement getindustrydropdown() {
		return industrydropdown;
	}
	
	public WebElement getorganisationname() {
		return organisationname;
	}
	public WebElement getaccountnameTF() {
		return accountnameTF;
	}
	public WebElement getsaveButton() {
		return saveButton;
	}

}
