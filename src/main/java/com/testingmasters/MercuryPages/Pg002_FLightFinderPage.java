package com.testingmasters.MercuryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Pg002_FLightFinderPage extends BasePage {
	public Pg002_FLightFinderPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@value='roundtrip']")
	WebElement Btn_TripType;

	@FindBy(how = How.XPATH, using = "//select[@name='passCount']")
	WebElement Select_Passenger;

	@FindBy(how = How.XPATH, using = "//select[@name='fromPort']")
	WebElement Departing_From;

	@FindBy(how = How.XPATH, using = "//select[@name='fromMonth']")
	WebElement Departing_Month;
	
	@FindBy(how = How.XPATH, using = "//select[@name='fromDay']")
	WebElement Departing_Date;
	
	@FindBy(how = How.XPATH, using = "//select[@name='toPort']")
	WebElement Arriving_In;

	@FindBy(how = How.XPATH, using = "//select[@name='toMonth']")
	WebElement Returning_Month;
	
	@FindBy(how = How.XPATH, using = "//select[@name='toDay']")
	WebElement Returning_Date;
	
	
	public void TripDetails() {
		weblib_clickElement(Btn_TripType);
		logEvent("TripType Selected successful", "TripType Selection is not successful", stepstatus, driver);
	
		weblib_setOptionInSelect(Select_Passenger, "2");
		logEvent("Able to click on MY Info Link", "Unable to click on MY Info Link", stepstatus, driver);

		weblib_setOptionInSelect(Departing_From, "New York");
		logEvent("Departure point selected sucessfully", "Departure point selection is not sucessful", stepstatus, driver);
	
		weblib_setOptionInSelect(Departing_Month, "December");
	
		weblib_setOptionInSelect(Departing_Date, "29");
	
		weblib_setOptionInSelect(Arriving_In, "Paris");
		logEvent("Arriving point selected sucessfully", "Arriving point selection is not sucessful", stepstatus, driver);
	
		weblib_setOptionInSelect(Returning_Month, "January ");
		logEvent("Return Month point selected sucessfully", "Return Month point selection is not sucessful", stepstatus, driver);
	
	
		weblib_setOptionInSelect(Returning_Date, "29");
		logEvent("Return Date selected sucessfully", "Return Date selection is not sucessful", stepstatus, driver);
	}
}
