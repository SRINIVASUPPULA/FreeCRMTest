package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	public HomePage() throws IOException {
		PageFactory.initElements(driver, this); //below elements are initialized
	}

	@FindBy(xpath="//td[contains(text(),'User: ')]")
	WebElement userLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	public String verifyHomepageTitle() {
	return driver.getTitle();
	}
	public ContactsPage ClickOnContactsLink() throws IOException{
		contactsLink.click();
		return new ContactsPage();
	}
	public DealsPage ClickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage ClickOnTasksLink() {
		tasksLink.click();
		return new TasksPage(); //every link that redirects to other page should return it's page object-through this we can access elements on that page
	}
	
	public boolean verifyCorrectUsername() {
		//needs to switch to Frame
		return userLabel.isDisplayed();
	}
	
}
