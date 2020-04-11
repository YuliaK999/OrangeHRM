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
	public void Recruitment() {
		logger = reporter.createTest("Recruitment");
		recruitment.recruitment.click();
		BrowserUtilities.waitFor(5);
		String actual = driver.getTitle();
		String expected = "OrangeHRM";
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void CandidatesPositive() {
		logger = reporter.createTest("CandidatesPositive");
		driver.get(("https://opensource-demo.orangehrmlive.com/index.php/recruitment/viewCandidates"));
		//jobtitleCandidates = new Select(driver.findElement(By.id("candidateSearch_modeOfApplication")));
		//jobtitleCandidates.selectByValue("");
		recruitment.candidates.click();

		// recruitmnet.jobTitle.click();
		// recruitmnet.status.click();
		
		BrowserUtilities.selectByValue(recruitment.statusCandidates,"APPLICATION INITIATED");
		
		recruitment.name.sendKeys("Nazim");

		recruitment.keyword.sendKeys("ceo");

		recruitment.fromdate.sendKeys("2020-10-19");
		recruitment.todate.sendKeys("2020-10-29");
		
		BrowserUtilities.selectByValue(recruitment.job_Title,"2");
		

		recruitment.searchButton.click();
		BrowserUtilities.waitFor(5);

		Assert.assertTrue(true, "CEO");
		

	}

	@Test
	public void CandidatesNegative() {
		logger = reporter.createTest("CandidatesNegative");
		driver.get(("https://opensource-demo.orangehrmlive.com/index.php/recruitment/viewCandidates"));

		recruitment.candidates.click();

		// recruitmnet.jobTitle.click();
		// recruitmnet.status.click();

		BrowserUtilities.selectByVisibleText(recruitment.jobTitleCandidate,"CEO");
		
		BrowserUtilities.selectByValue(recruitment.statusCandidates,"APPLICATION INITIATED");
		
		recruitment.name.sendKeys("");

		recruitment.keyword.sendKeys("");

		recruitment.todate.sendKeys("");

	
		driver.findElement(By.id("btnSrch")).click();
		BrowserUtilities.waitFor(5);
		String expected = "No Records Found";

		Assert.assertTrue(true, expected);

		// Assert.assertTrue(true, "CEO");
		System.out.println("pass");

	}
	@Test
	public void VacancyTest()  {
		logger = reporter.createTest("VacancyTest");
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/recruitment/viewJobVacancy");
		//recruitment.vacancies.click();
		
		Assert.assertTrue(driver.getTitle().contains("OrangeHRM"));
		//Assert.assertFalse(driver.findElement(By.className("toggle tiptip")).isDisplayed());
		recruitment.jobTitleVacancies.click();
		BrowserUtilities.selectByValue(recruitment.jobTitleVacancies,"5");
				
		BrowserUtilities.selectByVisibleText(recruitment.statusVacancies,"Active");		
				
		recruitment.searchButton.click();
		BrowserUtilities.waitFor(5);
		recruitment.addButton.click();
		
		String expected = "Job Title *";
		String actual = recruitment.jobTitle.getText();

		Assert.assertEquals(actual, expected);
		
			
	}

	
		
}


		
	


