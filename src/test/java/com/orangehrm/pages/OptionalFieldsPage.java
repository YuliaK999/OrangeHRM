package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.Driver;

public class OptionalFieldsPage {
	
	public OptionalFieldsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id = "menu_pim_Configuration")
	 public WebElement configurationMenu;
	
	@FindBy(id = "menu_pim_configurePim")
	 public WebElement optionalFieldsMenu;
	
	@FindBy(tagName = "h1")
	public WebElement configurePIMHeader;
	
	@FindBy	(xpath = "//input[@value='Edit']")
	public WebElement editButton;
	
	@FindBy	(xpath = "//input[@value='Save']")
	public WebElement saveButton;
	
	@FindBy (xpath="//li[@class='checkbox']")
	public List<WebElement> checkboxes;

}
