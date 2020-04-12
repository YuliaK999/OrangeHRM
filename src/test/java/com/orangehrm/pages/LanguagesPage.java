package com.orangehrm.pages;

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
	
	@FindBy(className = "toggle tiptip")
	public WebElement headingSystemUsers;

}


