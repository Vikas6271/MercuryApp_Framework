package com.testingmasters.hrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Pg2_HomePage extends BasePage {

	public  Pg2_HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		}
		
		@FindBy(how=How.XPATH,using="//b[text()='My Info']")
		WebElement MyInfo;
		@FindBy(how=How.XPATH,using="//b[text()='Leave']")
		WebElement Leave;
		@FindBy(how=How.XPATH,using="//b[text()='Time']")
		WebElement Time;
		@FindBy(how=How.XPATH,using="//b[text()='Performance']")
		WebElement Performance;
		@FindBy(how=How.XPATH,using="//b[text()='Dashboard']")
		WebElement Dashboard;
		@FindBy(how=How.XPATH,using="//b[text()='Directory']")
		WebElement Directory;
		
 public void click_MyInfo(){
	 weblib_clickElement(MyInfo);
	 logEvent("Able to click on MyInfo", "Unble to click on MyInfo", stepstatus, driver);
 }
		
}
