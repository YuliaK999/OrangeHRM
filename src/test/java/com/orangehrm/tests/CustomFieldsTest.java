package com.orangehrm.tests;

import java.io.IOException;
import java.util.List;
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
	
	@Test (dataProvider="addCustomFields",dataProviderClass=DataproviderClass.class)
	public void customFieldsFunctionalityTest(String field1, String field2, String field3, String field4, String field5 ) throws InterruptedException, IOException {
		logger = reporter.createTest("Custom Fields Functionality Verification");
		CustomFieldsPage cusFields = new CustomFieldsPage();
		logger.info("Navigate to \"Configuration\" menu");
		BrowserUtilities.hover(cusFields.configurationMenu);
		logger.info("Clicking to \"Custom Fields\" menu");
		cusFields.customFieldsMenu.click();
		BrowserUtilities.waitFor(2);
		String[] inputfields = {field1,field2,field3,field4,field5};
		for (String field : inputfields) {
			if(cusFields.addButton.isDisplayed()) {
				logger.info("Clicking to \"Add\" button");
				cusFields.addButton.click();
				logger.info("Entering custom " + field + " field to \"Field Name*\" field");
				cusFields.fieldNameField.sendKeys(field);
				logger.info("Select screen");
				BrowserUtilities.selectByVisibleText(cusFields.screenSelectField, "Personal Details");
				logger.info("Select type");
				BrowserUtilities.selectByValue(cusFields.typeSelectField, "0");
				logger.info("Clicking to \"Save\" button");
				cusFields.saveButton.click();
				BrowserUtilities.waitFor(2);
				logger.info("Verifying custom " + field + " field added to the table");
				List<String> addedCustomFieldNames = BrowserUtilities.getElementsText(cusFields.addedCustomFieldNames);
				Assert.assertTrue(addedCustomFieldNames.contains(field));
				logger.pass("Verifying custom " + field + " field added to the table");
			}else {
				logger.info("Entering custom " + field + " field to \"Field Name*\" field");
			cusFields.fieldNameField.sendKeys(field);
			logger.info("Select screen");
			BrowserUtilities.selectByVisibleText(cusFields.screenSelectField, "Personal Details");
			logger.info("Select type");
			BrowserUtilities.selectByValue(cusFields.typeSelectField, "0");
			logger.info("Clicking to \"Save\" button");
			cusFields.saveButton.click();
			BrowserUtilities.waitFor(2);
			logger.info("Verifying custom " + field + " field added to the table");
			List<String> addedCustomFieldNames = BrowserUtilities.getElementsText(cusFields.addedCustomFieldNames);
			Assert.assertTrue(addedCustomFieldNames.contains(field));
			logger.pass("Verifyed custom " + field + " field added to the table");
			}
		}
		BrowserUtilities.waitFor(2);
		int totalFields = cusFields.addedCustomFieldNames.size();
		String remainField = cusFields.numOfRemainFields.getText();
		int remainFields = Integer.parseInt(remainField.substring(remainField.length()-1));
		logger.info("Verifying that total of 10 custom fields are able to be added to the table");
		Assert.assertEquals(totalFields+remainFields, 10);
		logger.pass("Verifyed that total of 10 custom fields are able to be added to the table");
		logger.info("Check main checkbox to delete all custom fields from the table");		
		cusFields.checkAll.click();
		logger.info("Clicking to \"Delete\" button");
		cusFields.deleteButton.click();
		BrowserUtilities.waitFor(2);
		logger.info("Clicking to \"OK\" button on \"OrangeHRM - Confirmation Required\" window");
		cusFields.alertOKButton.click();
		BrowserUtilities.waitFor(2);
		logger.info("Verifying the page's heading is \"Add Custom Field\"");
		Assert.assertTrue(cusFields.addCustomFieldHeader.getText().equals("Add Custom Field"));
		logger.pass("Verified the page's heading is \"Add Custom Field\" and all added custom fields successfully deleted");
	}
	


}
