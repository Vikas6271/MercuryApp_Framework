package com.testingmasters.hrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Pg3_MyInfoPage extends BasePage {
	public Pg3_MyInfoPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//a[text()='Personal Details']")
	WebElement PersonalDetails;
	@FindBy(how=How.XPATH,using="//a[text()='Contact Details']")
	WebElement ContactDetails;
	@FindBy(how=How.XPATH,using="//a[text()='Emergency Contacts']")
	WebElement EmergencyContacts;
	@FindBy(how=How.XPATH,using="//a[text()='Dependents']")
	WebElement Dependents;
	@FindBy(how=How.XPATH,using="//a[text()='Immigration']")
	WebElement Immigration;
	@FindBy(how=How.XPATH,using="//a[text()='Job']")
	WebElement Job;
	@FindBy(how=How.XPATH,using="//a[text()='Salary']")
	WebElement Salary;
	@FindBy(how=How.XPATH,using="//a[text()='Report-to']")
	WebElement Reportto;
	@FindBy(how=How.XPATH,using="//a[text()='Qualifications']")
	WebElement Qualifications;
	@FindBy(how=How.XPATH,using="//a[text()='Memberships']")
	WebElement Memberships;
	public void Qualifications(){
		weblib_clickElement(Qualifications);
		logEvent("Able to click on Qualifications", "Unable to click on Qualifications", stepstatus, driver);
	}
}
