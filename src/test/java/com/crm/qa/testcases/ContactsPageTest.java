package com.crm.qa.testcases;

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
	
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initializtaion();
		 testUtil = new TestUtil();
		LoginPage loginPage = new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password") );
		testUtil.switchToFrame();
		contactsPage =homePage.clickOnContactstab();
	
	}

	@Test(priority=1)
	public void validateContactsLabelTest() {
	Assert.assertTrue(contactsPage.verifyContactsLabel(),"contacts label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectContacts() {
		contactsPage.selectContactsByname("Demo2021 User");
	}
	
	@Test(priority=3,enabled=true)
	public void validateNewContactTest() {
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
