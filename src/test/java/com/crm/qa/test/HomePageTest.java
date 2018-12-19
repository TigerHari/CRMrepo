package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contactspage;
	TestUtil testutil;

	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialization();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		contactspage = new ContactsPage();
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority =1)
	public void gettitleofHomepage()
	{
		String Homepagetitle = homepage.Getpagetitle();
		System.out.println(Homepagetitle);
		Assert.assertEquals(Homepagetitle, "CRMPRO","Home page title not matched, the expected home page title is: CRMPRO");
	}
	
	@Test(priority =2)
	public void  ClickOnContactslink()
	{
		testutil.SwitchToFrame();
		homepage.ClickonContactslink();
	}
	
	@Test(priority =3)
	public void clickonNewContacts()
	{
		
		testutil.SwitchToFrame();
		homepage.ClickonNewContact();
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
}
