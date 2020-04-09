package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.BrowserUtilities;
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
	
	@FindBy	(tagName = "h1")
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
	
	@FindBy	(xpath = "//span[@for='entitlements_employee_empId']") 
	public WebElement errorMessage2;
	
	@FindBy	(xpath = "//span[@for='entitlements_entitlement']") 
	public WebElement errorMessage3;
	
	@FindBy	(xpath = "//label[@for='entitlements_filters_bulk_assign']")
	public WebElement labelAddToMultipleEmployees;
	
	@FindBy	(id = "entitlements_filters_bulk_assign")
	public WebElement checkboxAddToMultipleEmployees;
	
	@FindBy	(xpath = "//*[@id='frmLeaveEntitlementAdd']/fieldset/ol/li[6]")
	public WebElement labelRequiredField;
	
	@FindBy	(id = "entitlements_filters_location")
	public WebElement fieldLocation;
	
	@FindBy	(id = "entitlements_filters_subunit")
	public WebElement fieldSubUnit;
	
	@FindBy	(id = "ajax_count")
	public WebElement matchesEmployees;
	
	public int numberOfEmployees (String location, String subUnit) {
		int number=2;
		
		if (location=="All" & subUnit=="All") {
			BrowserUtilities.selectByVisibleText(fieldLocation,"All");
			BrowserUtilities.selectByVisibleText(fieldSubUnit,"All");
			number=9;
		}else if (location=="All" & subUnit=="IT") {
			BrowserUtilities.selectByVisibleText(fieldLocation,"All");
			BrowserUtilities.selectByVisibleText(fieldSubUnit,"IT");
			number=2;
		}else if (location=="All" & subUnit=="Sales") {
			BrowserUtilities.selectByVisibleText(fieldLocation,"All");
			BrowserUtilities.selectByVisibleText(fieldSubUnit,"Sales");
			number=2;
		}else if (location=="All" & subUnit=="Finance") {
			BrowserUtilities.selectByVisibleText(fieldLocation,"All");
			BrowserUtilities.selectByVisibleText(fieldSubUnit,"Finance");
			number=2;
		}else if (location=="All" & subUnit=="Administration") {
			BrowserUtilities.selectByVisibleText(fieldLocation,"All");
			BrowserUtilities.selectByVisibleText(fieldSubUnit,"Administration");
			number=3;		
		}else if (location=="Canada" & subUnit=="All") {
			BrowserUtilities.selectByVisibleText(fieldLocation,"  Canada");
			BrowserUtilities.selectByVisibleText(fieldSubUnit,"All");
			number=2;
		}else if (location=="Canada" & subUnit=="IT") {
			BrowserUtilities.selectByVisibleText(fieldLocation,"  Canada");
			BrowserUtilities.selectByVisibleText(fieldSubUnit,"IT");
			number=2;
		} else if (location=="United States" & subUnit=="All") {
			BrowserUtilities.selectByVisibleText(fieldLocation,"  United States");
			BrowserUtilities.selectByVisibleText(fieldSubUnit,"All");
			number=7;
		} else if (location=="United States" & subUnit=="Sales") {
			BrowserUtilities.selectByVisibleText(fieldLocation,"  United States");
			BrowserUtilities.selectByVisibleText(fieldSubUnit,"Sales");
			number=2;
		} else if (location=="United States" & subUnit=="Finance") {
			BrowserUtilities.selectByVisibleText(fieldLocation,"  United States");
			BrowserUtilities.selectByVisibleText(fieldSubUnit,"Finance");
			number=2;
		} else if (location=="United States" & subUnit=="Administration") {
			BrowserUtilities.selectByVisibleText(fieldLocation,"  United States");
			BrowserUtilities.selectByVisibleText(fieldSubUnit,"Administration");
			number=3;
		}else number=-1;
		
		return number;
	}
	

}
