package com.crm.comcast.Basetest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class DemoBaseclass 
{
	@BeforeSuite
	public void beforeSuiteConfig() {
		System.out.println("===Database Conection &Report Configuration===");
	}
	@BeforeClass
	public void openBrowser() {
		System.out.println("open Browser");
	}
	@AfterClass
	public void closeBrowser() {
		System.out.println("close Browser");
	}
	@BeforeMethod
	public void login() {
		System.out.println("login");
	}
	@AfterMethod
	public void logout() {
		System.out.println("log out");
	}
	@AfterSuite
	public void afterSuiteConfig() {
		System.out.println("===Terminate Database Connection and Report Gneration====");
	}
	
	
	

}
