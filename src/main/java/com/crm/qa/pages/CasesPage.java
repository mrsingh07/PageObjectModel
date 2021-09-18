package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CasesPage extends TestBase
{
	@FindBy(xpath = "//td[contains(text(),'Cases')]")
	WebElement casesLabel;
	
	public CasesPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCasesLabel()
	{
		return casesLabel.isDisplayed();
	}
}
