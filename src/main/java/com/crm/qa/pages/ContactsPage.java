package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
     WebElement contactLabel;
	
	
	@FindBy(id="first_name")
    WebElement  firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement savebtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver,this);
	}
	
	
	public boolean verifyContactsLabel() {
		return contactLabel.isDisplayed();
	}
	
	public void selectContactsByname(String name) {
		driver.findElement(By.xpath("//a[(text()='"+name+"')]//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createNewContact1(String title,String ftname,String ltname,String Comp) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstName.sendKeys(ftname);
		lastName.sendKeys(ltname);
		company.sendKeys(Comp);
		savebtn.click();
	}
	
	public void createNewContact() {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText("Mrs.");
		firstName.sendKeys("Salony");
		lastName.sendKeys("Sinha");
		company.sendKeys("Google");
		savebtn.click();
	}
}
