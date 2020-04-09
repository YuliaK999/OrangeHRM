package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.Driver;

public class PimMenuPage {

	public PimMenuPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(linkText = "PIM")
	public WebElement mainMenuPIM;
	
	@FindBy	(id = "menu_pim_Configuration")
	public WebElement menuConfiguration;
	
	@FindBy	(id = "menu_pim_viewEmployeeList")
	public WebElement menuEmployeeList;
	
	@FindBy	(id = "menu_pim_addEmployee")
	public WebElement menuAddEmployee;
	
	@FindBy	(id = "menu_core_viewDefinedPredefinedReports")
	public WebElement menuReports;

}
