package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage=new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabelTest()
	{
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts Label missing on page");
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest()
	{
		contactsPage.selectContactsByName("Preet Kaur");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest()
	{
		contactsPage.selectContactsByName("Lucky Kaur");
		contactsPage.selectContactsByName("Ronak Singh");
	}
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=4, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String title, String firstname, String lastname, String mobileno, String emailid)
	{
		//driver.findElement(By.xpath("//a[contains(text(), 'Home')]")).click();
		homePage.clickOnHomePageLink();
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "Lakhu", "Singh", "9503000012", "lakhusingh@gmail.com");
		contactsPage.createNewContact(title, firstname, lastname, mobileno, emailid);
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
