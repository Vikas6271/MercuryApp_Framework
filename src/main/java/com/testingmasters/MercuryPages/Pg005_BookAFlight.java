package com.testingmasters.MercuryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Pg005_BookAFlight extends BasePage
{
	public Pg005_BookAFlight(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//input[@name='passFirst0']")
	WebElement FirstPassFirst;
	@FindBy(how=How.XPATH,using="//input[@name='passLast0']")
	WebElement FirstPassLast;
	@FindBy(how=How.XPATH,using="//Select[@name='pass.0.meal']")
	WebElement FirstMeal;
	@FindBy(how=How.XPATH,using="//Select[@name='pass.1.meal']")
	WebElement SecondMeal;
	@FindBy(how=How.XPATH,using="//input[@name='passFirst1']")
	WebElement SecondPassFirst;
	@FindBy(how=How.XPATH,using="//input[@name='passLast1']")
	WebElement SecondPassLast;
	@FindBy(how=How.XPATH,using="//select[@name='creditCard']")
	WebElement SelectCard;
	@FindBy(how=How.XPATH,using="//input[@name='creditnumber']")
	WebElement CardNumber;
	@FindBy(how=How.XPATH,using="//input[@name='cc_frst_name']")
	WebElement CardFirstName;
	@FindBy(how=How.XPATH,using="//input[@name='cc_last_name']")
	WebElement CardLastName;
	@FindBy(how=How.XPATH,using="//select[@name='cc_exp_dt_mn']")
	WebElement ExpirationMonth;
	@FindBy(how=How.XPATH,using="//select[@name='cc_exp_dt_yr']")
	WebElement ExpirationYear;
	@FindBy(how=How.XPATH,using="//input[@name='billAddress1']")
	WebElement BillingAdress;
	@FindBy(how=How.XPATH,using="//input[@name='billCity']")
	WebElement BillingCity;
	@FindBy(how=How.XPATH,using="//input[@name='billZip']")
	WebElement BillZip;
	@FindBy(how=How.XPATH,using="//select[@name='billCountry']")
	WebElement Country;
	@FindBy(how=How.XPATH,using="html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[15]/td[2]/input")
	WebElement DelivaryAdress;
	@FindBy(how=How.XPATH,using="//input[@name='buyFlights']")
	WebElement BuyFlights ;
public void PassDetails(){
	weblib_setText(FirstPassFirst, "Vikas");
	logEvent("Able to enter FirstPassFirst Name", "Able to enter FirstPassFirst Name", stepstatus, driver);
	weblib_setText(FirstPassLast, "Kandela");
	logEvent("Able to enter FirstPassLast Name", "Able to enter FirstPassLast Name", stepstatus, driver);
	weblib_setOptionInSelect(FirstMeal, "Low Cholesterol");
	logEvent("Able to Select MEAL for FIRSTPASS", "Unable to Select Meal for FirstPass", stepstatus, driver);
	weblib_setText(SecondPassFirst, "Vignesh");
	logEvent("Able to enter SecondPassFirst Name", "Unable to enter SecondPassFirst Name", stepstatus, driver);
	weblib_setText(SecondPassLast, "Chary");
	logEvent("Able to enter SecondPassFirst Name", "Unable to enter SecondPassFirst Name", stepstatus, driver);
	weblib_setOptionInSelect(SecondMeal, "Low Cholesterol");
	logEvent("Able to Select MEAL for secondPASS", "Unable to Select Meal for secondPass", stepstatus, driver);
	
}
public void CardDetails(){
	Weblib_selectOptionByText(SelectCard, "MasterCard");
	logEvent("Able to Select cardtype", "Unable to Select cardtype", stepstatus, driver);
	weblib_setText(CardNumber, "123456789");
	logEvent("Able to enter cardnumber", "Unable to to enter cardnumber", stepstatus, driver);
	weblib_setText(CardFirstName, "Vikas");
	logEvent("Able to enter CardFirstName", "Unable to to enter CardFirstName", stepstatus, driver);
	weblib_setText(CardLastName, "Kandela");
	logEvent("Able to enter CardLastName", "Unable to to enter CardLastName", stepstatus, driver);
	weblib_setOptionInSelect(ExpirationMonth, "10");
	logEvent("Able to Select ExpirationMonth", "Unable to Select ExpirationMonth", stepstatus, driver);
	weblib_setOptionInSelect(ExpirationYear, "2010");
	logEvent("Able to Select ExpirationYear", "Unable to Select ExpirationYear", stepstatus, driver);
}
public void BillingAdress(){
	weblib_setText(BillingAdress, "1325 Borregas Ave.");
	logEvent("Able to enter BillingAdress", "Unable to to enter BillingAdress", stepstatus, driver);
	weblib_setText(BillingCity, "Sunnyvale");
	logEvent("Able to enter BillingCity", "Unable to to enter BillingCity", stepstatus, driver);
	weblib_setText(BillZip, "94089");
	logEvent("Able to enter BillZip", "Unable to to enter BillZip", stepstatus, driver);
	weblib_setOptionInSelect(Country, "UNITED SATTES");
	logEvent("Able to Select Country", "Unable to Select Country", stepstatus, driver);
	weblib_clickElement(DelivaryAdress);
	weblib_clickElement(BuyFlights);
	logEvent("Able to click BuyFlights", "Unable to click BuyFlights", stepstatus, driver);
}
	
}
