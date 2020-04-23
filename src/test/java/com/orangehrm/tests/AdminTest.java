package com.orangehrm.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.orangehrm.pages.AdminPage;
import com.orangehrm.utils.BrowserUtilities;

public class AdminTest extends TestBase{
		
		
	@Test
	public void verifySearchForm() throws InterruptedException, IOException {
	logger = reporter.createTest("Verify search form");
	logger.info("Login and navigate to \"Admin\" main menu");
	AdminPage adminPage = new AdminPage();
	adminPage.mainMenuAdmin.click();

	Assert.assertTrue(adminPage.searchForm.isDisplayed());

	adminPage.header.click();
	logger.info("Verify the search form is hidden");
	BrowserUtilities.waitFor(2);
	Assert.assertFalse(adminPage.searchForm.isDisplayed());

	adminPage.header.click();
	logger.info("Verify the search form is not hidden");
	Assert.assertTrue(adminPage.searchForm.isDisplayed());
	}
	
	
	@Test(groups= {"smoke"})

	public void verifySystemUsers() throws InterruptedException {

	logger = reporter.createTest("Verify system users");

	 

	logger.info("Login and navigate to \"Admin\" main menu");

	AdminPage adminPage = new AdminPage();

	adminPage.mainMenuAdmin.click();

	// 2

	logger.info("Verify the URL contains \"SystemUsers\"");

	Assert.assertTrue(driver.getCurrentUrl().contains("SystemUsers"));

	 

	logger.info("Verify the page's heading is \"System Users\"");

	System.out.println(adminPage.headingSystemUsers.getText());

	Assert.assertTrue(adminPage.headingSystemUsers.getText().equals("System Users"));

	 

	logger.info("Verify the labels");

	// 3

	logger.info("Verify the URL contains \"SystemUsers\"");

	adminPage.UserName.sendKeys("fiona.grace");

	Thread.sleep(1000);

	 

	adminPage.UserType.click();

	Thread.sleep(1000);

	adminPage.NameUserRole.click();

	Thread.sleep(1000);

	 

	logger.info("Verify the URL contains \"SystemUsers\"");

	adminPage.EmployeeName.sendKeys("Fiona Grace");

	Thread.sleep(1000);

	 

	logger.info("Verify the URL contains \"SystemUsers\"");

	adminPage.SystemStatusUser.sendKeys("Enabled");

	Thread.sleep(1000);

	 

	adminPage.SystemStatusUser.click();

	Thread.sleep(1000);

	adminPage.SystemStatusOption.click();

	 

	adminPage.BtnSearch.click();

	Thread.sleep(3000);

	//assert.assertEquals(actual, expected);
	//assert.assertEquals(actual, expected);

	adminPage.SelectRecord.click();

	Thread.sleep(1000);

	adminPage.ButtonDelete.click();

	Thread.sleep(1000);

	  adminPage.DiaButtonDelete.click();

	Thread.sleep(1000);

	 

	}

	 

	@Test

	public void verifySystemUsersDelete() throws InterruptedException {

	logger = reporter.createTest("Verify system users");

	 

	logger.info("Login and navigate to \"Admin\" main menu");

	AdminPage adminPage = new AdminPage();

	adminPage.mainMenuAdmin.click();

	// 2

	logger.info("Verify the URL contains \"SystemUsers\"");

	Assert.assertTrue(driver.getCurrentUrl().contains("SystemUsers"));

	 

	logger.info("Verify the page's heading is \"System Users\"");

	System.out.println(adminPage.headingSystemUsers.getText());

	Assert.assertTrue(adminPage.headingSystemUsers.getText().equals("System Users"));

	 

	logger.info("Verify the labels");

	// 3

	logger.info("Verify the URL contains \"SystemUsers\"");

	adminPage.UserName.sendKeys("jasmine.morgan");

	Thread.sleep(1000);

	 

	adminPage.UserType.click();

	Thread.sleep(1000);

	adminPage.NameUserRole.click();

	Thread.sleep(1000);

	 

	logger.info("Verify the URL contains \"SystemUsers\"");

	adminPage.EmployeeName.sendKeys("Jasmine Morgan");

	Thread.sleep(1000);

	 

	logger.info("Verify the URL contains \"SystemUsers\"");

	adminPage.SystemStatusUser.sendKeys("Enabled");

	Thread.sleep(1000);

	 

	adminPage.SystemStatusUser.click();

	Thread.sleep(1000);

	adminPage.SystemStatusOption.click();

	 

	adminPage.BtnSearch.click();

	Thread.sleep(3000);

	 

	 

	 

	logger.info("Verify Username Deleted");

	// Assert.assertTrue(AdminPage.verifySystemUsers.getText().equals("Successfully remotely"));

	 Assert.assertTrue(adminPage.noRecordsFoundText.getText().equals("No Records Found"));
	}
	
}
