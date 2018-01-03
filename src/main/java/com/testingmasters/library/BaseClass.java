package com.testingmasters.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;


public class BaseClass extends ExtentionMethods
{
	protected WebDriver driver;

	@BeforeSuite
	public void BeforeSuite() 
	{
		// read properties from config file and set to common variables
		Properties prop = new Properties();
		InputStream input;
		try 
		{
			input = new FileInputStream("Config//Configuration.properties");
			prop.load(input);
		} 
		catch (Exception e) 
		{
			System.out.println("Unable to load data from configuraton.properties file");
		}

		// get the property value and print it out
		CommVar_ProjectName = prop.getProperty("ProjectName");
		CommVar_Environment = prop.getProperty("Environment");
		CommVar_BrowserName = prop.getProperty("BrowserName");
		CommVar_BaseURL = prop.getProperty("BaseURL");
		CommVar_DataFilesPath = prop.getProperty("DataFilesPath");
		CommVar_UserName = prop.getProperty("UserName");
		CommVar_Password = prop.getProperty("Password");
		CommVar_EnableRecordVideo = prop.getProperty("EnableRecordVideo");
		CommVar_EnableLog4JReports = prop.getProperty("EnableLog4JReports");
		CommVar_EnableExtentReports = prop.getProperty("EnableExtentReports");
		CommVar_TakeScreenshotForEveryStep = prop.getProperty("TakeScreenshotForEveryStep");
		CommVar_TakeScreenshotForOnlyFailedSteps = prop.getProperty("TakeScreenshotForOnlyFailedSteps");
		CommVar_RecepientsEmail = prop.getProperty("RecepientsEmail");

		// get current folder path
		CurrentFolderPath = System.getProperty("user.dir") + "\\Results";

		// create folder with date and time stamp
		DateFormat dateTimeInstance = SimpleDateFormat.getDateTimeInstance();
		String DateTimeStamp = dateTimeInstance.format(Calendar.getInstance().getTime());
		DateTimeStamp = DateTimeStamp.replace(",", "");
		DateTimeStamp = DateTimeStamp.replace(" ", "_");
		DateTimeStamp = DateTimeStamp.replace(":", "-");
		CurrentFolderPath = CurrentFolderPath + "\\" + DateTimeStamp;
		File dir = new File(CurrentFolderPath);
		dir.mkdir();
		
		File dir1 = new File(CurrentFolderPath + "\\Screenshots");
		dir1.mkdir();

		// set log4j logger directory path
		try 
		{
			FileInputStream in = new FileInputStream("Config//Log4j.properties");
			Properties log4jprop = new Properties();
			log4jprop.load(in);
			in.close();

			log4jprop.setProperty("log4j.appender.R.File", CurrentFolderPath + "\\log4j-application.log");
			log4jprop.setProperty("log4j.appender.HTML.File", CurrentFolderPath + "\\log4j-application.html");

			OutputStream output = new FileOutputStream("Config//Log4j.properties");
			log4jprop.store(output, null);
		} catch (Exception e) 
		{

		}
		PropertyConfigurator.configure("Config//Log4j.properties");

		// create extent report
		CommVar_report = new ExtentReports(CurrentFolderPath + "\\Summary.html", true);

	}

	@BeforeMethod
	public void BeforeMethod(Method m1) 
	{
		if (CurrentTestData != null)
			CurrentTestData.clear();
		CurrentTestCasename = m1.getName();
		CurrentModuleName = m1.getDeclaringClass().getSimpleName();
		CurrentTestData = elib_loadData(CurrentTestCasename, CurrentModuleName);

		CommVar_test = CommVar_report.startTest(CurrentTestCasename);
		System.out.println("<<TestStart>>" + CurrentTestCasename);
		CommVar_logger.info("<<TestStart>>" + CurrentTestCasename);
		
		
		driver = weblib_launchBrowser();
	}

	@BeforeClass
	public void BeforeClass() 
	{
		CommVar_logger = Logger.getLogger(this.getClass());
	}

	@AfterMethod
	public void AfterMethod(ITestResult result) 
	{
		CommVar_report.endTest(CommVar_test);
		System.out.println("<<TestSuccess>>" + result.getName());
		CommVar_logger.info("<<TestSuccess>>" + result.getName());
		CommVar_logger.info("");
		CommVar_logger.info("");
		CommVar_logger.info("");
		driver.close();
	}

	@AfterSuite
	public void AfterSuite() 
	{
		CommVar_report.close();

		weblib_SentMailAttachment(CurrentFolderPath + "\\Summary.html", "EmailAttachment",
				"Please find the following attachment",
				CommVar_RecepientsEmail);
		
		WebDriver driver = new FirefoxDriver();
		driver.get(CurrentFolderPath + "\\Summary.html");
	}
}
