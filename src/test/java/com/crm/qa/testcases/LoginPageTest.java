package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;

public LoginPageTest() throws IOException{
		super();
	//initializes the properties also-
	}

@BeforeMethod
public void setup() throws IOException {
	initialization();
	loginpage = new LoginPage();	
}

@Test(priority=1)
public void LoginPageTitleTest() {
	String title = loginpage.ValidateLoginPageTitle();
	System.out.println(title);
//	Assert.assertEquals(title, "CRMPRO  - CRM software for customer relationship management, sales, and support."); //assertions are important to validate
}
@Test(priority=2)
public void CRMLogoTest() {
	boolean flag = loginpage.ValidateCRMLogo();
	Assert.assertTrue(flag);
}
@Test(priority=3)
public void loginTest() throws IOException {
	loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
}


@AfterMethod
public void teardown() throws IOException {
	driver.quit();
}
	
}
