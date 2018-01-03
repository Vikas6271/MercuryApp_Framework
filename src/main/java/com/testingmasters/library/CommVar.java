package com.testingmasters.library;

import java.util.HashMap;


import org.apache.log4j.Logger;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class CommVar 
{
	protected static String CommVar_ProjectName;
	protected static String CommVar_Environment;
	protected static String CommVar_BrowserName;
	protected static String CommVar_BaseURL;
	protected static String CommVar_DataFilesPath;
	protected static String CommVar_UserName;
	protected static String CommVar_Password;
	protected static String CommVar_EnableRecordVideo;
	protected static String CommVar_EnableLog4JReports;
	protected static String CommVar_EnableExtentReports;
	protected static String CommVar_TakeScreenshotForEveryStep;
	protected static String CommVar_TakeScreenshotForOnlyFailedSteps;
	protected static String CommVar_RecepientsEmail;
	protected static ExtentReports CommVar_report;
	protected static ExtentTest CommVar_test;
	protected static HashMap<String,String> CurrentTestData;
	protected static String CurrentFolderPath;
	protected static Logger CommVar_logger;
	protected static String CurrentTestCasename;
	protected static String CurrentModuleName;
	protected static  String ScreenShotPath;
	
	
}
