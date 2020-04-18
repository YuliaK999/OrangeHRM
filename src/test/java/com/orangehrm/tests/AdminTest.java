package com.orangehrm.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pages.AdminPage;
import com.orangehrm.utils.BrowserUtilities;

public class AdminTest extends TestBase{
		
		
	@Test(groups= {"smoke"})
	public void verifySystemUsers() throws InterruptedException {
	logger = reporter.createTest("Verify system users");

	logger.info("Login and navigate to \"Admin\" main menu");
	AdminPage adminPage = new AdminPage();
	adminPage.mainMenuAdmin.click();

	logger.info("Verify the URL contains \"SystemUsers\"");
	Assert.assertTrue(driver.getCurrentUrl().contains("SystemUsers"));

	logger.info("Verify the page's heading is \"System Users\"");
	Assert.assertTrue(adminPage.headingSystemUsers.getText().equals("System Users"));
	logger.pass("Verified system users");
	}

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
}
