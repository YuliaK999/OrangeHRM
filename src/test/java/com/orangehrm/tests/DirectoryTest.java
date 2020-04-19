package com.orangehrm.tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.orangehrm.pages.DirectoryPage;
import com.orangehrm.utils.BrowserUtilities;

public class DirectoryTest extends TestBase {

	
	@Test
	public void verifyPageTitle() {
		DirectoryPage directorypage = new DirectoryPage();
		logger = reporter.createTest("Verify Page Title /Orange HRM/");
		logger.info("Land on Directory");
		directorypage.directory.click();
		Assert.assertTrue(driver.getTitle().contains("OrangeHRM"));
		logger.info("Page Title Verified");
	}

	@Test
	public void searchDirectory() {
		DirectoryPage directorypage = new DirectoryPage();
		directorypage.directory.click();
		logger = reporter.createTest("Search Employe and Verify The Correct Name");
		logger.info("Enter name:Linda Anderson");
		BrowserUtilities.waitFor(3);
		BrowserUtilities.waitFor(2);
		directorypage.directorySearchName.sendKeys("Linda Anderson");
		logger.info("Enter job title");
		BrowserUtilities.selectByValue(directorypage.directoryJobTitle, "3");
		logger.info("Enter Location");
		BrowserUtilities.selectByValue(directorypage.directoryLocation, "2");
		logger.info("Click on Search Button");
		directorypage.directorySearch.click();
		BrowserUtilities.waitFor(2);
		Assert.assertTrue(directorypage.lindaAnderson.getText().contains("Admin"));
	}

	@Test
	public void ResetDirectory() {
		DirectoryPage directorypage = new DirectoryPage();
		directorypage.directory.click();

		logger = reporter.createTest("Click on Reset Button and Verify Message");

		logger.info("Click on Reset Button");
		directorypage.directoryReset.click();

		logger.info("Verify Message");
		Assert.assertTrue(directorypage.noRecordsFind.isDisplayed());

	}

//	@Test
//	public void SearchHiddenButton() {
//		DirectoryPage directorypage = new DirectoryPage();
//		directorypage.directory.click();
//
//		directorypage.searchHiddenButton.click();
//		Assert.assertFalse(directorypage.directorySearch.isDisplayed());
//
//	}

	@Test
	public void NoRecordFound() {
		DirectoryPage directorypage = new DirectoryPage();
		directorypage.directory.click();
		logger = reporter.createTest("Verify No Record Found After Negative Search");

		logger.info("Click All on Search Name");
		directorypage.directorySearchName.sendKeys("Greg" + Keys.ENTER);

		BrowserUtilities.waitFor(2);

		logger.info("Select CEO on Job Title By Value Search");
		BrowserUtilities.selectByValue(directorypage.directoryJobTitle, "7");
		logger.info("Select Canadian Development Center on Location");
		BrowserUtilities.waitFor(2);
		BrowserUtilities.selectByValue(directorypage.directoryLocation, "4");
		Assert.assertTrue(directorypage.noRecordsFind.isDisplayed());
	}

}
