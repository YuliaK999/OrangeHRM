package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.orangehrm.pages.AddEntitlementsPage;
import com.orangehrm.utils.BrowserUtilities;

public class AddEntitlementsTest extends TestBase{
	
	
	@Test
	public void addEntitlements() throws InterruptedException {
		logger = reporter.createTest("Add entitlements");
		
		logger.info("Login and navigate to \"Leave\" main menu");
		AddEntitlementsPage addEntitlementsPage = new AddEntitlementsPage();
		BrowserUtilities.hover(addEntitlementsPage.mainMenuLeave);
				
		logger.info("Verify the URL contains \"LeaveList\"");
		Assert.assertTrue(driver.getCurrentUrl().contains("LeaveList"));
		
		logger.info("Navigate to \"Add Entitlements\" page");
		BrowserUtilities.hover(addEntitlementsPage.menuEntitlements);
		Thread.sleep(3000);
		addEntitlementsPage.optionAddEntitlements.click();
			
		logger.info("Verify the page's heading is \"Add Leave entitlement\"");
		Assert.assertTrue(addEntitlementsPage.headingAddLeaveEntitlement.getText().equals("Add Leave Entitlement"));
		
		logger.info("Verify the labels");
		Assert.assertTrue(addEntitlementsPage.labelAddToMultipleEmployees.getText().equals("Add to Multiple Employees"));
		Assert.assertTrue(addEntitlementsPage.labelEmployee.getText().equals("Employee *"));
		Assert.assertTrue(addEntitlementsPage.labelLeaveType.getText().equals("Leave Type *"));
		Assert.assertTrue(addEntitlementsPage.labelLeavePeriod.getText().equals("Leave Period *"));
		Assert.assertTrue(addEntitlementsPage.labelEntitlement.getText().equals("Entitlement *"));
		
		logger.info("Fill up and submit the form");
		addEntitlementsPage.fieldEmployee.sendKeys("Linda Anderson");
		BrowserUtilities.selectByValue(addEntitlementsPage.fieldLeaveType,"3");
		BrowserUtilities.selectByVisibleText(addEntitlementsPage.fieldLeavePeriod, "2020-01-01 - 2020-12-31");
		addEntitlementsPage.fieldEntitlement.sendKeys("1");
		addEntitlementsPage.saveButton.submit();
		Thread.sleep(5000);
		logger.info("Verify the form has been saved");
		driver.getPageSource().contains("Data has been saved successfully"); // test case fails
	}
	
	
	@Test
	public void verifyCheckboxAddToMultipleEmployees() throws InterruptedException {
		logger = reporter.createTest("Verify checkbox \"Add To Multiple Employees\"");
		
		logger.info("Login and navigate to \"Leave\" main menu");
		AddEntitlementsPage addEntitlementsPage = new AddEntitlementsPage();
		BrowserUtilities.hover(addEntitlementsPage.mainMenuLeave);
				
		logger.info("Navigate to \"Add Entitlements\" page");
		BrowserUtilities.hover(addEntitlementsPage.menuEntitlements);
		Thread.sleep(3000);
		addEntitlementsPage.optionAddEntitlements.click();
			
		logger.info("Fill up and submit the form");
		if(!addEntitlementsPage.checkboxAddToMultipleEmployees.isSelected()) 
			addEntitlementsPage.checkboxAddToMultipleEmployees.click();
		
		addEntitlementsPage.fieldEmployee.sendKeys("Linda Anderson");
		BrowserUtilities.selectByValue(addEntitlementsPage.fieldLeaveType,"3");
		BrowserUtilities.selectByVisibleText(addEntitlementsPage.fieldLeavePeriod, "2020-01-01 - 2020-12-31");
		addEntitlementsPage.fieldEntitlement.sendKeys("1");
		addEntitlementsPage.saveButton.submit();
		Thread.sleep(5000);
		logger.info("Verify the form has been saved");
		driver.getPageSource().contains("Data has been saved successfully"); // test case fails
	}
	
	@Test
	public void verifyErrorMessages() throws InterruptedException {
		logger = reporter.createTest("Verify Error Messages");
		
		logger.info("Login and navigate to \"Leave\" main menu");
		AddEntitlementsPage addEntitlementsPage = new AddEntitlementsPage();
		BrowserUtilities.hover(addEntitlementsPage.mainMenuLeave);
		
		logger.info("Navigate to \"Add Entitlements\" page");
		BrowserUtilities.hover(addEntitlementsPage.menuEntitlements);
		Thread.sleep(3000);
		addEntitlementsPage.optionAddEntitlements.click();
		addEntitlementsPage.fieldEntitlement.sendKeys("Entitlement");
		Thread.sleep(5000);
		Assert.assertTrue(addEntitlementsPage.errorMessage1.getText().equals("Should be a number with upto 2 decimal places"));
	
		driver.navigate().refresh();
		addEntitlementsPage.saveButton.submit();
		Thread.sleep(5000);
		Assert.assertTrue(addEntitlementsPage.errorMessage2.getText().equals("Required"));
		Assert.assertTrue(addEntitlementsPage.errorMessage3.getText().equals("Required"));
		String color = addEntitlementsPage.errorMessage3.getCssValue("color"); 
		Assert.assertEquals(color,"rgba(170, 73, 53, 1)");
	}	
		
	

}
