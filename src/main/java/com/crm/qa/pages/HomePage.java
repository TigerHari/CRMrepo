package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	
	@FindBy(xpath = "//a[@title='Contacts']")
	WebElement Contactslink;
	
	@FindBy(xpath ="//a[@title='New Contact']")
	WebElement NewContact;
	
	@FindBy(xpath = "//a[@title = 'Deals']")
	WebElement Dealslink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String Getpagetitle()
	{
		return driver.getTitle();
	}
	
	public void ClickonContactslink()
	{
		Contactslink.click();
		
	}
	
	public ContactsPage ClickonNewContact()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(Contactslink).build().perform();
		 NewContact.click();
		 
		 return new ContactsPage();
		 	
	}
	
	public DealsPage DealsLinkClick()
	{
		Dealslink.click();
		return new DealsPage();
	}
	
	
	
	
	
	

}
