package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.orangehrm.pages.VacancyPage;
import com.orangehrm.utils.BrowserUtilities;

public class VacancyTest extends TestBase {

		
	@Test
	public void verifyVacancyForm()  {
		VacancyPage vacancyPage = new VacancyPage();
		logger = reporter.createTest("Verify vacancy form");
		vacancyPage.mainMenuRecruitment.click();
		vacancyPage.vacancies.click();
			
		BrowserUtilities.selectByValue(vacancyPage.jobTitleVacancies,"5");
				
		BrowserUtilities.selectByVisibleText(vacancyPage.statusVacancies,"Active");		
				
		vacancyPage.searchButton.click();
		BrowserUtilities.waitFor(5);
		
		logger.info("Verify \"No Records Found\" message is displayed");
		Assert.assertTrue(vacancyPage.messageNoRecords.getText().equals("No Records Found"));
		logger.pass("Verified no records are found");
		
			
	}
	
	@Ignore	
	@Test
	public void verifyErrorMessages()  {
		VacancyPage vacancyPage = new VacancyPage();
		logger = reporter.createTest("Verify Error messages");
		vacancyPage.mainMenuRecruitment.click();
		vacancyPage.vacancies.click();
	
		vacancyPage.addButton.click();
		//Click on Save button
		//Verify Error messages
	}
	 

}
