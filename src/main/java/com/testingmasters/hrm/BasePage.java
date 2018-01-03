package com.testingmasters.hrm;

import org.openqa.selenium.WebDriver;

import com.testingmasters.library.Util;

public class BasePage extends Util
{
protected WebDriver driver;
	
	public BasePage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
	}
	
	public WebDriver getDriver()
	{
		return this.driver;
	}
}
