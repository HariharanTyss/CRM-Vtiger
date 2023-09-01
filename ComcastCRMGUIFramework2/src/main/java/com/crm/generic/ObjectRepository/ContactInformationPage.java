package com.crm.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage 
{
	public ContactInformationPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}



	@FindBy(xpath  = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement linkogrlogo;

	@FindBy(name = "lastname")
	private WebElement lastnameTF;

	@FindBy(id = "phone")
	private WebElement phonenumberTF;

	@FindBy(name = "button")
	private WebElement saveButton;

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactname;

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

	public WebElement getcontactname() {
		return contactname;
	}
	public WebElement getlastnameTF() {
		return lastnameTF;
	}
	public WebElement getsaveButton() {
		return saveButton;
	}
	public WebElement getlinkogrlogo() {
		return linkogrlogo;
	}

	
}
