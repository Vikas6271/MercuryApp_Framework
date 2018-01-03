package com.testingmasters.MercuryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Pg004_SelectFlight extends BasePage 
{
	public Pg004_SelectFlight(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//input[@value='Unified Airlines$363$281$11:24']")
	WebElement Newyork_Paris;
	@FindBy(how=How.XPATH,using="//input[@value='Unified Airlines$633$303$18:44']")
	WebElement Paris_Newyork;
	@FindBy(how=How.XPATH,using="//input[@name='reserveFlights']")
	WebElement SelectFlight;

	public void SelectFlight(){
		weblib_clickElement(Newyork_Paris);
		logEvent("Able To Select Paris Flight", "Unable To Select Paris Flight", stepstatus, driver);
		weblib_clickElement(Paris_Newyork);
		logEvent("Able To Select Newyork Flight", "Unable To Select Newyork Flight", stepstatus, driver);
		weblib_clickElement(SelectFlight);
		logEvent("able to select both flights ", "unable to select both files", stepstatus, driver);
	}
}
