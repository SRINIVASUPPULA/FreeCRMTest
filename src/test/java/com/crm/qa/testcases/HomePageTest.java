package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
//ctrl+shift+O - to import all the required packages
public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	public HomePageTest() throws IOException {
		super();
	}

	//Testcases should be seperated - independent to each other
	//before each testcase - launch the browser and Login
	//after each testcase - close the browser and delete AllCookies
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		testutil = new TestUtil();
		contactspage = new ContactsPage();
	}
	
	@Test(priority=1)
	public void verifyhomePageTitle() {
		String title =  homepage.verifyHomepageTitle();
		Assert.assertEquals(title, "CRMPRO","Homepage Title Not Found"); //displays message if the title not matched only
	}
	
	@Test(priority=2)
	public void verifyUserName() {
		testutil.switchToMainFrame();
		Assert.assertTrue(homepage.verifyCorrectUsername());
	}
	
	@Test(priority=3)
	public void verifyContactlistLink() throws IOException {
		testutil.switchToMainFrame();
		contactspage = homepage.ClickOnContactsLink();
	}
	
	@AfterMethod
	public void teardown() throws IOException {
		driver.quit();
	}
	
}
