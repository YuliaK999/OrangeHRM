package com.orangehrm.tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pages.AddEntitlementsPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.BrowserUtilities;

public class AddEntitlementsTest extends TestBase{
	
	@Test
	public void addEntitlements() throws InterruptedException {
		logger = reporter.createTest("Add entitlements");
		
		AddEntitlementsPage addEntitlementsPage = new AddEntitlementsPage();
		addEntitlementsPage.mainMenuLeave.click();
		
		logger.info("Verify the URL contains \"leave/viewLeaveList\"");
		System.out.print(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("leave/viewLeaveList"));
		
		logger.info("Navigate to \"Add Entitlements\" page");
		BrowserUtilities.hover(addEntitlementsPage.menuEntitlements);
		addEntitlementsPage.optionAddEntitlements.click();
		
		
		logger.info("Verify the page's heading is \"Add Leave Entitlement\"");
		Assert.assertTrue(addEntitlementsPage.headingAddLeaveEntitlement.getText().equals("Add Leave Entitlement"));
		
		logger.info("Verify the labels: \"Employee *, Leave Type *, Leave Period *, Entitlement * \"");
		Assert.assertTrue(addEntitlementsPage.labelEmployee.getText().equals("Employee *"));
		Assert.assertTrue(addEntitlementsPage.labelLeaveType.getText().equals("Leave Type *"));
		Assert.assertTrue(addEntitlementsPage.labelLeavePeriod.getText().equals("Leave Period *"));
		Assert.assertTrue(addEntitlementsPage.labelEntitlement.getText().equals("Entitlement *"));
		
		logger.info("Fill up and submit \"Add Leave Entitlement\" form");
		addEntitlementsPage.fieldEmployee.sendKeys("Linda Anderson");
		BrowserUtilities.selectByValue(addEntitlementsPage.fieldLeaveType,"3");
		BrowserUtilities.selectByVisibleText(addEntitlementsPage.fieldLeavePeriod, "2020-01-01 - 2020-12-31");
		addEntitlementsPage.fieldEntitlement.sendKeys("1");
		addEntitlementsPage.saveButton.submit();
		
		logger.info("Verify the form has been saved");
		
	}
	
	@Test
	public void verifyErrorMessages() {
		logger = reporter.createTest("Verify Error Messages");
		
		driver.navigate().refresh();
		AddEntitlementsPage addEntitlementsPage = new AddEntitlementsPage();
		addEntitlementsPage.fieldEntitlement.sendKeys("Entitlement");
		Assert.assertTrue(addEntitlementsPage.errorMessage1.getText().equals("Should be a number with upto 2 decimal places"));
	
		driver.navigate().refresh();
		addEntitlementsPage.saveButton.submit();
		Assert.assertTrue(addEntitlementsPage.errorMessage2.getText().equals("Required"));
		Assert.assertTrue(addEntitlementsPage.errorMessage3.getText().equals("Required"));
		String color = addEntitlementsPage.errorMessage3.getCssValue("color"); 
		Assert.assertEquals(color,"#aa4935");
	}	
		
	

}
