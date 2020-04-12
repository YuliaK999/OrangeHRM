package com.orangehrm.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.orangehrm.pages.RecruitmentPage;
import com.orangehrm.utils.BrowserUtilities;
import com.orangehrm.utils.ConfigReader;

public class RecruitmentTest extends TestBase {

	RecruitmentPage recruitment = new RecruitmentPage();
	
	@Test
	public void verifyPageTitle() {
		logger = reporter.createTest("Verify PageTitle is \"OrangeHRM\"");
		recruitment.mainMenuRecruitment.click();
		BrowserUtilities.waitFor(5);
		String actual = driver.getTitle();
		String expected = "OrangeHRM";
		Assert.assertEquals(actual, expected);
		logger.pass("Verified PageTitle is \"OrangeHRM\"");
	}

	@Test
	public void verifyCandidateForm() {
		logger = reporter.createTest("Verify candidate form");
		recruitment.mainMenuRecruitment.click();
		recruitment.candidates.click();

		BrowserUtilities.selectByValue(recruitment.statusCandidates,"APPLICATION INITIATED");
		
		recruitment.name.sendKeys("Nazim");

		recruitment.keyword.sendKeys("ceo");

		recruitment.fromdate.sendKeys("2020-10-19");
		recruitment.todate.sendKeys("2020-10-29");
		
		BrowserUtilities.selectByValue(recruitment.jobTitleCandidates,"9");
		
		recruitment.searchButton.click();
		BrowserUtilities.waitFor(5);

		logger.info("Verify \"No Records Found\" message is displayed");
		Assert.assertTrue(recruitment.messageNoRecords.getText().equals("No Records Found"));
		logger.pass("Verified no records are found");

	}

	@Test
	@Ignore
	public void verifyAddButton()  {
		logger = reporter.createTest("Verify Add button");
		recruitment.mainMenuRecruitment.click();
		recruitment.vacancies.click();
	
		recruitment.addButton.click();
		// Verify the title "Add Job Vacancy",send keys to all the fields, 
		//verify nothing happens when click on Save
		
	}
		
}


		
	


