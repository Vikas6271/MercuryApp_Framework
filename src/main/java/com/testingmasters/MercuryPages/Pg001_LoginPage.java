 package com.testingmasters.MercuryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Pg001_LoginPage extends BasePage
{
	public Pg001_LoginPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='userName']")
	WebElement Edt_Username;
	
	@FindBy(how=How.XPATH,using="//input[@name='password']")
	WebElement Edt_Password;
	
	@FindBy(how=How.XPATH,using="//input[@name='login']")
	WebElement Btn_Login;
	
	@FindBy(how=How.XPATH,using="//img[@src='/images/masts/mast_flightfinder.gif']")
	WebElement Exit_Element;
//	@FindBy(how=How.XPATH,using="")
	
	public void login()
	{
//		weblib_setText(Edt_Username, "Vignesh");
		weblib_setText(Edt_Username, "vikas6271");
		logEvent("Able to enter username", "Unable to enter username", stepstatus,driver);
		
		weblib_setText(Edt_Password, "trinity999");
		logEvent("Able to enter username", "Unable to enter Password", stepstatus,driver);
		
		weblib_clickElement(Btn_Login);
		logEvent("Able to click on login", "Unable to click on login", stepstatus,driver);
		
		weblib_exists(Exit_Element);
		logEvent("Element Exist", "Element Not Exist", stepstatus, driver);
	}
	
	public void launchApplication()
	{
		
		weblib_launchApplication(CommVar_BaseURL,driver);
		weblib_SetImplicitWait(10, driver);
		logEvent("Application Launched successfuly", "Unable to Launch Application", stepstatus,driver);
	}

}
