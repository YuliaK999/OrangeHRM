package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.Driver;

public class EmployeeEntitlementsPage {

	public EmployeeEntitlementsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id = "menu_leave_viewLeaveModule")
	public WebElement mainMenuLeave;
	
	@FindBy	(id = "menu_leave_Entitlements")
	public WebElement menuEntitlements;
	
	@FindBy	(id = "menu_leave_viewLeaveEntitlements")
	public WebElement optionEmployeeEntitlements;
	
	@FindBy	(id = "//h1")
	public WebElement headingLeaveEntitlements;
	
	@FindBy	(id = "entitlements_employee_empName")
	public WebElement fieldEmployee;
	
	@FindBy	(id = "entitlements_leave_type")
	public WebElement dropdownLeaveType;
	
	@FindBy	(id = "period")
	public WebElement dropdownLeavePeriod;
	
	@FindBy	(id = "searchBtn")
	public WebElement buttonSearch;
	
}
