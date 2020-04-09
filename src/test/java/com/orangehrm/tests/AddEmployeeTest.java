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
	public void login() throws InterruptedException {
		logger = reporter.createTest("Before Test");
		PimMenuPage pimMenu = new PimMenuPage();
		logger.info("Navigate to \"PIM menu \" page");
		pimMenu.mainMenuPIM.click();
		Thread.sleep(3000);
	}

	@Test
	public void addEmployeeFormVerificationTest() throws InterruptedException {
		logger = reporter.createTest("Add Employee Form Verification");
		AddEmployeePage addEmp = new AddEmployeePage();
		logger.info("Navigate to \"Add Employee\" page");
		addEmp.mainAddEmployee.click();
		Thread.sleep(3000);
		logger.info("Verifying the page's heading is \"Add Employee\"");
		Assert.assertTrue(addEmp.headingAddEmployee.getText().equals("Add Employee"));
		logger.pass("Verifyed the page's heading is \"Add Employee\"");
	}

	@Test
	public void verifyAddEmpFormLabelsTest() throws InterruptedException {
		logger = reporter.createTest("Verify Add Employee Labels");
		AddEmployeePage addEmp = new AddEmployeePage();
		logger.info("Navigate to \"Add Employee\" page");
		addEmp.mainAddEmployee.click();
		Thread.sleep(3000);
		logger.info("Verifying the labels: \"Full Name, Employee ID, Photograph, Create Login Details \"");
		Assert.assertTrue(addEmp.labelFullName.getText().equals("Full Name"));
		Assert.assertTrue(addEmp.labelEmployeeID.getText().equals("Employee Id"));
		Assert.assertTrue(addEmp.labelPhotograph.getText().equals("Photograph"));
		Assert.assertTrue(addEmp.labelCreateLoginDetails.getText().equals("Create Login Details"));
		logger.pass("Verifyed the labels: \"Full Name, Employee ID, Photograph, Create Login Details \"");
	}

	@Test
	public void verifyingChosenFileTest() throws InterruptedException, IOException {
		logger = reporter.createTest("Verify Chosen File");
		AddEmployeePage addEmp = new AddEmployeePage();
		logger.info("Navigate to \"Add Employee\" page");
		addEmp.mainAddEmployee.click();
		Thread.sleep(3000);
		logger.info("Upload the picture of Employee");
		String path = System.getProperty("user.dir") + "\\employeePhoto.jpg";
		addEmp.uploadButton.sendKeys(path);
		logger.info("Taking screenshot");
		BrowserUtilities.takeScreenshot("ChosenFileTest");
		logger.pass("Screenshot verifyed chosen file");

	}

	@Test
	public void verifyAddEmployeeFormErrorMessagesTest() throws InterruptedException {
		logger = reporter.createTest("Verify Add Employee Form Error Messages");
		AddEmployeePage addEmp = new AddEmployeePage();
		logger.info("Navigate to \"Add Employee\" page");
		addEmp.mainAddEmployee.click();
		Thread.sleep(3000);
		logger.info("Click to \"Save\" button");
		addEmp.saveButton.click();
		logger.info("Verifying \"Required\" error messages are displaying under First Name and Last Name fields");
		Assert.assertEquals(addEmp.firstNameErrorMessage.getText(),"Required");
		Assert.assertEquals(addEmp.lastNameErrorMessage.getText(),"Required");
		logger.pass("Verifyed \"Required\" error messages are displayed under First Name and Last Name fields");
		
		logger.info("Verifying the color of error message is red");
		String color = addEmp.firstNameErrorMessage.getCssValue("color");
		Assert.assertEquals(color, "rgba(170, 73, 53, 1)");
		logger.pass("Verifyed \"Password\" Field Error Message");
	}
	
	@Test
	public void verifyCreateLoginDetailsFormLebelsTest() throws InterruptedException {
		logger = reporter.createTest("Verify Create Login Details Labels");
		AddEmployeePage addEmp = new AddEmployeePage();
		logger.info("Navigate to \"Add Employee\" page");
		addEmp.mainAddEmployee.click();
		Thread.sleep(3000);
		logger.info("Check the \"Create Login Details\" checkbox");
		addEmp.checkbox.click();
		Thread.sleep(3000);
		logger.info("Verifying the labels: \"User Name *, Password, Confirm Password, Status *\"");
		Assert.assertTrue(addEmp.labelUserName.getText().equals("User Name *"));
		Assert.assertTrue(addEmp.labelPassword.getText().contains("Password"));
		Assert.assertTrue(addEmp.labelConfirmPassword.getText().contains("Confirm Password"));
		Assert.assertTrue(addEmp.labelStatus.getText().equals("Status *"));
		logger.pass("Verifyed the labels: \"User Name *, Password, Confirm Password, Status *\"");
	}
	
	@Test
	public void verifyCreateLoginDetailsFormErrorMessagesTest() throws InterruptedException {
		logger = reporter.createTest("Verify \"Create Login Details\" Form error Messages");
		AddEmployeePage addEmp = new AddEmployeePage();
		logger.info("Navigate to \"Add Employee\" page");
		addEmp.mainAddEmployee.click();
		Thread.sleep(3000);
		logger.info("Check the \"Create Login Details\" checkbox");
		addEmp.checkbox.click();
		Thread.sleep(3000);
		logger.info("Entering four char long username \"user\" to \"User Name\" field");
		addEmp.userNameField.sendKeys("user");
		logger.info("Entering four char long password \"user\" to \"Password\" field");
		addEmp.passwordField.sendKeys("user");
		logger.info("Entering does not match password \"us\" to \"Confirm Password\" field");
		addEmp.confirmPasswordField.sendKeys("us");
		BrowserUtilities.selectByVisibleText(addEmp.selectStatus, "Disabled");
		
		logger.info("Verifying \"User Name\" Field Error Message");
		Assert.assertTrue(addEmp.userNameReqText.getText().contains("at least 5"));
		logger.pass("Verifyed \"User Name\" Field Error Message");
		
		logger.info("Verifying \"Password\" Field Error Message");
		Assert.assertTrue(addEmp.passwordReqText.getText().contains("at least 8"));
		logger.pass("Verifyed \"Password\" Field Error Message");
		
		logger.info("Verifying \"Confirm Password\" Field Error Message");
		Assert.assertEquals(addEmp.confirmPasswordReqText.getText(), "Passwords do not match");
		logger.pass("Verifyed \"Confirm Password\" Field Error Message");
		
		logger.info("Verifying the color of error message is red");
		String color = addEmp.userNameReqText.getCssValue("color");
		Assert.assertEquals(color, "rgba(170, 73, 53, 1)");
		logger.pass("Verifyed the color of error message is red");
	}
	
	
	

}
