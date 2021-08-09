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

public class HomePageTest extends TestBase{
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initializtaion();
		 testUtil = new TestUtil();
		LoginPage loginPage = new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password") );
	
	}
	
	@Test(priority =1)
	public void validateHomePageTitleTest() {
		String HomepageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(HomepageTitle, "CRMPRO","Homepage title not matched");
	}
	
	@Test(priority =2)
	public void validateUserLabelTest() {
	testUtil.switchToFrame();
	boolean ImageuserLabel=	homePage.verifyUsernameLabel();
	Assert.assertTrue(ImageuserLabel);
	}
	
	@Test(priority =3)
	public void validateContactsTabTest() {
		testUtil.switchToFrame();
		contactsPage =homePage.clickOnContactstab();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
