package com.crm.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	TestUtil testutil;
	LoginPage loginpage;
	ContactsPage contactspage;
	HomePage homepage;
	
	String sheetname = "contacts";

	public ContactsPageTest()
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
		
		testutil.SwitchToFrame();
		contactspage = homepage.ClickonNewContact();
				
	}
	
	@Test(priority =1, dataProvider = "gettestdata")
	public void CreateNewContact(String title, String firstname, String lastname, String company)
	{
		contactspage.CreateNewContact(title, firstname, lastname, company);
	}
	
	@DataProvider
	public Object[][] gettestdata()
	{
		Object data[][] = TestUtil.getTestData(sheetname);
		return data;
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	
}
