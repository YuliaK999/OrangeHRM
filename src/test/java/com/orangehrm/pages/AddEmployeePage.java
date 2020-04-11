package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.Driver;

public class AddEmployeePage {
	
	public AddEmployeePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id = "firstName")
	 public WebElement firstNameField;
	 
	@FindBy(id = "lastName")
	public WebElement lastNameField;
	
	@FindBy(id = "menu_pim_addEmployee")
	public WebElement mainAddEmployee;
	
	@FindBy(tagName = "h1")
	public WebElement headingAddEmployee;
	
	@FindBy	(xpath = "//label[@class='hasTopFieldHelp']")
	public WebElement labelFullName;
	
	@FindBy	(xpath = "//label[@for='employeeId']")
	public WebElement labelEmployeeID;
	
	@FindBy	(xpath = "//label[@for='photofile']")
	public WebElement labelPhotograph;
	
	@FindBy	(xpath = "//label[@for='chkLogin']")
	public WebElement labelCreateLoginDetails;
	
	@FindBy(id = "photofile")
	public WebElement uploadButton;
	
	@FindBy(id = "btnSave")
	public WebElement saveButton;
	
	@FindBy	(xpath = "//span[contains(text(),'Required')]")
	public WebElement firstNameErrorMessage;
	
	@FindBy	(xpath = "//span[contains(text(),'Required')]")
	public WebElement lastNameErrorMessage;
	
	@FindBy(id = "chkLogin")
	public WebElement checkbox;
	
	@FindBy	(xpath = "//label[@for='user_name']")
	public WebElement labelUserName;
	
	@FindBy	(xpath = "//label[@for='user_password']")
	public WebElement labelPassword;
	
	@FindBy	(xpath = "//label[@for='re_password']")
	public WebElement labelConfirmPassword;
	
	@FindBy	(xpath = "//label[@for='status']")
	public WebElement labelStatus;
	
	@FindBy(id = "user_name")
	public WebElement userNameField;
	
	@FindBy	(xpath = "//span[@for='user_name']")
	public WebElement userNameReqText;
	
	@FindBy(id = "user_password")
	public WebElement passwordField;
	
	@FindBy	(xpath = "//span[@for='user_password']")
	public WebElement passwordReqText;
	
	@FindBy(id = "re_password")
	public WebElement confirmPasswordField;
	
	@FindBy	(xpath = "//span[@for='re_password']")
	public WebElement confirmPasswordReqText;
	
	@FindBy(id = "status")
	public WebElement selectStatus;
	
	
	

}
