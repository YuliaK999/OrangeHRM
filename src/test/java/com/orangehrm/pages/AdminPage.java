package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.Driver;

public class AdminPage {
	
	public AdminPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id = "menu_admin_viewAdminModule")
	public WebElement mainMenuAdmin;

	@FindBy(tagName = "h1")
	public WebElement headingSystemUsers;

	@FindBy(id = "search_form")
	public WebElement searchForm;

	@FindBy(xpath = "(//div[@id='content']//a)[1]")
	public WebElement header;

}
