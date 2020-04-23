package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.Driver;

public class CandidatesPage {
	
	public CandidatesPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		
	}
	@FindBy(id="menu_recruitment_viewRecruitmentModule")
	public WebElement mainMenuRecruitment;
	
	@FindBy(id="menu_recruitment_viewCandidates")
	public WebElement candidates;
	
	@FindBy(xpath="//span[@for='addCandidate_email']")
	public WebElement candidatesEmailRequired;
	
	
	@FindBy(id="addCandidateHeading")
	public WebElement addCandidatesHeader;
	
	@FindBy(id="addCandidate_firstName")
	public WebElement addCandidatesFirstName;
	
	@FindBy(id="addCandidate_lastName")
	public WebElement addCandidatesLastName;
	
	@FindBy(id="addCandidate_email")
	public WebElement addCandidatesEmail;
	
	
	@FindBy(xpath="//input[@id='addCandidate_resume']")
	public WebElement addCandidatesUpload;
	
	@FindBy(id="addCandidate_appliedDate")
	public WebElement addCandidatesDateOfApplication;
	
	@FindBy(id="btnSave")
	public WebElement addCandidatesSaveButton;
	
	@FindBy(id="btnAdd")
	public WebElement candidatesAddButton;
	
	@FindBy(xpath="//div[@class='head']")
	public WebElement candidatesErrorHeader;
	
	@FindBy(xpath="//a[@class='toggle tiptip']")
	public WebElement candidatesHeader;
	
	@FindBy(xpath="//input[@class='checkbox']")
	public WebElement addCandidatesCheckBox;
	
	
	
	
	
}
