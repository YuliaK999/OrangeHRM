package com.orangehrm.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.orangehrm.pages.OptionalFieldsPage;
import com.orangehrm.pages.PimMenuPage;
import com.orangehrm.utils.BrowserUtilities;

public class OptionalFieldsTest extends TestBase {
	
	
	
	@BeforeMethod
	public void login() {
		logger = reporter.createTest("Before Test");
		PimMenuPage pimMenu = new PimMenuPage();
		logger.info("Navigate to \"PIM menu \" page");
		pimMenu.mainMenuPIM.click();
		BrowserUtilities.waitFor(3);
	}
	
	@Test
	public void configurePIMFormVerificationTest() {
		logger = reporter.createTest("Configure PIM Form Verification");
		OptionalFieldsPage optFields = new OptionalFieldsPage();
		logger.info("Navigate to \"Configuration\" menu");
		BrowserUtilities.hover(optFields.configurationMenu);
		logger.info("Clicking to \"Optional Fields\" menu");
		optFields.optionalFieldsMenu.click();
		BrowserUtilities.waitFor(2);
		logger.info("Verifying the page's heading is \"Configure PIM\"");
		Assert.assertTrue(optFields.configurePIMHeader.getText().equals("Configure PIM"));
		logger.pass("Verified the page's heading is \"Configure PIM\"");
	}
	
	@Test
	public void optionalFieldsMenuFunctionalityTest() throws IOException {
		logger = reporter.createTest("Configure PIM Functionality Verification Test");
		OptionalFieldsPage optFields = new OptionalFieldsPage();
		logger.info("Navigate to \"Configuration\" menu");
		BrowserUtilities.hover(optFields.configurationMenu);
		logger.info("Clicking to \"Optional Fields\" menu");
		optFields.optionalFieldsMenu.click();
		BrowserUtilities.waitFor(2);
		logger.info("Clicking to \"Edit\" button");
		optFields.editButton.click();
		logger.info("Checking all optional fields checkboxes");
		List<WebElement> checkboxes = optFields.checkboxes;
		for (WebElement webElement : checkboxes) {
			if (!webElement.isSelected()) {
				webElement.click();
			}
		}
		logger.info("Clicking to \"Save\" button");
		optFields.saveButton.click();
		BrowserUtilities.takeScreenshot("OptionalFields Successfully saved");
		
	}
	
	

}
