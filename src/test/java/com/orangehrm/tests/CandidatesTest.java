package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pages.CandidatesPage;
import com.orangehrm.utils.BrowserUtilities;

public class CandidatesTest extends TestBase {
		
		@Test
		public void CandidateHeader() {
			
			CandidatesPage candidatesPage = new CandidatesPage ();
			
			logger =reporter.createTest("Verify Candidate Hedaer is Visible");
			
			logger.info("Click on Recruitment Page");
			candidatesPage.mainMenuRecruitment.click();
			logger.info("Click on Candidates Page");
			
			candidatesPage.candidates.click();
			
			logger.info("Verify \" Candidate Header\" Visible");
			Assert.assertTrue(candidatesPage.candidatesHeader.isDisplayed());
			logger.pass("Candidates Header is Visible");
			
			
			
		}
		@Test
		public void  AddCandidatesHeader() {
			CandidatesPage candidatesPage = new CandidatesPage ();
			
			logger =reporter.createTest("Verify Add Candidate Header is Visible");
			candidatesPage.mainMenuRecruitment.click();
			logger.info("Click On Add Button");
			candidatesPage.candidatesAddButton.click();
			
			logger.info("Verify \"Add Candidate Header\"  Visible");
			
			Assert.assertTrue(candidatesPage.addCandidatesHeader.isDisplayed());
			
			
			
		}
		
	
		@Test
		public void CompleteAddCandidateForm() {
			CandidatesPage candidatesPage = new CandidatesPage ();
			logger =reporter.createTest("Complete Add Candidate Form And Click on Save Button");
			candidatesPage.mainMenuRecruitment.click();
			logger.info("Click On Add Button");
			candidatesPage.candidatesAddButton.click();
			logger.info("File Out The Form And Click On Save Button");
			
			candidatesPage.addCandidatesFirstName.sendKeys("Linda");
			candidatesPage.addCandidatesLastName.sendKeys("Anderson");
			candidatesPage.addCandidatesEmail.sendKeys("linda@yahoo.com");
			BrowserUtilities.waitFor(3);
			//candidatesPage.addCandidatesUpload.sendKeys("/Users/mariabakatkina/git/OrangeHRM8/src/test/java/com/orangehrm/tests/CandidatesTest.java");
			candidatesPage.addCandidatesDateOfApplication.sendKeys("22-04-2020");
			
			
			if(!candidatesPage.addCandidatesCheckBox.isSelected()) {
				candidatesPage.addCandidatesCheckBox.click();
				BrowserUtilities.waitFor(3);
				
			}
			candidatesPage.addCandidatesSaveButton.click();
			logger.info("Verify Error Header ");
			Assert.assertTrue(candidatesPage.candidatesErrorHeader.isDisplayed());
			logger.pass("Error Header Visibility Verified");
			
		}
		@Test
		public void NegativeCompleteAddCandidateForm() {
			CandidatesPage candidatesPage = new CandidatesPage ();
			logger =reporter.createTest("Click On Save Button Without Completing form");
			
			candidatesPage.mainMenuRecruitment.click();
			candidatesPage.candidatesAddButton.click();
			candidatesPage.addCandidatesSaveButton.click();
			Assert.assertTrue(candidatesPage.candidatesEmailRequired.isDisplayed());
			logger.pass("Email \"Required\" Message Verified" );
			
			
		}
		
		
	}


