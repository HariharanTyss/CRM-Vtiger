package com.crm.generic.listenerimplements;

import org.openqa.selenium.TakesScreenshot;
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
public class ListenerImplementation implements ITestListener,ISuiteListener
{
	public ExtentReports report;
	public ExtentTest test;

	public void onStart(ISuite suite) 
	{
		/* Config the Extent Spark Reporter */
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdavnceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.STANDARD);

		/* Add Environmrnt information And Create TEst*/
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Device", "Admin1");
		report.setSystemInfo("OS", "winndows-11");
		report.setSystemInfo("Browser", "Chrome-116");
		
	}
	

	public void onFinish(ISuite suite) {
		/* REport BAckups*/
		report.flush();
	}

	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName()+"<<Started Test EXecution>>");
		
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,result.getName()+"<< Test Sucess >>");
		
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.INFO, result.getName());
		
		TakesScreenshot ssdriver=(TakesScreenshot)BaseClass.extradriver;
		// TODO Auto-generated method stub
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}




}
