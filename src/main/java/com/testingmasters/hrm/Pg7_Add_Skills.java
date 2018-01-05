package com.testingmasters.hrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Pg7_Add_Skills extends BasePage {

	public Pg7_Add_Skills(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//select[@id='skill_code']")
	WebElement Skill;
	
	@FindBy(how=How.XPATH,using="//input[@id='skill_years_of_exp']")
	WebElement YREXP;
	
	@FindBy(how=How.XPATH,using="//textarea[@id='skill_comments']")
	WebElement COMMEnt;
	
	@FindBy(how=How.XPATH,using="//input[@id='btnSkillSave']")
	WebElement Save;

	
	@FindBy(how=How.XPATH,using="//input[@id='skillCheckAll']")
	WebElement check;
	
	@FindBy(how=How.XPATH,using="//form[@id='frmDelSkill']/table/tbody/tr/td[2]")
	WebElement verify;
	
	public void Add_Skill(){
		weblib_clickElement(Skill);
		weblib_setOptionInSelect(Skill, "Selenium");
		logEvent("Abe to select Skill", "Unabe to select Skill", stepstatus, driver);
		
		weblib_setText(YREXP, "2");
		logEvent("Able to enter yearexp", "Able to enter yearexp", stepstatus, driver);
		
		weblib_setText(COMMEnt, "quygGFE");
		logEvent("Able to enter comment", "Unable to enter comment", stepstatus, driver);
		
		weblib_clickElement(Save);
		logEvent("Able to click save ", "Unable to click save", stepstatus, driver);
		
		weblib_clickElement(check);
		logEvent("Able to click on checkbox", "Unable to click on check box", stepstatus, driver);
	}
	public void verify(){
		weblib_exists(verify);
		logEvent("Records deleted sucessfully", "Unable to delete records", stepstatus, driver);
	}
}
