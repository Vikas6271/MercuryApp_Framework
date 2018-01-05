package com.testingmasters.hrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Pg6_Add_Education extends BasePage {
	public Pg6_Add_Education(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//select[@id='education_code']")
	WebElement Level;
	
	@FindBy(how = How.XPATH, using = "//input[@id='education_institute']")
	WebElement Instute;
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='education_major']")
	WebElement Specalization;
	
	@FindBy(how=How.XPATH,using="//input[@id='education_year']")
	WebElement Year;
	
	@FindBy(how=How.XPATH,using="//input[@id='education_gpa']")
	WebElement Gpa;
	
	@FindBy(how=How.XPATH,using="//input[@id='education_start_date']")
	WebElement StartDate;
	
	
	@FindBy(how=How.XPATH,using="//input[@id='education_end_date']")
	WebElement EndDate;
	
	@FindBy(how=How.XPATH,using="//input[@id='btnEducationSave']")
	WebElement Save;
	
	@FindBy(how=How.XPATH,using="//input[@id='educationCheckAll']")
	WebElement Checkbox;
	
	@FindBy(how=How.XPATH,using="//div[@id='tblEducation']/table/tbody/tr/td[2]")
	WebElement verification;
	
	public void AddEdu(){
		weblib_clickElement(Level);
		logEvent("able to click", "Unable to click", stepstatus, driver);
		weblib_setOptionInSelect(Level, "B.Tech");
		logEvent("Able to select levell", "Unable to select level", stepstatus, driver);
		
		weblib_setText(Instute, "jaya prakash narayan college of engineering");
		logEvent("Able to enter instute name", "Unable to enter instute name", stepstatus, driver);
		
		weblib_setText(Specalization, "B.Tech ECE");
		logEvent("Able to enter Specalization ", "Unable to enter Specalization", stepstatus, driver);
		
		weblib_setText(Year, "2015");
		logEvent("Able to enter Year ", "Unable to enter Year", stepstatus, driver);
		
		weblib_setText(Gpa, "8.3");
		logEvent("Able to enter Gpa", "Unable to enter Gpa", stepstatus, driver);
		
		weblib_setDateinCalender(StartDate, "2011-06-10");
		logEvent("Able to enter Start date", "Unable to enter Start Date", stepstatus, driver);
		
		weblib_setDateinCalender(EndDate, "2015-08-10");
		logEvent("Able to enter End date", "Unable to enter End Date", stepstatus, driver);
		
		weblib_clickElement(Save);
		logEvent("Able to click on save ", "Unable to click on save ", stepstatus, driver);
		
		
		weblib_clickElement(Checkbox);
		logEvent("Able to click on Checkbox ", "Unable to click on checkbox", stepstatus, driver);
	}
		
		public void verify(){
			weblib_exists(verification);
			logEvent("Records deleted sucessfully", "Unable to delete records", stepstatus, driver);
		}
		
	
	
}
