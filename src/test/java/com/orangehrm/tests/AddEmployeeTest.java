package com.orangehrm.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.orangehrm.pages.AddEmployeePage;
import com.orangehrm.pages.PimMenuPage;
import com.orangehrm.utils.BrowserUtilities;

public class AddEmployeeTest extends TestBase {

	@BeforeMethod
	public void login(){
		logger = reporter.createTest("Before Test");
		PimMenuPage pimMenu = new PimMenuPage();
		logger.info("Navigate to \"PIM menu \" page");
		pimMenu.mainMenuPIM.click();
		BrowserUtilities.waitFor(3);
	}
	
	@Test (dataProvider="employeeInfo",dataProviderClass=DataproviderClass.class)
	 public void addEmployeeFunctionalityTest (String firstName, String lastName, String userName, String password, String repassword) throws IOException {
	  logger = reporter.createTest("Verify \"Add Employee\" function");
	  AddEmployeePage addEmp = new AddEmployeePage();
	  logger.info("Navigate to \"Add Employee\" page");
	  addEmp.mainAddEmployee.click();
	  BrowserUtilities.waitFor(3);
	  logger.info("Entering Firs Name \"Ali\" to \"First Name\" field");
	  addEmp.firstNameField.sendKeys(firstName);
	  logger.info("Entering Last Name \"Khan\" to \"Last Name\" field");
	  addEmp.lastNameField.sendKeys(lastName);
	  logger.info("Upload the picture of Employee");
	  String path = System.getProperty("user.dir") + "\\employeePhoto.jpg";
	  addEmp.uploadButton.sendKeys(path);
	  logger.info("Check the \"Create Login Details\" checkbox");
	  addEmp.checkbox.click();
	  BrowserUtilities.waitFor(3);;
	  logger.info("Entering username \"Alikhan\" to \"User Name\" field");
	  addEmp.userNameField.sendKeys(userName);
	  logger.info("Entering password \"alikhan123\" to \"Password\" field");
	  addEmp.passwordField.sendKeys(password);
	  logger.info("ReEntering password \"alikhan123\" to \"Confirm Password\" field");
	  addEmp.confirmPasswordField.sendKeys(repassword);
	  BrowserUtilities.selectByVisibleText(addEmp.selectStatus, "Disabled");
	  logger.info("Click to \"Save\" button");
	  addEmp.saveButton.click();
	  logger.fail("Add Employee function is failed because website on DEMO version");
	}
	  
	@Test
	public void addEmployeeFormVerificationTest() throws InterruptedException {
		logger = reporter.createTest("Add Employee Form Verification");
		AddEmployeePage addEmp = new AddEmployeePage();
		logger.info("Navigate to \"Add Employee\" page");
		addEmp.mainAddEmployee.click();
		BrowserUtilities.waitFor(5);
		logger.info("Verifying the page's heading is \"Add Employee\"");
		Assert.assertTrue(addEmp.headingAddEmployee.getText().equals("Add Employee"));
		logger.pass("Verified the page's heading is \"Add Employee\"");
	}

	@Test
	public void verifyAddEmpFormLabelsTest() {
		logger = reporter.createTest("Verify Add Employee Labels");
		AddEmployeePage addEmp = new AddEmployeePage();
		logger.info("Navigate to \"Add Employee\" page");
		addEmp.mainAddEmployee.click();
		BrowserUtilities.waitFor(5);
		logger.info("Verifying the labels: \"Full Name, Employee ID, Photograph, Create Login Details \"");
		Assert.assertTrue(addEmp.labelFullName.getText().equals("Full Name"));
		Assert.assertTrue(addEmp.labelEmployeeID.getText().equals("Employee Id"));
		Assert.assertTrue(addEmp.labelPhotograph.getText().equals("Photograph"));
		Assert.assertTrue(addEmp.labelCreateLoginDetails.getText().equals("Create Login Details"));
		logger.pass("Verified the labels: \"Full Name, Employee ID, Photograph, Create Login Details \"");
	}

	@Test
	public void verifyingChosenFileTest() throws IOException {
		logger = reporter.createTest("Verify Chosen File");
		AddEmployeePage addEmp = new AddEmployeePage();
		logger.info("Navigate to \"Add Employee\" page");
		addEmp.mainAddEmployee.click();
		BrowserUtilities.waitFor(5);
		logger.info("Upload the picture of Employee");
		String path = System.getProperty("user.dir") + "\\employeePhoto.jpg";
		addEmp.uploadButton.sendKeys(path);
		logger.info("Taking screenshot");
		BrowserUtilities.takeScreenshot("ChosenFileTest");
		logger.pass("Screenshot verified chosen file");

	}

