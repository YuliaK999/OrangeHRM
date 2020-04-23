package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.Driver;

public class VacancyPage {
	
	public VacancyPage () {
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
	
	@FindBy(id = "btnSave")
	public WebElement saveButton;
	
	
	
	@FindBy(xpath = "//div[@class='message error']")
	public WebElement messageEror;
	
	@FindBy(xpath = "//select[@id='addJobVacancy_jobTitle']")
	public WebElement addJobVacancyjobTitle;
	
	@FindBy(id = "addJobVacancy_name")
	public WebElement addJobVacancyName;
	
	@FindBy(id = "addJobVacancy_hiringManager")
	public WebElement addJobVacancyHiringManager;
	
	@FindBy(xpath = "//input[@id='addJobVacancy_status']")
	public WebElement checkJobVacancyButton1;

	@FindBy(xpath = "//input[@id='addJobVacancy_publishedInFeed']")
	public WebElement checkJobVacancyButtonPublish;
	

}
