package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CallsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class CallsPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	CallsPage callsPage;
	
	public CallsPageTest()
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
		callsPage = homePage.clickOnCallsLink();
	}
	
	@Test
	public void verifyCallsPageLabelTest()
	{
		Assert.assertTrue(callsPage.verifyCallsLabel(), "Calls Information Label missing on page");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
