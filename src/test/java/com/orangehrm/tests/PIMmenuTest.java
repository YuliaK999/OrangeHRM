package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.orangehrm.pages.PimMenuPage;
import com.orangehrm.utils.BrowserUtilities;

public class PIMmenuTest extends TestBase {
	
	
	
	@Test
	public void verifyPIMmenuTest() throws InterruptedException {
		
		logger = reporter.createTest("Verify PIM menu");
		PimMenuPage pimMenu = new PimMenuPage();
		logger.info("Navigate to \"PIM menu \" page");
		pimMenu.mainMenuPIM.click();
		BrowserUtilities.waitFor(5);;
		logger.info("Verifying the URL contains \"leave/viewEmployeeList\"");
		Assert.assertTrue(driver.getCurrentUrl().contains("viewEmployeeList"));
		logger.pass("Verifyed the URL contains \"leave/viewEmployeeList\"");
	}
	
	
	@Test
	public void verifyPIMmenuStructureTest() throws InterruptedException {
		logger = reporter.createTest("Verification Structure of PIM menu");
		PimMenuPage pimMenu = new PimMenuPage();
		logger.info("Navigate to \"PIM menu \" page");
		pimMenu.mainMenuPIM.click();
		BrowserUtilities.waitFor(5);
		logger.info("Verifying the structure: \"Configuration, Employee List, Add Employee, Reports \"");
		Assert.assertTrue(pimMenu.menuConfiguration.getText().equals("Configuration"));
		Assert.assertTrue(pimMenu.menuEmployeeList.getText().equals("Employee List"));
		Assert.assertTrue(pimMenu.menuAddEmployee.getText().equals("Add Employee"));
		Assert.assertTrue(pimMenu.menuReports.getText().equals("Reports"));
		logger.pass("Verifyed the structure: \"Configuration, Employee List, Add Employee, Reports \"");
	}
	
	
	
	
	
}