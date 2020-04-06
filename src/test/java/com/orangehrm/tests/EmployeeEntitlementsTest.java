package com.orangehrm.tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pages.AddEntitlementsPage;
import com.orangehrm.pages.EmployeeEntitlementsPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.BrowserUtilities;

public class EmployeeEntitlementsTest extends TestBase {
	
	@Test
	public void verifyEmployeeEntitlements() throws InterruptedException {
		logger = reporter.createTest("Verify Employee Entitlements");
		
		LoginPage loginPage = new LoginPage();
		logger.info("Log in by entering the correct credentials");
		loginPage.positiveLogin();
		Thread.sleep(5000);
		
		EmployeeEntitlementsPage employeeEntitlementsPage = new EmployeeEntitlementsPage();
		employeeEntitlementsPage.mainMenuLeave.click();
		
		logger.info("Navigate to \"Employee Entitlements\" page");
		BrowserUtilities.hover(employeeEntitlementsPage.menuEntitlements);
		employeeEntitlementsPage.optionEmployeeEntitlements.click();
		
		
		logger.info("Verify the page's heading is \"Leave Entitlements\"");
		Assert.assertTrue(employeeEntitlementsPage.headingLeaveEntitlements.getText().equals("Leave Entitlements"));
		
		employeeEntitlementsPage.fieldEmployee.sendKeys("Linda Anderson");
		BrowserUtilities.selectByVisibleText(employeeEntitlementsPage.dropdownLeaveType,"Vacation US");
		BrowserUtilities.selectByValue(employeeEntitlementsPage.dropdownLeavePeriod, "2015-01-01$$2015-12-31");
		employeeEntitlementsPage.buttonSearch.click();
		
		//Assert.
	}	

}
