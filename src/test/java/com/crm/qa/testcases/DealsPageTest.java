package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	DealsPage dealsPage;
	
	String sheetName = "deals";
	
	public DealsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		testUtil = new TestUtil();
		loginPage=new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		dealsPage = homePage.clickOnDealsLink();
	}
	
	@Test
	public void verifyDealsPageLabelTest()
	{
		Assert.assertTrue(dealsPage.verifyDealsLabel(), "Deals Label missing on page");
	}
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider = "getCRMTestData")
	public void validateCreateNewDeal(String title, String 	company, String quantity)
	{
		homePage.clickOnHomePageLink();
		homePage.clickOnNewDealsLink();
		dealsPage.createNewDeal(title, company, quantity);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
