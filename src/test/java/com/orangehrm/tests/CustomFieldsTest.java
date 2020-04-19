package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.orangehrm.pages.CustomFieldsPage;
import com.orangehrm.pages.PimMenuPage;
import com.orangehrm.utils.BrowserUtilities;

public class CustomFieldsTest extends TestBase {
	
	@BeforeMethod
	public void login() {
		logger = reporter.createTest("Before Test");
		PimMenuPage pimMenu = new PimMenuPage();
		logger.info("Navigate to \"PIM menu \" page");
		pimMenu.mainMenuPIM.click();
		BrowserUtilities.waitFor(3);
	}
	
	@Test
	public void customFieldsFormVerificationTest() {
		logger = reporter.createTest("Custom Fields Form Verification");
		CustomFieldsPage cusFields = new CustomFieldsPage();
		logger.info("Navigate to \"Configuration\" menu");
		BrowserUtilities.hover(cusFields.configurationMenu);
		logger.info("Clicking to \"Custom Fields\" menu");
		cusFields.customFieldsMenu.click();
		BrowserUtilities.waitFor(2);
		logger.info("Verifying the page's heading is \"Add Custom Field\"");
		Assert.assertTrue(cusFields.addCustomFieldHeader.getText().equals("Add Custom Field"));
		logger.pass("Verified the page's heading is \"Add Custom Field\"");
	}

}
