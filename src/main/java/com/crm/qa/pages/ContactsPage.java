package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath = "//input[@id ='first_name']")
	WebElement firstname;
	
	@FindBy(xpath = "//input[@id ='surname']")
	WebElement lastname;
	
	@FindBy(xpath = "//input[@name='client_lookup']")
	WebElement company;
	
	
	@FindBy(xpath = "//td[@colspan='2' and @valign ='top' and @align ='center']")
	WebElement Savebutton;
	
	public ContactsPage()
	{
		
			PageFactory.initElements(driver, this);
		
	}
	
	public void CreateNewContact(String title, String fn, String ln, String Comp)
	{
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstname.sendKeys(fn);
		lastname.sendKeys(ln);
		company.sendKeys(Comp);
		
		Savebutton.click();
		
		
	}
	
	 

}
