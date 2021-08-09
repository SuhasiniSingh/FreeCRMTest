package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//PageFactory Object Repo
	
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type = 'submit']")
	WebElement LoginBtn;
	
	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement crmlogo;
	
	public LoginPage()  {
		PageFactory.initElements(driver, this);
		}
	
	//Actions/methods of login feature
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMimage() {
		return crmlogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		LoginBtn.click();
		return new HomePage();
	}
	
}
