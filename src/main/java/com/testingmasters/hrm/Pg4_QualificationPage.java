package com.testingmasters.hrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Pg4_QualificationPage extends BasePage{
	public Pg4_QualificationPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//Input[@id='addWorkExperience']")
	WebElement Add_Workexp;
	
	@FindBy(how=How.XPATH,using="//input[@id='delWorkExperience']")
	WebElement Dlt_Workexp;
	
	@FindBy(how=How.XPATH,using="//input[@id='addEducation']")
	WebElement Add_Education;
	
	@FindBy(how=How.XPATH,using="//input[@id='delEducation']")
	WebElement Dlt_Education;
	
	@FindBy(how=How.XPATH,using="//input[@id='addSkill']")
	WebElement Add_Skill;
	
	@FindBy(how=How.XPATH,using="//input[@id='delSkill']")
	WebElement Dlt_Skill;
	
	@FindBy(how=How.XPATH,using="//input[@id='addLanguage']")
	WebElement Add_Lang;
	
	@FindBy(how=How.XPATH,using="//input[@id='delLanguage']")
	WebElement Dlt_Lang;
	
	@FindBy(how=How.XPATH,using="//input[@id='addLicense']")
	WebElement Add_License;
	@FindBy(how=How.XPATH,using="//input[@id='delLicense']")
	WebElement Dlt_License;

	@FindBy(how=How.XPATH,using="//input[@id='btnAddAttachment']")
	WebElement Add_Attc;

	@FindBy(how=How.XPATH,using="//input[@id='btnAddAttachment']")
	WebElement Dlt_Attc;
	
	public void Add_Workexp(){
		weblib_clickElement(Add_Workexp);
		logEvent("Able to click on Add_Workexp", "Unable to click on Add_Workexp", stepstatus, driver);
	}
	public void Dlt_Workexp(){
		weblib_clickElement(Dlt_Workexp);
		logEvent("Able to click on Dlt_Workexp", "Unable to click on Dlt_Workexp", stepstatus, driver);
	}
	public void Add_Education(){
		weblib_clickElement(Add_Education);
		logEvent("Able to click on Add_Education", "Unable to click on Add_Education", stepstatus, driver);
	}
	public void Dlt_Education(){
		weblib_clickElement(Dlt_Education);
		logEvent("Able to click on Dlt_Education", "Unable to click on Dlt_Education", stepstatus, driver);
	}
	public void Add_Skill(){
		weblib_clickElement(Add_Skill);
		logEvent("Able to click on Add_Skill", "Unable to click on Add_Skill", stepstatus, driver);
	}
	public void Dlt_Skill(){
		weblib_clickElement(Dlt_Skill);
		logEvent("Able to click on Dlt_Skill", "Unable to click on Dlt_Skill", stepstatus, driver);
	}
	public void Add_Lang(){
		weblib_clickElement(Add_Lang);
		logEvent("Able to click on Add_Lang", "Unable to click on Add_Lang", stepstatus, driver);
	}
	public void Dlt_Lang(){
		weblib_clickElement(Dlt_Lang);
		logEvent("Able to click on Dlt_Lang", "Unable to click on Dlt_Lang", stepstatus, driver);
	}
	public void Add_License(){
		weblib_clickElement(Add_License);
		logEvent("Able to click on Add_License", "Unable to click on Add_License", stepstatus, driver);
	}
	public void Dlt_License(){
		weblib_clickElement(Dlt_License);
		logEvent("Able to click on Dlt_License", "Unable to click on Dlt_License", stepstatus, driver);
	}
	public void Add_Attc(){
		weblib_clickElement(Add_Attc);
		logEvent("Able to click on Add_Attc", "Unable to click on Add_Attc", stepstatus, driver);
	}
	public void Dlt_Attc(){
		weblib_clickElement(Dlt_Attc);
		logEvent("Able to click on Dlt_Attc", "Unable to click on Dlt_Attc", stepstatus, driver);
	}

}
