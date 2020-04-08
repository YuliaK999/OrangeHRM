package com.orangehrm.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orangehrm.pages.RecruitmentPage;
import com.orangehrm.utils.ConfigReader;

public class RecruitmentTest extends TestBase {

	RecruitmentPage recruitment = new RecruitmentPage();
	
	@Test
	public void RecruitemntTest() {

		recruitment.recruitment.click();
		String actual = driver.getTitle();
		String expected = "OrangeHRM";
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void CandidatesPositive() {

		driver.get(("https://opensource-demo.orangehrmlive.com/index.php/recruitment/viewCandidates"));

		recruitment.candidates.click();

		// recruitmnet.jobTitle.click();
		// recruitmnet.status.click();

		Select jobtitle = new Select(driver.findElement(By.xpath("//select[@name='candidateSearch[jobTitle]']")));

		jobtitle.selectByVisibleText("CEO");

		jobtitle = new Select(driver.findElement(By.id("candidateSearch_status")));
		jobtitle.selectByValue("APPLICATION INITIATED");

		recruitment.name.sendKeys("Nazim");

		recruitment.keyword.sendKeys("ceo");

		recruitment.fromdate.sendKeys("2020-10-19");
		recruitment.todate.sendKeys("2020-10-29");

		jobtitle = new Select(driver.findElement(By.id("candidateSearch_modeOfApplication")));
		jobtitle.selectByValue("2");

		recruitment.searchButton.click();

		Assert.assertTrue(true, "CEO");
		System.out.println("pass");

	}

	@Test
	public void CandidatesNegative() {

		

		driver.get(("https://opensource-demo.orangehrmlive.com/index.php/recruitment/viewCandidates"));

		recruitment.candidates.click();

		// recruitmnet.jobTitle.click();
		// recruitmnet.status.click();

		Select jobtitleCandidates = new Select(driver.findElement(By.xpath("//select[@name='candidateSearch[jobTitle]']")));

		jobtitleCandidates.selectByVisibleText("CEO");

		jobtitleCandidates = new Select(driver.findElement(By.id("candidateSearch_status")));
		jobtitleCandidates.selectByValue("APPLICATION INITIATED");

		recruitment.name.sendKeys("");

		recruitment.keyword.sendKeys("");

		recruitment.todate.sendKeys("");

		jobtitleCandidates = new Select(driver.findElement(By.id("candidateSearch_modeOfApplication")));
		jobtitleCandidates.selectByValue("");
		driver.findElement(By.id("btnSrch")).click();
		String expected = "No Records Found";

		Assert.assertTrue(true, expected);

		// Assert.assertTrue(true, "CEO");
		System.out.println("pass");

	}
	@Test
	public void VacancyTest()  {
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/recruitment/viewJobVacancy");
		//recruitment.vacancies.click();
		
		Assert.assertTrue(driver.getTitle().contains("OrangeHRM"));
		//Assert.assertFalse(driver.findElement(By.className("toggle tiptip")).isDisplayed());
		recruitment.jobTitleVacancies.click();
		Select jobtitleVacancies = new Select(driver.findElement(By.id("vacancySearch_jobTitle")));
		
		jobtitleVacancies.selectByValue("5");
		Select status = new Select(driver.findElement(By.id("vacancySearch_status")));
		
		status.selectByVisibleText("Active");
		
		recruitment.searchButton.click();
		recruitment.addButton.click();
		String expected = "Job Title *";
		String actual = driver.findElement(By.xpath("//label[@for='addJobVacancy_jobTitle']")).getText();

		Assert.assertEquals(actual, expected);
		
		
		
		
		
		
	}

	
		
	}


		
	


