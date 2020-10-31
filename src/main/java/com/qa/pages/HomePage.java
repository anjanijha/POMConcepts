package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath="//span[@class=\"user-display\"]")
	WebElement userNameLable;
	@FindBy(xpath="//span[contains(text(),'Contacts') and @class=\"item-text\"]")
	WebElement contactsLinks;
	@FindBy(xpath="//span[contains(text(),' New Contacts') and @class=\"item-text\"]")
	WebElement newcontactsLinks;
	@FindBy(xpath="//span[contains(text(),'Deals') and @class=\"item-text\"]")
	WebElement dealsLinks;
	@FindBy(xpath="//span[contains(text(),'Tasks') and @class=\"item-text\"]")
	WebElement taskLinks;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLable.isDisplayed();
	}
	
	
	public Contacts clickOnContactsLink() {
		contactsLinks.click();
		return new Contacts();
	}
	public DealsPage clickDealsLink() {
		dealsLinks.click();
		return new DealsPage();
	}
	public TasksPage clickTasksLink() {
		taskLinks.click();
		return new TasksPage();
	}
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLinks).build().perform();
		newcontactsLinks.click();
		
	}
	
}

