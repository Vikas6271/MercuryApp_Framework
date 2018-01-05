package com.testingmasters.hrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Pg8_Add_Language extends BasePage{

	public Pg8_Add_Language(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//select[@id='language_code']")
	WebElement Language;
	
	@FindBy(how=How.XPATH,using="//select[@id='language_lang_type']")
	WebElement Fluency;
	
	@FindBy(how=How.XPATH,using="//select[@id='language_competency']")
	WebElement competency;
	
	@FindBy(how=How.XPATH,using="//textarea[@id='language_comments']")
	WebElement comment;
	
	@FindBy(how=How.XPATH,using="//input[@id='btnLanguageSave']")
	WebElement Save;
	
	@FindBy(how=How.XPATH,using="//input[@id='languageCheckAll']")
	WebElement checkbox;
	
	
	@FindBy(how=How.XPATH,using="//table[@id='lang_data_table']/tbody/tr/td[2]")
	WebElement verify;
	
	
	
	
	public void Add_lang(){
		weblib_clickElement(Language);
		weblib_setOptionInSelect(Language, "English");
		logEvent("Able to select language", "Unable to select language", stepstatus, driver);
		
		weblib_clickElement(Fluency);
		weblib_setOptionInSelect(Fluency, "Writing");
		logEvent("Able to select Writing", "Unable to select Writing", stepstatus, driver);
		
		weblib_clickElement(competency);
		weblib_setOptionInSelect(competency, "Good");
		logEvent("Able to select competency", "Unable to select competency", stepstatus, driver);
		
		weblib_setText(comment, "yugfuwgifsd");
		logEvent("Able to enter comment", "Unable to enter comment", stepstatus, driver);
		
		weblib_clickElement(Save);
		logEvent("Able to click on save ", "Unable to cick on save", stepstatus, driver);
		
		weblib_clickElement(checkbox);
		logEvent("Able to click on checkbox ", "Unable to cick on checkbox", stepstatus, driver);
	}
public void verify(){
	weblib_exists(verify);
	logEvent("Records deleted sucessfully", "Unable to delete records", stepstatus, driver);
}
}
