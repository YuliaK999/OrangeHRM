package com.orangehrm.pages;

import java.util.List;

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
	
	@FindBy(xpath = "(//h1)[2]")
	public WebElement headingLanguages;
	
	@FindBy(id = "btnAdd")
	public WebElement buttonAdd;
	
	@FindBy(id = "btnSave")
	public WebElement buttonSave;
	
	@FindBy(id = "language_name")
	public WebElement fieldName;
	
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
	
	
	
	
	
	
}


