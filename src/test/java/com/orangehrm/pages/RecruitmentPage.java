package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orangehrm.utils.Driver;



public class RecruitmentPage {
	
	public RecruitmentPage () {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id="menu_recruitment_viewRecruitmentModule")
	public WebElement mainMenuRecruitment;
	
	@FindBy(id="menu_recruitment_viewCandidates")
	public WebElement candidates;
	
	@FindBy(id="menu_recruitment_viewJobVacancy")
	public WebElement vacancies;
	
	@FindBy(id="candidateSearch_jobTitle")
	public WebElement jobTitleCandidates;
	
	@FindBy(id = "candidateSearch_status")
	public WebElement statusCandidates;
	
	@FindBy(xpath ="//select[@name='candidateSearch[jobTitle]']")
	public WebElement jobTitleCandidate;
	
	@FindBy(id = "vacancySearch_status")
	public WebElement statusVacancies;
	
	@FindBy(id="candidateSearch_modeOfApplication")
	public WebElement jobTitle;
	
	@FindBy(id="vacancySearch_jobTitle")
	public WebElement jobTitleVacancies;
	
	@FindBy(id = "candidateSearch_toDate")
	public WebElement todate;
	
	@FindBy (xpath="//*[@id='resultTable']//tr//td")
	public WebElement messageNoRecords;
	
	@FindBy(id = "candidateSearch_fromDate")
	public WebElement fromdate;
	
	@FindBy(id = "candidateSearch_keywords")
	public WebElement keyword;

	@FindBy(id = "candidateSearch_candidateName")
	public WebElement name;

	@FindBy(id = "btnSrch")
	public WebElement searchButton;
	
	@FindBy(id = "btnAdd")
	public WebElement addButton;
	
	

}


