package com.testingmasters.hrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Pg9_Add_license extends BasePage {

	public Pg9_Add_license(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//select[@id='license_code']")
	WebElement Licencetype;
	
	@FindBy(how=How.XPATH,using="//Input[@id='license_license_no']")
	WebElement Licenceno;
	
	@FindBy(how=How.XPATH,using="//input[@id='license_date']")
	WebElement Issueddate;
	
	@FindBy(how=How.XPATH,using="//input[@id='license_renewal_date']")
	WebElement Expdate;
	
	
	@FindBy(how=How.XPATH,using=".//input[@id='btnLicenseSave']")
	WebElement save;
	
	
	@FindBy(how=How.XPATH,using="//input[@id='licenseCheckAll']")
	WebElement Check;
	
	@FindBy(how=How.XPATH,using="//form[@id='frmDelLicense']/table/tbody/tr/td[2]")
	WebElement verify;
	
	
	public void Add_Licence(){
		weblib_clickElement(Licencetype);
		weblib_setOptionInSelect(Licencetype, "Adhar Card");
		logEvent("Able to select Licencetype", "Unable to select Licencetype", stepstatus, driver);
		
		weblib_setText(Licenceno, "442165384215");
		logEvent("Able to enter license number", "Unable to enter license number", stepstatus, driver);
		
		weblib_setDateinCalender(Issueddate, "2012-02-10");
		weblib_setDateinCalender(Expdate, "2032-02-10");
		 weblib_clickElement(save);
		 logEvent("Able to click on save", "unAble to click on save ", stepstatus, driver);
		 weblib_clickElement(Check);
	}
	public void verify(){
		weblib_exists(verify);
		logEvent("Records deleted sucessfully", "Unable to delete records", stepstatus, driver);
	}
	
}
