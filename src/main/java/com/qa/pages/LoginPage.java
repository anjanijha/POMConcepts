package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {
	//Page Factory -OR
	@FindBy(name="email")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//div[@class=\"ui fluid large blue submit button\"]")
	WebElement loginBtn;
	@FindBy(xpath="//*[contains(text(),\"Sign Up\" )]")
	WebElement signBtn;
	@FindBy(xpath="//*[@class=\"background\"]")
	WebElement crmlogo;
	//Intialtiztion the page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean validateCRMImage() {
		return crmlogo.isDisplayed();
		
	}
	public HomePage login(String user,String pass) throws InterruptedException {
		username.sendKeys(user);
		password.sendKeys(pass);
		//loginBtn.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", loginBtn);
		return new HomePage();
	}

}
