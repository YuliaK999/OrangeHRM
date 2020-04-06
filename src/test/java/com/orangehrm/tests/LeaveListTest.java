package com.orangehrm.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.orangehrm.pages.LeaveListPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.BrowserUtilities;


public class LeaveListTest extends TestBase {

	
	@Test
	public void verifyLeaveList() throws InterruptedException  {
		logger = reporter.createTest("Verify Leave List");
		
		LoginPage loginPage = new LoginPage();
		logger.info("Log in by entering the correct credentials");
		loginPage.positiveLogin();
		Thread.sleep(5000);
		
		LeaveListPage leaveListPage = new LeaveListPage();
		leaveListPage.menuLeaveList.click();
		
		leaveListPage.calendarFrom.click();
		leaveListPage.selectDate("Jan", 2015, 1);		
		
		leaveListPage.calendarTo.click();
		leaveListPage.selectDate("Dec", 2015, 31);		
			
		
		if(!leaveListPage.checkboxLeaveStatusAll.isSelected()) 
			leaveListPage.checkboxLeaveStatusAll.click();
		
		for (WebElement element : leaveListPage.checkboxleaveStatuses)
			Assert.assertTrue(element.isSelected());
		
		leaveListPage.fieldEmployee.sendKeys("Linda Anderson");
			
		BrowserUtilities.selectByVisibleText(leaveListPage.dropdownSubUnit,"All");
		
		if(!leaveListPage.checkboxIncludePastEmployees.isSelected()) 
			leaveListPage.checkboxIncludePastEmployees.click();
		
		leaveListPage.buttonSearch.click();
		
		Assert.assertEquals(leaveListPage.employeeName, "Linda Anderson");
		
		//Assert.assertTrue(date between dateFrom and dateTo)
		
		//Assert.assertTrue(count number of days)
		}
	
		@Test
		public void verifyLeaveSearchByStatus()  {
			logger = reporter.createTest("Verify leave search by Status");
			
			LeaveListPage leaveListPage = new LeaveListPage();
			leaveListPage.checkboxLeaveStatusAll.click();
			
			for (WebElement element : leaveListPage.checkboxleaveStatuses)
				Assert.assertFalse(element.isSelected());
												
			leaveListPage.checkboxLeaveStatusPendingApproval.click();
			
			leaveListPage.buttonSearch.click();
			
			Assert.assertEquals(leaveListPage.employeeName, "Linda Anderson");			
			Assert.assertTrue(leaveListPage.leaveStatus.getText().contains("Pending Approval"));
		}
			
			@Test
			public void verifyLeaveSearchBySubUnit()  {
				logger = reporter.createTest("Verify leave search by Sub Unit");
				
				LeaveListPage leaveListPage = new LeaveListPage();
									
				BrowserUtilities.selectByVisibleText(leaveListPage.dropdownSubUnit,"Administration");
				
				leaveListPage.buttonSearch.click();
				
				Assert.assertEquals(leaveListPage.employeeName, "Linda Anderson");
				
				BrowserUtilities.selectByVisibleText(leaveListPage.dropdownSubUnit, "IT");
				
				leaveListPage.buttonSearch.click();
				
				Assert.assertTrue(leaveListPage.messageNoRecords.getText().equals("No Records Found"));
			}
			
			@Test//(order 3)
			public void verifyResetButton()  {
				logger = reporter.createTest("Verify reset button");
				
				LeaveListPage leaveListPage = new LeaveListPage();
				leaveListPage.buttonReset.click();
				
				Assert.assertTrue(leaveListPage.calendarFrom.getText().equals("2020-01-01"));
				Assert.assertTrue(leaveListPage.calendarTo.getText().equals("2021-12-31"));
				Assert.assertTrue(leaveListPage.checkboxLeaveStatusPendingApproval.isSelected());
				Assert.assertTrue(leaveListPage.fieldEmployee.getText().isEmpty());
				Assert.assertTrue(leaveListPage.dropdownSubUnit.getText().equals("All"));
				Assert.assertFalse(leaveListPage.checkboxIncludePastEmployees.isSelected());
	
			}
}


