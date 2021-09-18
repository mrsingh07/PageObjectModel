package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CallsPage extends TestBase
{
	@FindBy(xpath = "//legend[contains(text(),'Call Information')]")
	WebElement callsLabel;
	
	public CallsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCallsLabel()
	{
		return callsLabel.isDisplayed();
	}
}
