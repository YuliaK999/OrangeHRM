package com.orangehrm.tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pages.AddEntitlementsPage;
import com.orangehrm.pages.EmployeeEntitlementsPage;
import com.orangehrm.utils.BrowserUtilities;

public class EmployeeEntitlementsTest extends TestBase {
	
	@Test(dataProvider="keyWordSearch",dataProviderClass=DataproviderClass.class)
	
	public void verifyLeaveEntitlements(String keyword, String fullName) throws InterruptedException {
		logger = reporter.createTest("Verify Leave Entitlements");
		
		logger.info("Login and navigate to \"Leave\" main menu");
		EmployeeEntitlementsPage employeeEntitlementsPage = new EmployeeEntitlementsPage();
		BrowserUtilities.hover(employeeEntitlementsPage.mainMenuLeave);
				
		logger.info("Navigate to \"Add Entitlements\" page");
		BrowserUtilities.hover(employeeEntitlementsPage.menuEntitlements);
		employeeEntitlementsPage.optionEmployeeEntitlements.click();
			
		logger.info("Verify the page's heading is \"Add Leave entitlement\"");
		Assert.assertTrue(employeeEntitlementsPage.headingLeaveEntitlements.getText().equals("Leave Entitlements"));
	
		logger.info("Select the field according to the keyword");
		employeeEntitlementsPage.fieldName.sendKeys(keyword+ Keys.ARROW_DOWN);
		for (WebElement name : employeeEntitlementsPage.dynamicDropdownNames)
			if (name.getText().equals(fullName))
				name.click();
		BrowserUtilities.waitFor(3);	
		logger.info("Select the leave period from the dropdown");
		BrowserUtilities.selectByIndex(employeeEntitlementsPage.leavePeriodDropdown, 0);
		logger.info("Search for the results");
		employeeEntitlementsPage.buttonSearch.click();
		BrowserUtilities.waitFor(5);
		logger.info("Verify Entitlement Type is \"Added\" for all");
		for (WebElement entitlementType : employeeEntitlementsPage.resultEntitlementType)
			Assert.assertEquals(entitlementType.getText(), "Added");
		
		logger.info("Verify Leave Types are correct");
		for (WebElement leaveType : employeeEntitlementsPage.resultLeaveType)
			Assert.assertTrue(BrowserUtilities.getElementsText(employeeEntitlementsPage.leaveTypes).
								contains(leaveType.getText()));
		
		logger.info("Verify total amount of days is correct");
		int allRowsSumDays = employeeEntitlementsPage.sum(employeeEntitlementsPage.evenListDays) + 
							employeeEntitlementsPage.sum(employeeEntitlementsPage.oddListDays);
		
		Assert.assertEquals(Double.parseDouble(employeeEntitlementsPage.total.getText()), allRowsSumDays);
		logger.pass("Verified Leave Entitlements search form");
	}
}
