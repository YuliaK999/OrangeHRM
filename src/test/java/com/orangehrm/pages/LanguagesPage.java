package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.Driver;

public class LanguagesPage {
	
	public LanguagesPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id = "menu_admin_viewAdminModule")
	public WebElement mainMenuAdmin;

	@FindBy(id = "menu_admin_Qualifications")
	public WebElement menuQualifications;

	@FindBy(id = "menu_admin_viewLanguages")
	public WebElement subMenuLanguages;

	@FindBy(id = "menu_admin_viewSkills")
	public WebElement subMenuSkills;

	@FindBy(xpath = "(//h1)[2]")
	public WebElement headingLanguages;

	@FindBy(id = "btnAdd")
	public WebElement buttonAdd;

	@FindBy(id = "btnSave")
	public WebElement buttonSave;

	@FindBy(id = "language_name")
	public WebElement fieldName;

	@FindBy(id = "skill_name")
	public WebElement fieldName2;

	@FindBy(xpath = "//td[@class='tdName tdValue']")
	public List<WebElement> resultLanguages;

	@FindBy(xpath = "//td[@class='check']")
	public List<WebElement> resultCheckboxes;

	@FindBy(id = "checkAll")
	public WebElement checkboxCheckAll;

	@FindBy(id = "btnDel")
	public WebElement buttonDelete;

	@FindBy(xpath = "//td[@class='tdName tdValue']")
	public WebElement firstLanguage;

	@FindBy(xpath = "//td[@class='tdName tdValue']")
	public WebElement language;

	@FindBy(xpath = "(//script[@type='text/javascript'])[16]")
	public WebElement message;

	@FindBy(xpath = "//span[@for='skill_name']")
	public WebElement messageAlreadyExists;

	public WebElement getSkill(String skill) {
	String customXpath = "//table[@id='recordsListTable']//a[.='"+skill+"']";
	return Driver.getDriver().findElement(By.xpath(customXpath));
	}
	
	
	
	
	
	
}


