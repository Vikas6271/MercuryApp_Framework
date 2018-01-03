package com.testingmasters.MercuryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Pg003_PrefarancePage extends BasePage 
{
	public Pg003_PrefarancePage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//input[@value='Business']")
	WebElement Service_Class;
	
	@FindBy(how=How.XPATH,using="//select[@name='airline']")
	WebElement Airelines;
	
	@FindBy(how=How.XPATH,using="//input[@name='findFlights']")
	WebElement Continue;
	public void Prefarance(){
		weblib_clickElement(Service_Class);
		logEvent("Business Class selected successfully", "Business Class Selection is not successful", stepstatus, driver);
	
		weblib_setOptionInSelect(Airelines, "Unified Airlines");
		logEvent("Airelines selected successfully", "Airelines Selection is not successful", stepstatus, driver);
		weblib_clickElement(Continue);
		logEvent("Able to click on Continue", "Unable to click on Continue", stepstatus,driver);
		
	}
}
	

	
