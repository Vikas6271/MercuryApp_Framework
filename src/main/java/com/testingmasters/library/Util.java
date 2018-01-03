package com.testingmasters.library;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class Util extends CommVar
{
	protected boolean stepstatus;
	protected WebDriver driver;
	
	public Util(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	
	public boolean weblib_setText(WebElement ele,String StrValue)
	{
		ScreenShotPath = null;
		try
		{
			ele.click();
			ele.clear();
			ele.sendKeys(StrValue);
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}		
		if(stepstatus)
		{
			if(CommVar_TakeScreenshotForEveryStep.equalsIgnoreCase("true"))
			{
				ScreenShotPath = getscreenshotWithHighlight(ele, this.driver);
			}
		}
		else
		{
			if(CommVar_TakeScreenshotForEveryStep.equalsIgnoreCase("true")||CommVar_TakeScreenshotForOnlyFailedSteps.equalsIgnoreCase("true"))
			{
				ScreenShotPath = getscreenshotWithHighlight(ele, this.driver);
			}
		}
		return stepstatus;
	}
	
	public boolean weblib_clickElement(WebElement ele)
	{
		ScreenShotPath = null;
		if(weblib_exists(ele))
		{
			if(stepstatus)
			{
				if(CommVar_TakeScreenshotForEveryStep.equalsIgnoreCase("true"))
				{
					ScreenShotPath = getscreenshotWithHighlight(ele, this.driver);
				}
			}
			else
			{
				if(CommVar_TakeScreenshotForEveryStep.equalsIgnoreCase("true")||CommVar_TakeScreenshotForOnlyFailedSteps.equalsIgnoreCase("true"))
				{
					ScreenShotPath = getscreenshotWithHighlight(ele, this.driver);
				}
			}
		}
		try
		{
			ele.click();
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		
		return stepstatus;
	}
	
	public WebDriver weblib_launchBrowser()
	{
		WebDriver Tempdriver = null;
		switch(CommVar_BrowserName.toLowerCase())
		{
			case "firefox":
			{
				boolean firefoxinvoked = false;
				try
				{
					Tempdriver = new FirefoxDriver();
					firefoxinvoked = true;
				}
				catch(Exception e)
				{
					firefoxinvoked = false;
				}
				if(firefoxinvoked==false)
				{
					System.setProperty("webdriver.gecko.driver", "BrowserServers\\geckodriver.exe");
					Tempdriver = new FirefoxDriver();
				}
				break;
			}
			case "ie":
			case "internetexplorer":
			{
				System.setProperty("webdriver.ie.driver", "BrowserServers\\IEDriverServer.exe");
				Tempdriver = new InternetExplorerDriver();
				break;
			}
			case "chrome":
			{
				System.setProperty("webdriver.chrome.driver","BrowserServers\\chromedriver.exe");
				Tempdriver = new ChromeDriver();
				break;
			}
			default:
			{
				System.out.println("please Select the correct browser");
			}
		}
		return Tempdriver;
	}
	
	public boolean weblib_launchApplication(String URL,WebDriver driver)
	{
		ScreenShotPath=null;
		try
		{
			driver.get(URL);
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	
	public String elib_getdata(String FieldName)
	{
		if(CurrentTestData.containsKey(FieldName))
		{
			return CurrentTestData.get(FieldName);
		}
		else
		{
			System.out.println("Data Not Found For '" + FieldName + "' Field");
			return null;
		}
		
	}

	
	public  boolean weblib_setDateinCalender(WebElement ele, String StrDate)
	{
		boolean stepstatus;
		try
		{
			ele.click();
			ele.sendKeys(StrDate);
			ele.sendKeys(Keys.ESCAPE);
			Thread.sleep(1000);
			stepstatus=true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	
	public static boolean weblib_setOptionInSelect(WebElement ele, String eleOption)
	{
		boolean stepstatus = false;
		try
		{
			Select s1 = new Select(ele);
			s1.selectByVisibleText(eleOption);
			stepstatus= true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	
	
	public  boolean weblib_exists(WebElement ele)
	{
		boolean stepstatus;
		try
		{
			ele.isDisplayed();
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	public  boolean weblib_mouseHover(WebElement ele, WebDriver driver)
	{
		boolean stepstatus;
		try
		{
			Actions a1 = new Actions(driver);
			a1.moveToElement(ele);
			a1.build().perform();
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	public  boolean weblib_rightClick(WebElement ele, WebDriver driver)
	{
		boolean stepstatus;
		try
		{
			Actions a1 = new Actions(driver);
			a1.contextClick(ele);
			a1.build().perform();
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	public  boolean weblib_doubleClick(WebElement ele, WebDriver driver)
	{
		boolean stepstatus;
		try
		{
			Actions a1 = new Actions(driver);
			a1.doubleClick(ele);
			a1.build().perform();
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	public  boolean weblib_dragAndDrop(WebElement drag,WebElement drop, WebDriver driver)
	{
		boolean stepstatus;
		try
		{
			Actions a1 = new Actions(driver);
			a1.dragAndDrop(drag, drop);
			a1.build().perform();
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	public  boolean weblib_JsclickElement(WebElement ele,WebDriver driver)
	{
		boolean stepstatus;
		try
		{
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", ele);
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	
	public  boolean weblib_JssetText(WebElement ele,String StrValue,WebDriver driver)
	{
		boolean stepstatus;
		try
		{
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].value='" + StrValue + ";", ele);
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	
	public  boolean weblib_JsScrollToWebElement(WebElement ele,WebDriver driver)
	{
		boolean stepstatus;
		try
		{
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();", ele);
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	public  boolean weblib_dismissAlert(WebElement ele,WebDriver driver)
	{
		boolean stepstatus;
		try
		{
			Alert a1 = driver.switchTo().alert();
			a1.dismiss();
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	public  boolean weblib_alertExist(WebElement ele,WebDriver driver)
	{
		boolean stepstatus;
		try
		{
			driver.switchTo().alert();
			stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	public  String weblib_alertGetText(WebElement ele,WebDriver driver)
	{
		String StrValue = "";
		try
		{
			Alert a1 = driver.switchTo().alert();
			StrValue = a1.getText();
		}
		catch(Exception e)
		{
			
		}
		return StrValue;
	}
	
	public  boolean weblib_isWindowExists(String URL,WebDriver driver)
	{
		boolean stepstatus = false;
		try
		{
			Set<String> allhandles = driver.getWindowHandles();
			for(String handle:allhandles)
			{
				driver.switchTo().window(handle);
				String CurrentURL = driver.getCurrentUrl();
				if(CurrentURL.contains(URL))
				{
					stepstatus = true;
					break;
				}
			}
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	
	
	
	
	public  WebDriver weblib_SwitchtoWindow(String URL,WebDriver driver)
	{
		try
		{
			Set<String> allhandles = driver.getWindowHandles();
			for(String handle:allhandles)
			{
				driver.switchTo().window(handle);
				String CurrentURL = driver.getCurrentUrl();
				if(CurrentURL.contains(URL))
				{
					break;
				}
			}
		}
		catch(Exception e)
		{
			
		}
		return driver;
	}
	
	
	
	public boolean  Weblib_selectOptionByText(WebElement ele, String eleOption)
	{
		boolean stepstatus = false;
		try
		{
			Select s1 = new Select(ele);
			s1.selectByVisibleText(eleOption);
			stepstatus= true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	
	public  WebDriver weblib_SwitchtoFrame(WebElement FrameRef,WebDriver driver)
	{
		try
		{
			driver.switchTo().frame(FrameRef);
		}
		catch(Exception e)
		{
			
		}
		return driver;
	}
	public  WebDriver weblib_SwitchtoParentDocument(String FrameRef,WebDriver driver)
	{
		try
		{
			driver.switchTo().defaultContent();
		}
		catch(Exception e)
		{
			
		}
		return driver;
	}
	public  WebDriver weblib_closeWindow(String URL,WebDriver driver)
	{
		try
		{
			Set<String> allhandles = driver.getWindowHandles();
			for(String handle:allhandles)
			{
				driver.switchTo().window(handle);
				String CurrentURL = driver.getCurrentUrl();
				if(CurrentURL.contains(URL))
				{
					driver.close();
					break;
				}
			}
		}
		catch(Exception e)
		{

		}
		return driver;
	}
	
	public  boolean weblib_RobotKeysFileUpload(String Filepath)
	{
		boolean stepstatus;
		try
		{
		   wait(2);
		   StringSelection selection = new StringSelection(Filepath);
	       Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	       clipboard.setContents(selection,selection);

			
			Robot robo = new Robot();   
			robo.keyPress(KeyEvent.VK_CONTROL);
	     	robo.keyPress(KeyEvent.VK_V);
	      	robo.keyRelease(KeyEvent.VK_V);
	      	robo.keyRelease(KeyEvent.VK_CONTROL);

	  		wait(2);
	      	robo.keyPress(KeyEvent.VK_ENTER);
	      	robo.keyRelease(KeyEvent.VK_ENTER);
	    	robo.keyPress(KeyEvent.VK_ENTER);
	      	robo.keyRelease(KeyEvent.VK_ENTER);
	      	wait(2);
	      	stepstatus = true;
		}
		catch(Exception e)
		{
			stepstatus = false;
		}
		return stepstatus;
	}
	public  boolean weblib_wait(int timeInSec)
	{
		boolean stepStatus;
		try
		{
			Thread.sleep(timeInSec*1000);
			stepStatus = true;
		}
		catch(Exception e)
		{
			stepStatus = false;
		}		
		return stepStatus;
	}
	public  boolean weblib_dynamicWait(By by,WebDriver driver,int waittimeinsec)
	{
			boolean status = false;
			int counter = 0;
			while(counter<=waittimeinsec)
			{
				try
				{
					driver.findElement(by);
					status = true;
					break;
				}
				catch(Exception e)
				{
					try 
					{
						Thread.sleep(1000);
					} catch (Exception e1) 
					{
						
					}
					counter = counter+ 1;
				}
			 }
			 if(counter>waittimeinsec)
			 {
				 status = false;
			 }
			 return status;
	}
	
	public  WebDriver weblib_SetImplicitWait(int TimeInSec,WebDriver driver)
    {
        try
        {
        	driver.manage().timeouts().implicitlyWait(TimeInSec, TimeUnit.SECONDS);
        }
        catch (Exception e)
        {
        }
        return driver;
    }
	public  String weblib_getTimeStamp() 
	{
		DateFormat dateTimeInstance = SimpleDateFormat.getDateTimeInstance();
	    String DateTimeStamp = dateTimeInstance.format(Calendar.getInstance().getTime());
	    DateTimeStamp = DateTimeStamp.replace(",", "");
	    DateTimeStamp = DateTimeStamp.replace(" ", "_");
	    DateTimeStamp = DateTimeStamp.replace(":", "-");
		return  DateTimeStamp;
	}
	public  String weblib_getscreenshot(WebDriver driver,String Dest)
	{
		  try
		  {
			StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
			StackTraceElement stackTraceElement = stackTraceElements[3];
			String CurrentTestCase = stackTraceElement.getMethodName();
			CurrentTestCase = CurrentTestCase.replace(".java", "");
			
			TakesScreenshot ts =(TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destinationfile = new File(Dest);
			FileUtils.copyFile(source, destinationfile);
			return Dest;
		  }
		  catch(Exception e)
		  {
			  return e.getMessage();
		  }
	}
	
	
	public  String weblib_createresultsfolder(String ResultsFolderPath) 
	{
		DateFormat dateTimeInstance = SimpleDateFormat.getDateTimeInstance();
	    String DateTimeStamp = dateTimeInstance.format(Calendar.getInstance().getTime());
	    DateTimeStamp = DateTimeStamp.replace(",", "");
	    DateTimeStamp = DateTimeStamp.replace(" ", "_");
	    DateTimeStamp = DateTimeStamp.replace(":", "-");
	    ResultsFolderPath = System.getProperty("user.dir") + "//" + ResultsFolderPath;
		File dir = new File(ResultsFolderPath + "//" +  DateTimeStamp);
		dir.mkdir();
		File dir2 = new File(ResultsFolderPath + "//" +  DateTimeStamp + "//Screenshots");
		dir2.mkdir();
		return ResultsFolderPath + "//" + DateTimeStamp;
	}
	public  boolean weblib_AutoITFileUpload(String AutoITFilePath,String Filepath)
    {
        Boolean stepStatus = true;
        try
        {
        	Runtime.getRuntime().exec(AutoITFilePath + " " + Filepath);
        }
        catch (Exception e)
        {
            stepStatus = false;
        }
        return stepStatus;
    }
	public  boolean weblib_AutoITFileUpload(String AutoITFilePath)
    {
        Boolean stepStatus = true;
        try
        {
        	Runtime.getRuntime().exec(AutoITFilePath);
        }
        catch (Exception e)
        {
            stepStatus = false;
        }
        return stepStatus;
    }
	
	public void logEvent(String PassMessage,String FailMessage,boolean stepstatus,WebDriver driver)
	{
		if(stepstatus==true)
		{
			System.out.println("	<<PASS>> " + PassMessage);
			CommVar_logger.info(PassMessage);
			if(CommVar_TakeScreenshotForEveryStep.equalsIgnoreCase("true"))
			{
				if(ScreenShotPath!=null)
				{
					String scn =  CommVar_test.addScreenCapture(ScreenShotPath);
					CommVar_test.log(LogStatus.PASS, PassMessage + scn);
				}
				else
				{
					CommVar_test.log(LogStatus.PASS, PassMessage);
				}
			}
			else
			{
				CommVar_test.log(LogStatus.PASS, PassMessage);
			}
		}
		else
		{
			System.out.println("	<<FAIL>> " + FailMessage);
			CommVar_test.log(LogStatus.FAIL, FailMessage);
			if(CommVar_TakeScreenshotForEveryStep.equalsIgnoreCase("true")||CommVar_TakeScreenshotForOnlyFailedSteps.equalsIgnoreCase("true"))
			{
				if(ScreenShotPath!=null)
				{
					String scn =  CommVar_test.addScreenCapture(ScreenShotPath);
					CommVar_test.log(LogStatus.FAIL, FailMessage + scn);
				}
				else
				{
					CommVar_test.log(LogStatus.FAIL, FailMessage);
				}
			}
			else
			{
				CommVar_test.log(LogStatus.FAIL, FailMessage);
			}
		}
		Assert.assertEquals(stepstatus, true);
	}
	
	
	public String getscreenshotWithHighlight(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js = null;
		  try
		  {
			  try
				{
				  js  = (JavascriptExecutor)driver;
				   js.executeScript("arguments[0].style.border='solid 4px black'", element);
				   Thread.sleep(200);
				}
				catch(Exception e)
				{
					
				}
			String Dest = CurrentFolderPath + "\\Screenshots\\";
			DateFormat dateTimeInstance = SimpleDateFormat.getDateTimeInstance();
			String DateTimeStamp = dateTimeInstance.format(Calendar.getInstance().getTime());
			DateTimeStamp = DateTimeStamp.replace(",", "");
			DateTimeStamp = DateTimeStamp.replace(" ", "_");
			DateTimeStamp = DateTimeStamp.replace(":", "-");
			
			Dest = Dest + CurrentTestCasename + DateTimeStamp +".png";
			
			
			
			TakesScreenshot ts =(TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destinationfile = new File(Dest);
			FileUtils.copyFile(source, destinationfile);
			
			// Get entire page screenshot
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			BufferedImage  fullImg = ImageIO.read(screenshot);

//			// Get the location of element on the page
//			Point point = element.getLocation();
//
//			// Get width and height of the element
//			int eleWidth = element.getSize().getWidth()+250;
//			int eleHeight = element.getSize().getHeight()+250;

			// Crop the entire page screenshot to get only element screenshot
//			BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
//			    eleWidth, eleHeight);
			ImageIO.write(fullImg, "png", screenshot);
			
			// Copy the element screenshot to disk
			File screenshotLocation = new File(Dest);
			FileUtils.copyFile(screenshot, screenshotLocation);
			
			 js.executeScript("arguments[0].style.border=''", element);
			 
			return Dest;
		  }
		  catch(Exception e)
		  {
			  return e.getMessage();
		  }
	}

}


class ExtentionMethods extends CommVar
{
	public HashMap<String,String> elib_loadData(String TestCaseName,String ModuleName)
	{
		HashMap<String,String> TestData = new HashMap<String,String>();
		try
		{		
			String FilePath = CommVar_DataFilesPath + "\\" + ModuleName + ".xlsx";
			File f1 = new File(FilePath);
			FileInputStream fis = new FileInputStream(f1);
			XSSFWorkbook wb1 = new XSSFWorkbook(fis);
			
			XSSFSheet ws1 = wb1.getSheet("TestData");
			
			int rowcount = ws1.getLastRowNum();
			for(int r = 0;r<=rowcount;r++)
			{
				if(ws1.getRow(r).getCell(0)!=null)
				{
					String Excel_TestCaseName = ws1.getRow(r).getCell(0).getStringCellValue();
					if(Excel_TestCaseName.equalsIgnoreCase(TestCaseName))
					{
						int datarow = r + 1;
						int valuerow = r + 2;
						int cellcount = ws1.getRow(datarow).getLastCellNum();
						for(int c = 0;c<cellcount;c++)
						{
							String ExcelFieldName="";
							String ExcelFieldValue="";
							if(ws1.getRow(datarow).getCell(c)!=null)
							ExcelFieldName = ws1.getRow(datarow).getCell(c).getStringCellValue();
							if(ws1.getRow(valuerow).getCell(c)!=null)
							ExcelFieldValue = ws1.getRow(valuerow).getCell(c).getStringCellValue();
							if(ExcelFieldName.length()>1)
							TestData.put(ExcelFieldName, ExcelFieldValue);
						}
						break;
					}
				}
			}
			fis.close();
			wb1.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception occured while reading data of '" + TestCaseName + "'  TestCase and '" + ModuleName + "' Module");
		}
		return TestData;
	}
	
	public Boolean weblib_SentMailAttachment(String AttachmentPath,String Subject,String Meassegebody,String ReceiverEmailId)
	{
		Boolean stepStatus = true;
		
		// Create object of Property file
				Properties props = new Properties();
				String  UserEmailIdTemp = "";
				String PasswordTemp = "";
				try
				{
					byte[] asBytesusername = Base64.getDecoder().decode("dGVzdGluZ21hc3RlcnMuc2VsZW5pdW1AZ21haWwuY29t");
					UserEmailIdTemp = new String(asBytesusername, "utf-8"); 
					
					byte[] asBytespassword = Base64.getDecoder().decode("UEFTUzEyMyFA");
					PasswordTemp = new String(asBytespassword, "utf-8"); 
					
				}
				catch(Exception e)
				{
					System.out.println("Unable to decode username and password");
				}
				
				final String  UserEmailId = UserEmailIdTemp;
				final String  Password = PasswordTemp;
				// this will set host of server- you can change based on your
				// requirement
				props.put("mail.smtp.host", "smtp.gmail.com");

				// set the port of socket factory
				props.put("mail.smtp.socketFactory.port", "465");

				// set socket factory
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

				// set the authentication to true
				props.put("mail.smtp.auth", "true");

				// set the port of SMTP server
				props.put("mail.smtp.port", "465");

				// This will handle the complete authentication
				Session session = Session.getDefaultInstance(props,

						new javax.mail.Authenticator() 
						{

							protected PasswordAuthentication getPasswordAuthentication() {

								
								return new PasswordAuthentication(UserEmailId, Password);

							}

						});

				try {

					// Create object of MimeMessage class
					Message message = new MimeMessage(session);

					// Set the from address
					message.setFrom(new InternetAddress(ReceiverEmailId));

					// Set the recipient address
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(ReceiverEmailId));

					// Add the subject link
					message.setSubject(Subject);

					// Create object to add multimedia type content
					BodyPart messageBodyPart1 = new MimeBodyPart();

					// Set the body of email
					messageBodyPart1.setText(Meassegebody);

					// Create another object to add another content
					MimeBodyPart messageBodyPart2 = new MimeBodyPart();

					// Mention the file which you want to send
					String filename = AttachmentPath;
					// Create data source and pass the filename
					DataSource source = new FileDataSource(filename);

					// set the handler
					messageBodyPart2.setDataHandler(new DataHandler(source));

					// set the file
					messageBodyPart2.setFileName(filename);

					// Create object of MimeMultipart class
					Multipart multipart = new MimeMultipart();

					// add body part 1
					multipart.addBodyPart(messageBodyPart2);

					// add body part 2
					multipart.addBodyPart(messageBodyPart1);

					// set the content
					message.setContent(multipart);

					// finally send the email
					Transport.send(message);
					
					System.out.println("=====Email Sent=====");
					
					stepStatus = true;

				} catch (MessagingException e) {
					System.out.println("=====Email Not Sent=====");
					stepStatus = false;

				}	
		
		
		return stepStatus;
		
		
	}
	
	public WebDriver weblib_launchBrowser()
	{
		WebDriver Tempdriver = null;
		switch(CommVar_BrowserName.toLowerCase())
		{
			case "firefox":
			{
				boolean firefoxinvoked = false;
				try
				{
					Tempdriver = new FirefoxDriver();
					
					firefoxinvoked = true;
				}
				catch(Exception e)
				{
					firefoxinvoked = false;
				}
				if(firefoxinvoked==false)
				{
					System.setProperty("webdriver.gecko.driver", "BrowserServers\\geckodriver.exe");
					Tempdriver = new FirefoxDriver();
				}
				break;
			}
			case "ie":
			case "internetexplorer":
			{
				System.setProperty("webdriver.ie.driver", "BrowserServers\\IEDriverServer.exe");
				Tempdriver = new InternetExplorerDriver();
				break;
			}
			case "chrome":
			{
				System.setProperty("webdriver.chrome.driver","BrowserServers\\chromedriver.exe");
				Tempdriver = new ChromeDriver();
				break;
			}
			default:
			{
				System.out.println("please Select the correct browser");
			}
		}
		return Tempdriver;
	}
}