	@Test
	public void verifyAddEmployeeFormErrorMessagesTest() {
		logger = reporter.createTest("Verify Add Employee Form Error Messages");
		AddEmployeePage addEmp = new AddEmployeePage();
		logger.info("Navigate to \"Add Employee\" page");
		addEmp.mainAddEmployee.click();
		BrowserUtilities.waitFor(5);
		logger.info("Click to \"Save\" button");
		addEmp.saveButton.click();
		logger.info("Verifying \"Required\" error messages are displaying under First Name and Last Name fields");
		Assert.assertEquals(addEmp.firstNameErrorMessage.getText(),"Required");
		Assert.assertEquals(addEmp.lastNameErrorMessage.getText(),"Required");
		logger.pass("Verified \"Required\" error messages are displayed under First Name and Last Name fields");
		
		logger.info("Verifying the color of error message is red");
		String color = addEmp.firstNameErrorMessage.getCssValue("color");
		Assert.assertEquals(color, "rgba(170, 73, 53, 1)");
		logger.pass("Verified \"Password\" Field Error Message");
	}
	
	@Test
	public void verifyCreateLoginDetailsFormLebelsTest() {
		logger = reporter.createTest("Verify Create Login Details Labels");
		AddEmployeePage addEmp = new AddEmployeePage();
		logger.info("Navigate to \"Add Employee\" page");
		addEmp.mainAddEmployee.click();
		BrowserUtilities.waitFor(3);
		logger.info("Check the \"Create Login Details\" checkbox");
		addEmp.checkbox.click();
		BrowserUtilities.waitFor(5);
		logger.info("Verifying the labels: \"User Name *, Password, Confirm Password, Status *\"");
		Assert.assertTrue(addEmp.labelUserName.getText().equals("User Name *"));
		Assert.assertTrue(addEmp.labelPassword.getText().contains("Password"));
		Assert.assertTrue(addEmp.labelConfirmPassword.getText().contains("Confirm Password"));
		Assert.assertTrue(addEmp.labelStatus.getText().equals("Status *"));
		logger.pass("Verified the labels: \"User Name *, Password, Confirm Password, Status *\"");
	}
	
	@Test
	public void verifyCreateLoginDetailsFormErrorMessagesTest() {
		logger = reporter.createTest("Verify \"Create Login Details\" Form error Messages");
		AddEmployeePage addEmp = new AddEmployeePage();
		logger.info("Navigate to \"Add Employee\" page");
		addEmp.mainAddEmployee.click();
		BrowserUtilities.waitFor(3);
		logger.info("Check the \"Create Login Details\" checkbox");
		addEmp.checkbox.click();
		
		logger.info("Entering four char long username \"user\" to \"User Name\" field");
		addEmp.userNameField.sendKeys("user");
		logger.info("Entering four char long password \"user\" to \"Password\" field");
		addEmp.passwordField.sendKeys("user");
		logger.info("Entering does not match password \"us\" to \"Confirm Password\" field");
		addEmp.confirmPasswordField.sendKeys("us");
		BrowserUtilities.waitFor(5);
		BrowserUtilities.selectByVisibleText(addEmp.selectStatus, "Disabled");
		
		logger.info("Verifying \"User Name\" Field Error Message");
		Assert.assertTrue(addEmp.userNameReqText.getText().contains("at least 5"));
		logger.pass("Verified \"User Name\" Field Error Message");
		
		logger.info("Verifying \"Password\" Field Error Message");
		Assert.assertTrue(addEmp.passwordReqText.getText().contains("at least 8"));
		logger.pass("Verified \"Password\" Field Error Message");
		
		logger.info("Verifying \"Confirm Password\" Field Error Message");
		Assert.assertEquals(addEmp.confirmPasswordReqText.getText(), "Passwords do not match");
		logger.pass("Verified \"Confirm Password\" Field Error Message");
		
		logger.info("Verifying the color of error message is red");
		String color = addEmp.userNameReqText.getCssValue("color");
		Assert.assertEquals(color, "rgba(170, 73, 53, 1)");
		logger.pass("Verified the color of error message is red");
	}
	
	
	

}
