package com.orangehrm.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import com.orangehrm.pages.LeaveListPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.BrowserUtilities;


public class LeaveListTest extends TestBase {

	
	@Test
	public void verifyLeaveList() throws InterruptedException  {
		logger = reporter.createTest("Verify Leave List");
		
		logger.info("Login and navigate to \"Leave\" main menu");
		LeaveListPage leaveListPage = new LeaveListPage();
		BrowserUtilities.hover(leaveListPage.mainMenuLeave);
		Thread.sleep(3000);
		logger.info("Navigate to \"Leave Lists\" page");
		leaveListPage.menuLeaveList.click();
		
		leaveListPage.calendarFrom.click();
		leaveListPage.selectDate("Jan", 2015, 1);		
		
		leaveListPage.calendarTo.click();
		leaveListPage.selectDate("Dec", 2015, 31);		
				
		if(!leaveListPage.checkboxLeaveStatusAll.isSelected()) 
			leaveListPage.checkboxLeaveStatusAll.click();
		
		for (WebElement element : leaveListPage.checkboxleaveStatuses)
			Assert.assertTrue(element.isSelected());
		
		leaveListPage.fieldEmployee.sendKeys("Belinda Anderson");
			
		BrowserUtilities.selectByVisibleText(leaveListPage.dropdownSubUnit,"All");
		
		if(!leaveListPage.checkboxIncludePastEmployees.isSelected()) 
			leaveListPage.checkboxIncludePastEmployees.click();
		
		leaveListPage.buttonSearch.click();
		Thread.sleep(5000);
		
		Assert.assertEquals(leaveListPage.employeeName.getText(), "Belinda Anderson");
		
		//Assert.assertTrue(date between dateFrom and dateTo)
		
		//Assert.assertTrue(count number of days)
		}
	
		@Test
		
		public void verifyLeaveSearchByStatus() throws InterruptedException  {
			logger = reporter.createTest("Verify leave search by Status");
			
			logger.info("Login and navigate to \"Leave\" main menu");
			LeaveListPage leaveListPage = new LeaveListPage();
			BrowserUtilities.hover(leaveListPage.mainMenuLeave);
			Thread.sleep(3000);
			logger.info("Navigate to \"Leave Lists\" page");
			leaveListPage.menuLeaveList.click();
			
			leaveListPage.calendarFrom.click();
			leaveListPage.selectDate("Jan", 2015, 1);		
			
			leaveListPage.calendarTo.click();
			leaveListPage.selectDate("Dec", 2015, 31);
			
			leaveListPage.checkboxLeaveStatusAll.click();
			
			for (WebElement element : leaveListPage.checkboxleaveStatuses)
				Assert.assertTrue(element.isSelected());
			
			leaveListPage.checkboxLeaveStatusAll.click();
			
			for (WebElement element : leaveListPage.checkboxleaveStatuses)
				Assert.assertFalse(element.isSelected());
			
						
			leaveListPage.checkboxLeaveStatusPendingApproval.click();
			leaveListPage.fieldEmployee.sendKeys("Linda Anderson");
			leaveListPage.buttonSearch.click();
			Thread.sleep(5000);
			
			Assert.assertEquals(leaveListPage.employeeName.getText(), "Linda Anderson");			
			Assert.assertTrue(leaveListPage.leaveStatus.getText().contains("Pending Approval"));
		}
			
			@Test
			
			public void verifyLeaveSearchBySubUnit() throws InterruptedException  {
				logger = reporter.createTest("Verify leave search by Sub Unit");
				
				logger.info("Login and navigate to \"Leave\" main menu");
				LeaveListPage leaveListPage = new LeaveListPage();
				BrowserUtilities.hover(leaveListPage.mainMenuLeave);
				Thread.sleep(3000);
				logger.info("Navigate to \"Leave Lists\" page");
				leaveListPage.menuLeaveList.click();
				
				leaveListPage.calendarFrom.click();
				leaveListPage.selectDate("Jan", 2015, 1);		
				
				leaveListPage.calendarTo.click();
				leaveListPage.selectDate("Dec", 2015, 31);
				
				leaveListPage.checkboxLeaveStatusAll.click();
				leaveListPage.fieldEmployee.sendKeys("Linda Anderson");
				BrowserUtilities.selectByVisibleText(leaveListPage.dropdownSubUnit,"Administration");
				leaveListPage.buttonSearch.click();
				Thread.sleep(5000);
				Assert.assertEquals(leaveListPage.employeeName.getText(), "Linda Anderson");
				
				BrowserUtilities.selectByVisibleText(leaveListPage.dropdownSubUnit, "IT");
				leaveListPage.buttonSearch.click();
				Thread.sleep(5000);
				Assert.assertTrue(leaveListPage.messageNoRecords.getText().equals("No Records Found"));
			}
			
			@Test(dependsOnMethods = {"verifyLeaveList"})
			
			public void verifyResetButton() throws InterruptedException  {
				logger = reporter.createTest("Verify reset button");
				
				LeaveListPage leaveListPage = new LeaveListPage();
				/*logger.info("Login and navigate to \"Leave\" main menu");
				BrowserUtilities.hover(leaveListPage.mainMenuLeave);
				Thread.sleep(3000);
				logger.info("Navigate to \"Leave Lists\" page");
				leaveListPage.menuLeaveList.click();*/
				leaveListPage.buttonReset.click();
				Thread.sleep(5000);
				
				Assert.assertTrue(leaveListPage.calendarFrom.getAttribute("value").equals("2020-01-01"));
				Assert.assertTrue(leaveListPage.calendarTo.getAttribute("value").equals("2021-12-31"));
				Assert.assertTrue(leaveListPage.checkboxLeaveStatusPendingApproval.isSelected());
				Assert.assertTrue(leaveListPage.fieldEmployee.getText().isEmpty());
				Assert.assertTrue(leaveListPage.dropdownSubUnit.getAttribute("value").equals("0"));
				Assert.assertFalse(leaveListPage.checkboxIncludePastEmployees.isSelected());
	
			}
}


