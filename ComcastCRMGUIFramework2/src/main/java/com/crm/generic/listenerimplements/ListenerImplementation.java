package com.crm.generic.listenerimplements;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.comcast.Basetest.BaseClass;
/**
 * 
 * @author Hariharan
 * 
 * Listener Implementation class for Configuring Test report Log
 *
 */
public class ListenerImplementation  implements ITestListener,ISuiteListener 
{
	public ExtentReports report;
	public static ExtentTest test;

	public void onStart(ISuite suite) 
	{
		Date date=new Date();
		//System.out.println(date);
		String cdate = date.toString().replace(" ", "_").replace(":", "_");

		/* Config the Extent Spark Reporter */
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdavnceReport/Report"+cdate+".html");
		spark.config().setDocumentTitle("CRM Test Suite/Advanced ");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		/* Add Environmrnt information And Create TEst*/
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Device", "Admin");
		report.setSystemInfo("OS", "winndows-11-pro");
		report.setSystemInfo("Browser", "Chrome-116.0");

	}


	public void onFinish(ISuite suite) {
		/* REport BAckups*/
		report.flush();
	}

	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName()+" <<Started Test Execution>>");

	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,result.getName()+" << Test Sucess >>");

	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.INFO, result.getName()+"<< Test Failed >>");

		TakesScreenshot screenshot=(TakesScreenshot)BaseClass.extradriver;
		String src = screenshot.getScreenshotAs(OutputType.BASE64);
		
		test.addScreenCaptureFromBase64String(src);

		
		}





	}
