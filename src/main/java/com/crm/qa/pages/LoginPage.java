package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {


	//Page Factory - object Repository
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signupBtn;
	
	@FindBy(xpath = "//img[@class='img-responsive']")
	WebElement crmLogo;
	
	//Initializing the page Objects
	public LoginPage() throws IOException{
		PageFactory.initElements(driver, this);
	}
	//Actions
	public String ValidateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean ValidateCRMLogo() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage Login(String uname,String pwd) throws IOException {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage(); //return Homepage object - redirects to HomePage
	}
	
}
