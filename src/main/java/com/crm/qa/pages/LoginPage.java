package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class LoginPage extends TestBase{
	
	//Page Factory - OR
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginbtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this); // PageFactory initialise elements
	}
	
	
	
	//Functions:
	public String validateloginpagetitle()
	{
		
		return driver.getTitle();
	}
	
	public HomePage Login(String un, String pwd) throws InterruptedException
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(3000);
		loginbtn.click();
		
		return new HomePage();
	}
	
	
	
	
	
	
	
	
}
