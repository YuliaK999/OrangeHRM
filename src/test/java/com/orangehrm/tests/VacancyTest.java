package com.orangehrm.tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.orangehrm.pages.VacancyPage;
import com.orangehrm.utils.BrowserUtilities;

public class VacancyTest extends TestBase {

	

	@Test
	public void verifyVacancyForm() {
		VacancyPage vacancyPage = new VacancyPage();
		logger = reporter.createTest("Verify vacancy form");
		vacancyPage.mainMenuRecruitment.click();
		vacancyPage.vacancies.click();

		BrowserUtilities.selectByValue(vacancyPage.jobTitleVacancies, "5");

		BrowserUtilities.selectByVisibleText(vacancyPage.statusVacancies, "Active");

		vacancyPage.searchButton.click();
		BrowserUtilities.waitFor(5);

		logger.info("Verify \"No Records Found\" message is displayed");
		Assert.assertTrue(vacancyPage.messageNoRecords.getText().equals("No Records Found"));
		logger.pass("Verified no records are found");

	}

	// @Ignore
	@Test
	public void verifyErrorMessages() {
		VacancyPage vacancyPage = new VacancyPage();
		logger = reporter.createTest("Verify Error messages");
		vacancyPage.mainMenuRecruitment.click();
		vacancyPage.vacancies.click();

		vacancyPage.addButton.click();
		BrowserUtilities.waitFor(2);
		Select s=new Select(vacancyPage.addJobVacancyjobTitle);
		s.selectByValue("3");

		//BrowserUtilities.selectByVisibleText(vacancyPage.addJobVacancyjobTitle, "CEO ");

		BrowserUtilities.waitFor(1);

		vacancyPage.addJobVacancyName.sendKeys("Linda" + Keys.ENTER);
		BrowserUtilities.waitFor(1);

		vacancyPage.addJobVacancyHiringManager.sendKeys("Russel Hamilton");
		
		if(vacancyPage.checkJobVacancyButton1.isSelected()) {
			vacancyPage.checkJobVacancyButton1.click();
			
		}

		if(vacancyPage.checkJobVacancyButtonPublish.isSelected()) {
			vacancyPage.checkJobVacancyButtonPublish.click();
			
		}
		BrowserUtilities.waitFor(2);
		
		
		vacancyPage.saveButton.click();

		Assert.assertTrue(vacancyPage.messageEror.getText().contains("internal"));
		
	}

}
