package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.Contacts;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	Contacts contactPage; 
	public HomePageTest() {
		super();
	}
	//test cases should be separated-- independent with each other 
	//before each test cases -- launch the browser and login
	//@test-- execute test case 
	//after each test cases -- close the browser
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		contactPage= new Contacts();
		loginPage= new LoginPage();
		homePage=loginPage.login(pro.getProperty("email"),pro.getProperty("password"));
	}
	
	@Test(priority=1)
	public void varifyHomePageTitleTest() {
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"Cogmento CRM","Home page title not macted");
	}
	@Test(priority = 2)
	public void varifyUseNameTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	@Test(priority = 3)
	public void varifyContactsLinkTest() {
		contactPage= homePage.clickOnContactsLink();
	}
	
	
	@AfterMethod
	public void testDown() {
		driver.quit();
	}

}
