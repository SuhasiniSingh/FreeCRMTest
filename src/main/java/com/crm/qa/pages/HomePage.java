package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//Page factory or object repository
	
	@FindBy(xpath = "//td[contains(text(),'User: group automation')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealssLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	public HomePage()  {
		PageFactory.initElements(driver, this);
		}
	
	//Actions
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactstab() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public void clickOnNewContactLink()  {
		Actions action = new  Actions(driver);
		action.moveToElement(contactsLink).clickAndHold(newContactsLink).click().build().perform();
		}
	
	public TasksPage clickOntaskstab() {
		tasksLink.click();
		return new TasksPage();
	}
  
	public boolean verifyUsernameLabel() {
		return userNameLabel.isDisplayed();
	}
	
	
	
	
	
	
	
	
}
