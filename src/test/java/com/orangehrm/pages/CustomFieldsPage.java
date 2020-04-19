package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.Driver;

public class CustomFieldsPage {
	
	public CustomFieldsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id = "menu_pim_Configuration")
	 public WebElement configurationMenu;
	
	@FindBy(id = "menu_pim_listCustomFields")
	 public WebElement customFieldsMenu;
	
	@FindBy(tagName = "h1")
	public WebElement addCustomFieldHeader;

}
