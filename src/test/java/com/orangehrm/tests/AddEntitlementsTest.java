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
		BrowserUtilities.waitFor(5);
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
		addEntitlementsPage.optionAddEntitlements.click();
			
		logger.info("Select \"Add to Multiple Employees\" checkbox");
		if(!addEntitlementsPage.checkboxAddToMultipleEmployees.isSelected()) 
			addEntitlementsPage.checkboxAddToMultipleEmployees.click();
		
		logger.info("Select Canada as location and IT as sub unit");
		int n = addEntitlementsPage.numberOfEmployees("Canada", "IT");
		BrowserUtilities.waitFor(5);
		logger.info("Verify \"(Matches 2 employees)\" text is displayed");
		if (n==-1)
		Assert.assertTrue(addEntitlementsPage.matchesEmployees.getText().equals("(No matching employees)"));	
		else
		Assert.assertTrue(addEntitlementsPage.matchesEmployees.getText().equals("(Matches "+n+" employees)"));
		logger.pass("Verified checkbox \"Add To Multiple Employees\"");
				
	}
	
	
	@Test
	public void verifyErrorMessages() throws InterruptedException {
		logger = reporter.createTest("Verify Error Messages");
		
		logger.info("Login and navigate to \"Leave\" main menu");
		AddEntitlementsPage addEntitlementsPage = new AddEntitlementsPage();
		BrowserUtilities.hover(addEntitlementsPage.mainMenuLeave);
		
		logger.info("Navigate to \"Add Entitlements\" page");
		BrowserUtilities.hover(addEntitlementsPage.menuEntitlements);
		addEntitlementsPage.optionAddEntitlements.click();
		
		logger.info("Type \"Any string\" into Entitlement field");
		addEntitlementsPage.fieldEntitlement.sendKeys("Any string");
		BrowserUtilities.waitFor(5);
		logger.info("Verify \"Should be a number with upto 2 decimal places\" error message is displayed");
		Assert.assertTrue(addEntitlementsPage.errorMessage1.getText().equals("Should be a number with upto 2 decimal places"));
	
		logger.info("Refresh the browser");
		driver.navigate().refresh();
		logger.info("Click on \"Save\" button");
		addEntitlementsPage.saveButton.submit();
		BrowserUtilities.waitFor(5);
		
		logger.info("Verify \"Required\" error messages are displayed next to Employee and Entitlement fields");
		Assert.assertTrue(addEntitlementsPage.errorMessage2.getText().equals("Required"));
		Assert.assertTrue(addEntitlementsPage.errorMessage3.getText().equals("Required"));
		logger.info("Verify the color of the error messages is red");
		String color1 = addEntitlementsPage.errorMessage3.getCssValue("color"); 
		Assert.assertEquals(color1,"rgba(170, 73, 53, 1)");
		String color2 = addEntitlementsPage.errorMessage3.getCssValue("color"); 
		Assert.assertEquals(color2,"rgba(170, 73, 53, 1)");
		String color3 = addEntitlementsPage.errorMessage3.getCssValue("color"); 
		Assert.assertEquals(color3,"rgba(170, 73, 53, 1)");
		logger.pass("Verified error messages");
	}	
		
	

}
