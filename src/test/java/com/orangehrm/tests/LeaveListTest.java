package com.orangehrm.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.orangehrm.pages.EmployeeListPage;
import com.orangehrm.pages.LeaveListPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.BrowserUtilities;


public class LeaveListTest extends TestBase {

	
	@Test
	@Ignore
	public void verifyLeaveList() throws InterruptedException  {
		logger = reporter.createTest("Verify Leave List");
		
		logger.info("Login and navigate to \"Leave\" main menu");
		LeaveListPage leaveListPage = new LeaveListPage();
		BrowserUtilities.hover(leaveListPage.mainMenuLeave);
		logger.info("Navigate to \"Leave Lists\" page");
		leaveListPage.menuLeaveList.click();
		logger.info("Fill up leave list form");
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
		BrowserUtilities.waitFor(5);
		logger.info("Verify leave list by employee name");
		Assert.assertEquals(leaveListPage.employeeName.getText(), "Linda Anderson");
		logger.info("Verify number of days is calculated correctly");
		int number = leaveListPage.leaveLength(leaveListPage.leaveDates);
		Assert.assertEquals(number-1+"",leaveListPage.numberOfDays.getText().substring(0, 2));
		System.out.println(leaveListPage.calendarFrom.getText());
		Assert.assertTrue(leaveListPage.DatePeriodIsInside());
		logger.pass("Verified leave list");
		}
	
		
		@Test
		public void verifyResultLinks() {
			logger = reporter.createTest("Verify Result Links");
				logger.info("Login and navigate to \"Leave\" main menu");
				LeaveListPage leaveListPage = new LeaveListPage();
				BrowserUtilities.hover(leaveListPage.mainMenuLeave);
				logger.info("Navigate to \"Leave Lists\" page");
				leaveListPage.menuLeaveList.click();
				logger.info("Fill up leave list form");
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
				BrowserUtilities.waitFor(5);
				
			leaveListPage.employeeLink.click();
			//BrowserUtilities.waitFor(5);
			Assert.assertTrue(driver.getCurrentUrl().contains("viewEmployee"));
			System.out.println(new EmployeeListPage().employeeNameField.getAttribute("value"));
			driver.navigate().back();
			leaveListPage.leaveDates.click();
			Assert.assertTrue(driver.getCurrentUrl().contains("viewLeaveRequest"));	
		}
		
	
		@Test
		@Ignore
		public void verifyLeaveSearchByStatus() throws InterruptedException  {
			logger = reporter.createTest("Verify leave search by Status");
			
			logger.info("Login and navigate to \"Leave\" main menu");
			LeaveListPage leaveListPage = new LeaveListPage();
			BrowserUtilities.hover(leaveListPage.mainMenuLeave);
			logger.info("Navigate to \"Leave Lists\" page");
			leaveListPage.menuLeaveList.click();
			logger.info("Fill up leave list form");
			leaveListPage.calendarFrom.click();
			leaveListPage.selectDate("Jan", 2015, 1);		
			
			leaveListPage.calendarTo.click();
			leaveListPage.selectDate("Dec", 2015, 31);
			
			leaveListPage.checkboxLeaveStatusAll.click();
			logger.info("Verify all the statuses are selected");
			for (WebElement element : leaveListPage.checkboxleaveStatuses)
				Assert.assertTrue(element.isSelected());
			
			leaveListPage.checkboxLeaveStatusAll.click();
			logger.info("Verify all the statuses are deselected");
			for (WebElement element : leaveListPage.checkboxleaveStatuses)
				Assert.assertFalse(element.isSelected());
			
			logger.info("Select Pending Approval status");
			Thread.sleep(5000);
			leaveListPage.checkboxLeaveStatusPendingApproval.click();
			leaveListPage.fieldEmployee.sendKeys("Linda Anderson");
			leaveListPage.buttonSearch.click();
			Thread.sleep(5000);
			logger.info("Verify the employee and the status");
			Assert.assertEquals(leaveListPage.employeeName.getText(), "Linda Anderson");			
			Assert.assertTrue(leaveListPage.leaveStatus.getText().contains("Pending Approval"));
			logger.pass("Verified leave search by Status");
		}
			
			@Test
			@Ignore
			public void verifyLeaveSearchBySubUnit() throws InterruptedException  {
				logger = reporter.createTest("Verify leave search by Sub Unit");
				
				logger.info("Login and navigate to \"Leave\" main menu");
				LeaveListPage leaveListPage = new LeaveListPage();
				BrowserUtilities.hover(leaveListPage.mainMenuLeave);
				logger.info("Navigate to \"Leave Lists\" page");
				leaveListPage.menuLeaveList.click();
				logger.info("Fill up leave list form");
				leaveListPage.calendarFrom.click();
				leaveListPage.selectDate("Jan", 2015, 1);		
				
				leaveListPage.calendarTo.click();
				leaveListPage.selectDate("Dec", 2015, 31);
				
				leaveListPage.checkboxLeaveStatusAll.click();
				leaveListPage.fieldEmployee.sendKeys("Linda Anderson");
				logger.info("Select SubUnit \"Administration\"");
				BrowserUtilities.selectByVisibleText(leaveListPage.dropdownSubUnit,"Administration");
				leaveListPage.buttonSearch.click();
				BrowserUtilities.waitFor(5);
				logger.info("Verify the employee");
				Assert.assertEquals(leaveListPage.employeeName.getText(), "Linda Anderson");
				logger.info("Select SubUnit \"IT\"");
				BrowserUtilities.selectByVisibleText(leaveListPage.dropdownSubUnit, "IT");
				leaveListPage.buttonSearch.click();
				Thread.sleep(5000);
				logger.info("Verify \"No Records Found\" message is displayed");
				Assert.assertTrue(leaveListPage.messageNoRecords.getText().equals("No Records Found"));
				logger.pass("Verified leave search by subUnit");
			}
			
			@Test
			@Ignore
			public void verifyResetButton() throws InterruptedException  {
				logger = reporter.createTest("Verify reset button");
				
				LeaveListPage leaveListPage = new LeaveListPage();
				logger.info("Login and navigate to \"Leave\" main menu");
				BrowserUtilities.hover(leaveListPage.mainMenuLeave);
				logger.info("Navigate to \"Leave Lists\" page");
				leaveListPage.menuLeaveList.click();
				logger.info("Click on \"Reset\" button");
				leaveListPage.buttonReset.click();
				BrowserUtilities.waitFor(5);
				
				Assert.assertTrue(leaveListPage.calendarFrom.getAttribute("value").equals("2020-01-01"));
				Assert.assertTrue(leaveListPage.calendarTo.getAttribute("value").equals("2021-12-31"));
				Assert.assertTrue(leaveListPage.checkboxLeaveStatusPendingApproval.isSelected());
				Assert.assertTrue(leaveListPage.fieldEmployee.getText().isEmpty());
				Assert.assertTrue(leaveListPage.dropdownSubUnit.getAttribute("value").equals("0"));
				Assert.assertFalse(leaveListPage.checkboxIncludePastEmployees.isSelected());
				logger.pass("Verified reset button");
	
			}
}


