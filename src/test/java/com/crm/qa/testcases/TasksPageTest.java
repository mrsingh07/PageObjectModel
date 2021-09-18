package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class TasksPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	TasksPage tasksPage;
	
	public TasksPageTest()
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
		tasksPage = homePage.clickOnTasksLink();
	}
	
	@Test
	public void verifyTasksPageLabelTest()
	{
		Assert.assertTrue(tasksPage.verifyTasksLabel(), "Tasks Label missing on page");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
