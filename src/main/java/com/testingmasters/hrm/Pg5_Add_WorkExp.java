package com.testingmasters.hrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Pg5_Add_WorkExp extends BasePage {
	public Pg5_Add_WorkExp (WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//input[@id='experience_employer']")
	WebElement Company;
	
	@FindBy(how=How.XPATH,using="//input[@id='experience_jobtitle']")
	WebElement JobTitle;
	
	@FindBy(how=How.XPATH,using="//input[@id='experience_from_date']")
	WebElement FromDate;
	
	@FindBy(how=How.XPATH,using="//input[@id='experience_to_date']")
	WebElement ToDate;
	
	@FindBy(how=How.XPATH,using="//textarea[@id='experience_comments']")
	WebElement Comment;
	
	@FindBy(how=How.XPATH,using="//input[@id='btnWorkExpSave']")
	WebElement Save;
	
	@FindBy(how=How.XPATH,using="//input[@id='workCheckAll']")
	WebElement Delete;
	
	
	
	
	@FindBy(how=How.XPATH,using="//form[@id='frmDelWorkExperience']/table/tbody/tr/td[2]")
	WebElement verify;
	public void AddWorkExp(){
		weblib_setText(Company, "XYZ Informatics Pvt Ltd");
		logEvent("Able to enter Company", "Unable to enter Company", stepstatus, driver);
		weblib_setText(JobTitle, "Senior Software Engineer");
		logEvent("Able to enter job title", "Unable to enter job title", stepstatus, driver);
		weblib_setDateinCalender(FromDate, "2015-12-10");
		logEvent("Able to enter from date ", "Unable to enter from date ", stepstatus, driver);
		weblib_setDateinCalender(ToDate, "2017-06-10");
		logEvent("Able to enter  to date ", "Unable to enter to date ", stepstatus, driver);
		weblib_setText(Comment, "Hi");
		logEvent("Able to enter  Comment ", "Unable to enter Comment ", stepstatus, driver);
		weblib_clickElement(Save);
		logEvent("Able to click on Save button ", "Unable to click on Save button", stepstatus, driver);
		weblib_clickElement(Delete);
		logEvent("Able to click on check box", "unable to click on check box", stepstatus, driver);
	}
	public void verification(){
		weblib_exists(verify);
		logEvent("Records deleted sucessfully", "Unable to delete records", stepstatus, driver);
	}
	

}
