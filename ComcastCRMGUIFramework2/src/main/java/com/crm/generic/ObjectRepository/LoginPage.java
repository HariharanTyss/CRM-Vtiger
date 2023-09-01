package com.crm.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}

	@FindBy(name = "user_name")
	private WebElement usernameTF;

	@FindBy(name = "user_password")
    private	WebElement PasswordTF;

	@FindBy(id = "submitButton")
	private WebElement loginbutton;


	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return PasswordTF;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}
	public void Login(String unm,String pswd) 
	{
		usernameTF.sendKeys(unm);
		PasswordTF.sendKeys(pswd);
		loginbutton.click();;
		
	}

}
