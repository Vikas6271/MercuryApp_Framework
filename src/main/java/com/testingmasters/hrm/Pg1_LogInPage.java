package com.testingmasters.hrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Pg1_LogInPage extends BasePage {

	public Pg1_LogInPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//input[@id='txtUsername']")
	WebElement Username;
	
	@FindBy(how=How.XPATH,using="//input[@id='txtPassword']")
	WebElement Password;
	
	@FindBy(how=How.XPATH,using="//input[@id='btnLogin']")
	WebElement Login;
	
	@FindBy(how=How.XPATH,using="//a[@id='welcome']")
	WebElement HomePage;
	@FindBy(how=How.XPATH,using="//div[@id='welcome-menu']/ul/li[3]/a")
	WebElement logout;

public void launchapp(){
	weblib_launchApplication(CommVar_BaseURL, driver);
	weblib_SetImplicitWait(10, driver);
	logEvent("sucusfully launch browser", "unable to launch app", stepstatus, driver);
}
public void login(){
	weblib_setText(Username, CommVar_UserName);
	logEvent("Able to enter user name ", "unable to enter user name ", stepstatus, driver);
	weblib_setText(Password, CommVar_Password);
	logEvent("able to enter password", "unable to enter password ", stepstatus, driver);
	weblib_clickElement(Login);
	logEvent("able to click login butten", "unable to click login butten", stepstatus, driver);
	weblib_exists(HomePage);
	logEvent("AApllication login sucessfull", "Apllication login failed", stepstatus, driver);
	
}

public void logout(){
	weblib_clickElement(HomePage);
	weblib_clickElement(logout);
	logEvent("logout", "logout not done", stepstatus, driver);
}
	
}
