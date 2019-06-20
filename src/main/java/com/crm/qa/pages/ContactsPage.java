package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	//custom contact David M checkbox- /html[1]/body[1]/table[2]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/form[1]/form[1]/table[1]/tbody[1]/tr[5]/td[1]/input[1]
	//a[text()='David M']//parent::td[@class='datalistrow']//preceding-sibling::'datalistrow']//input[@name='contact_id']
	
	
	// Initialzing PageOjects
	public ContactsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactslabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContacts(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::'datalistrow']//input[@name='contact_id']")).click();
	}
}