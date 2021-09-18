package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase
{
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id = "first_name")
	WebElement firstName;
	
	@FindBy(id = "surname")
	WebElement lastName;
	
	@FindBy(id = "mobile")
	WebElement mobileNo;
	
	@FindBy(id = "email")
	WebElement emailId;
	
	@FindBy(xpath = "//input[@type='submit' and @value = 'Save']")
	WebElement saveBtn;
	
//	not a good approach	
//	@FindBy(xpath = "//a[contains(text(), 'Preet Kaur')]//parent::td//preceding-sibling::td//input[@name='contact_id']")
//	WebElement contactsLabel;

	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name)
	{
		driver.findElement(By.xpath("//a[contains(text(), '"+name+"')]//parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String title, String fName, String lName, String mobNo, String eMail)
	{
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		mobileNo.sendKeys(mobNo);
		emailId.sendKeys(eMail);
		saveBtn.click();
		
	}
}
