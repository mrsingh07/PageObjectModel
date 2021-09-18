package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase
{
	@FindBy(xpath = "//td[contains(text(),'User: Harry Singh')]")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[contains(text(), 'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath = "//a[contains(text(), 'New Deal')]")
	WebElement newDealsLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Cases')]")
	WebElement casesLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Call')]")
	WebElement callsLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Home')]")
	WebElement homeLink;
	
	//Initializing the Page Object
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName()
	{
		return userNameLabel.isDisplayed();
		
	}
	
	public void clickOnHomePageLink()
	{
		homeLink.click();
	}
	
	public ContactsPage clickOnContactsLink()
	{
		contactsLink.click();
		
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink()
	{
		dealsLink.click();
		
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink()
	{
		tasksLink.click();
		
		return new TasksPage();
	}
	
	public CasesPage clickOnCasesLink()
	{
		casesLink.click();
		
		return new CasesPage();
	}
	
	public CallsPage clickOnCallsLink()
	{
		callsLink.click();
		
		return new CallsPage();
	}
	
	public void clickOnNewContactLink()
	{
		Actions action=new Actions(driver);
		
		action.moveToElement(contactsLink).build().perform();
	
		newContactLink.click();
	}
	
	public void clickOnNewDealsLink()
	{
		Actions action=new Actions(driver);
		
		action.moveToElement(dealsLink).build().perform();
		newDealsLink.click();
	}
	
}
