package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.orangehrm.pages.EmployeeEntitlementsPage;
import com.orangehrm.utils.BrowserUtilities;

public class EmployeeEntitlementsTest extends TestBase {
	
	@Test(enabled=false)
	public void verifyEmployeeEntitlements() throws InterruptedException {
		logger = reporter.createTest("Verify Employee Entitlements");
		
		logger.info("Login and navigate to \"Leave\" main menu");
		EmployeeEntitlementsPage employeeEntitlementsPage = new EmployeeEntitlementsPage();
		BrowserUtilities.hover(employeeEntitlementsPage.mainMenuLeave);
		
		logger.info("Navigate to \"Employee Entitlements\" page");
		BrowserUtilities.hover(employeeEntitlementsPage.menuEntitlements);
		Thread.sleep(3000);
		logger.info("Navigate to \"Employee Entitlements\" page");
		employeeEntitlementsPage.optionEmployeeEntitlements.click();
		
		
		logger.info("Verify the page's heading is \"Leave Entitlements\"");
		Assert.assertTrue(employeeEntitlementsPage.headingLeaveEntitlements.getText().equals("Leave Entitlements"));
		
		employeeEntitlementsPage.fieldEmployee.sendKeys("Linda Anderson");
		BrowserUtilities.selectByVisibleText(employeeEntitlementsPage.dropdownLeaveType,"Vacation US");
		BrowserUtilities.selectByValue(employeeEntitlementsPage.dropdownLeavePeriod, "2015-01-01$$2015-12-31");
		employeeEntitlementsPage.buttonSearch.click();
		
		//Assert.
	}	
	
	@Test(enabled=false)
	public void verifyErrorMessage() throws InterruptedException {
		logger = reporter.createTest("Verify error message");
		
		logger.info("Login and navigate to \"Leave\" main menu");
		EmployeeEntitlementsPage employeeEntitlementsPage = new EmployeeEntitlementsPage();
		BrowserUtilities.hover(employeeEntitlementsPage.mainMenuLeave);
		
		logger.info("Navigate to \"Employee Entitlements\" page");
		BrowserUtilities.hover(employeeEntitlementsPage.menuEntitlements);
		Thread.sleep(3000);
		logger.info("Navigate to \"Employee Entitlements\" page");
		employeeEntitlementsPage.optionEmployeeEntitlements.click();
		employeeEntitlementsPage.buttonSearch.click();
		
		Assert.assertTrue(employeeEntitlementsPage.messageRequired.getText().equals("Required"));
	}

}
