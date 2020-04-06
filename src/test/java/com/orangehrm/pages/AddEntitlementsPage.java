package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.ConfigReader;
import com.orangehrm.utils.Driver;

public class AddEntitlementsPage {
	
	public AddEntitlementsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id = "menu_leave_viewLeaveModule")
	public WebElement mainMenuLeave;
	
	@FindBy	(id = "menu_leave_Entitlements")
	public WebElement menuEntitlements;
	
	@FindBy	(id = "menu_leave_addLeaveEntitlement")
	public WebElement optionAddEntitlements;
	
	@FindBy	(id = "//h1")
	public WebElement headingAddLeaveEntitlement;
	
	@FindBy	(xpath = "//label[@for='entitlements_employee']")
	public WebElement labelEmployee;
	
	@FindBy	(xpath = "//label[@for='entitlements_leave_type']")
	public WebElement labelLeaveType;
	
	@FindBy	(xpath = "//label[@for='entitlements_date']")
	public WebElement labelLeavePeriod;
	
	@FindBy	(xpath = "//label[@for='entitlements_entitlement']")
	public WebElement labelEntitlement;
	
	@FindBy	(id = "entitlements_employee_empName")
	public WebElement fieldEmployee;
	
	@FindBy	(id = "entitlements_leave_type")
	public WebElement fieldLeaveType;
	
	@FindBy	(id = "period")
	public WebElement fieldLeavePeriod;
	
	@FindBy	(id = "entitlements_entitlement")
	public WebElement fieldEntitlement;
	
	@FindBy	(id = "btnSave")
	public WebElement saveButton;
	
	@FindBy	(xpath = "//span[@for='entitlements_entitlement']") 
	public WebElement errorMessage1;
	
	@FindBy	(xpath = "//span[@for='entitlements_employee_empId']']") 
	public WebElement errorMessage2;
	
	@FindBy	(xpath = "//span[@for='entitlements_entitlement']") 
	public WebElement errorMessage3;
	
	
	

}
