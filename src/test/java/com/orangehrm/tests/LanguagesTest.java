package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pages.AdminPage;

public class LanguagesTest extends TestBase{
	
	
	@Test
	public void verifySystemUsers() throws InterruptedException {
		logger = reporter.createTest("Verify system users");
		
		logger.info("Login and navigate to \"Admin\" main menu");
		AdminPage adminPage = new AdminPage();
		adminPage.mainMenuAdmin.click();
				
		logger.info("Verify the URL contains \"SystemUsers\"");
		Assert.assertTrue(driver.getCurrentUrl().contains("SystemUsers"));
		
		logger.info("Verify the page's heading is \"System Users\"");
		Assert.assertTrue(adminPage.headingSystemUsers.getText().equals("System Users"));
		
		logger.info("Verify the labels");

	}

}
