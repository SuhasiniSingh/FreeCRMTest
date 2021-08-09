package com.crm.qa.testcases;



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
	//super keyword is used to call parent class constructor
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initializtaion();
	 loginpage = new LoginPage();
		
	}
	
	@Test
	public void loginPageTitleTest() {
		String LoginPageTitle = loginpage.validatePageTitle();
		Assert.assertEquals(LoginPageTitle, "Free CRM - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test
	public void crmlogoImageTest() {
		boolean Image=loginpage.validateCRMimage();
		Assert.assertTrue(Image);
	}
    
	@Test
	public void Logintest() {
	homepage  =	loginpage.login(prop.getProperty("username"),prop.getProperty("password") );
		
	}


    @AfterMethod
    public void tearDown() {
    	driver.quit();
	}
	}