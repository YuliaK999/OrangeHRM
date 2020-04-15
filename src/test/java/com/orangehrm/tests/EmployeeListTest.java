package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.pages.AddEmployeePage;
import com.orangehrm.pages.EmployeeListPage;
import com.orangehrm.pages.PimMenuPage;
import com.orangehrm.utils.BrowserUtilities;

public class EmployeeListTest extends TestBase{
	
	@BeforeMethod
	public void login() throws InterruptedException {
		logger = reporter.createTest("Before Test");
		PimMenuPage pimMenu = new PimMenuPage();
		logger.info("Navigate to \"PIM menu \" page");
		pimMenu.mainMenuPIM.click();
		Thread.sleep(3000);
	}
	
	@Test
	public void employeeListFormVerificationTest() throws InterruptedException {
		logger = reporter.createTest("Employee List Form Verification");
		EmployeeListPage empList = new EmployeeListPage();
		logger.info("Verifying the page's heading is \"Employee Information\"");
		Assert.assertTrue(empList.headingEmployeeInformation.getText().equals("Employee Information"));
		logger.pass("Verifyed the page's heading is \"Employee Information\"");
	}
	
	@Test
	public void verifyEmployeeInformationFormLabelsTest() throws InterruptedException {
		logger = reporter.createTest("Verify Employee Information Form Labels");
		EmployeeListPage empList = new EmployeeListPage();
		logger.info("Verifying the labels: \"Employee Name, ID, Employment Status, Include, Supervisor Name, Job Title, Sub Unit \"");
		Assert.assertTrue(empList.labelEmployeeName.getText().equals("Employee Name"));
		Assert.assertTrue(empList.labelID.getText().equals("Id"));
		Assert.assertTrue(empList.labelEmploymentStatus.getText().equals("Employment Status"));
		Assert.assertTrue(empList.labelInclude.getText().equals("Include"));
		Assert.assertTrue(empList.labelSupervisorName.getText().equals("Supervisor Name"));
		Assert.assertTrue(empList.labelJobTitle.getText().equals("Job Title"));
		Assert.assertTrue(empList.labelSubUnit.getText().equals("Sub Unit"));
		logger.pass("Verifyed the labels: \"Employee Name, ID, Employment Status, Include, Supervisor Name, Job Title, Sub Unit \"");
	}
	
	@Test
	public void searchByEmpNameAndIdTest() throws InterruptedException {
		logger = reporter.createTest("Verify Employee Information search by Employee Name and Id");
		EmployeeListPage empList = new EmployeeListPage();
		logger.info("Entering employee name \"Linda Anderson\" to \"Employee Name\" field");
		empList.employeeNameField.sendKeys("Linda Anderson");
		logger.info("Entering Id \"0001\" to \"ID\" field");
		empList.iDField.sendKeys("0001");
		logger.info("Click the search button");
		empList.searchButton.click();
		BrowserUtilities.waitFor(3);
		logger.info("Verifing that result table has 0001 and Linda Anderson ");
		Assert.assertTrue(empList.resultId.getText().contains("0001"));
		Assert.assertTrue(empList.resultFirstName.getText().contains("Linda"));
		Assert.assertTrue(empList.resultLastName.getText().contains("Anderson"));
		logger.pass("Verifyed Employee Information search by Employee Name and Id");
	}
	
	@Test
	public void employeeListAddButtonTest() throws InterruptedException {
		logger = reporter.createTest("Employee List \"Add\" button functionality ");
		EmployeeListPage empList = new EmployeeListPage();
		logger.info("Clicking \"Add Button\"");
		empList.addButton.click();
		BrowserUtilities.waitFor(2);
		logger.info("Verifying that clicking \"Add\" button opens the \"Add Employee\" page");
		AddEmployeePage addEmp = new AddEmployeePage();
		Assert.assertTrue(addEmp.headingAddEmployee.getText().equals("Add Employee"));
		logger.pass("Verifyed that clicking \"Add\" button opens the \"Add Employee\" page");
	}
	
	@Test
	public void employeeListResetButtonTest() throws InterruptedException {
		logger = reporter.createTest("Employee List \"Reset\" button functionality ");
		EmployeeListPage empList = new EmployeeListPage();
		logger.info("Select \"Full-Time Permanent\" option on \"Employment Status\" field");
		BrowserUtilities.selectByVisibleText(empList.employmentStatusField, "Full-Time Permanent");
		BrowserUtilities.waitFor(1);
		logger.info("Select \"Finance Manager\" option on \"Employment Status\" field");
		BrowserUtilities.selectByVisibleText(empList.jobTitleField, "Finance Manager");
		BrowserUtilities.waitFor(1);
		logger.info("Select \"Administration\" option on \"Employment Status\" field");
		BrowserUtilities.selectByVisibleText(empList.subUnitField, "Administration");
		BrowserUtilities.waitFor(1);
		logger.info("Clicking \"Reset\"");
		empList.resetButton.click();
		BrowserUtilities.waitFor(2);
		logger.info("Verifying that clicking \"Reset\" button resets selected options on the fields to default \"All\" option");
		Assert.assertEquals(empList.selectedAll.getText(), "All");
		logger.pass("Verifyed that clicking \"Reset\" button resets selected options on the fields to default \"All\" option");
	}
	
	
	


}
