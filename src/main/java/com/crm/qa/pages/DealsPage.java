package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase
{
	@FindBy(xpath = "//td[contains(text(),'Deals')]")
	WebElement dealsLabel;
	
	@FindBy(id = "title")
	WebElement titles;
	
	@FindBy(name = "client_lookup")
	WebElement companyName;
	
	@FindBy(id = "quantity")
	WebElement quantity;
	
	@FindBy(xpath = "//input[@type='submit' and @value = 'Save']")
	WebElement saveBtn;
	
	public DealsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyDealsLabel()
	{
		return dealsLabel.isDisplayed();
	}
	
	public void createNewDeal(String title, String company, String qty)
	{
		titles.sendKeys(title);
		companyName.sendKeys(company);
		quantity.sendKeys(qty);
		saveBtn.click();
		
		
	}
}
