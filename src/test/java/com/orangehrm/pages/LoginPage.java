package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.ConfigReader;
import com.orangehrm.utils.Driver;

public class LoginPage {
	
	public LoginPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy	(id = "txtUsername")
	@CacheLookup
	public WebElement usernameField ;
	
	@FindBy	(id = "txtPassword")
	@CacheLookup
	public WebElement passwordField;
	
	@FindBy	(id = "btnLogin")
	@CacheLookup
	public WebElement loginButton;
	
	@FindBy	(id = "spanMessage")
	@CacheLookup
	public WebElement errorMessage;
	
	
	public void positiveLogin() {
		usernameField.sendKeys(ConfigReader.getConfiguration("username"));
		passwordField.sendKeys(ConfigReader.getConfiguration("password"));
		loginButton.click();
		
	}
	
		

}
