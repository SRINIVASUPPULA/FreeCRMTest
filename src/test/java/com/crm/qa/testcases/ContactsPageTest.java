package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	public ContactsPageTest() throws IOException {
		super();
	}

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		loginpage = new LoginPage();
		testutil = new TestUtil();
		contactspage = new ContactsPage();
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToMainFrame();
		homepage.ClickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactspage.verifyContactslabel(),"Contact text is Missing on page");
	}
	
	@Test(priority=2)
	public void selectSingleContactTest() {
		contactspage.selectContacts("David M");
	}
	@Test(priority=3)
	public void selectmultipleContactTest() {
		contactspage.selectContacts("David M");
		contactspage.selectContacts("Naveen Bangalore");
	}
	
	
	
	@AfterMethod
	public void teardown() throws IOException {
		//driver.quit();
	}
	
	
	
	
	
}
