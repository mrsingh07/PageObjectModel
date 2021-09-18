package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CasesPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class CasesPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	CasesPage casesPage;
	
	public CasesPageTest()
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
		casesPage = homePage.clickOnCasesLink();
	}
	
	@Test
	public void verifyCasesPageLabelTest()
	{
		Assert.assertTrue(casesPage.verifyCasesLabel(), "Cases Label missing on page");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
