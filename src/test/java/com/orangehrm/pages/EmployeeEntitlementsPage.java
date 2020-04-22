package com.orangehrm.pages;

import java.util.List;

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
	
	@FindBy	(tagName = "h1")
	public WebElement headingLeaveEntitlements;
	
	@FindBy	(id = "entitlements_employee_empName")
	public WebElement fieldName;
	
	@FindBy	(xpath = "//div[@class='ac_results']/ul/li")
	public List<WebElement> dynamicDropdownNames;
	
	@FindBy	(id = "period")
	public WebElement leavePeriodDropdown;
	
	@FindBy	(id = "searchBtn")
	public WebElement buttonSearch;
	
	@FindBy	(xpath = "//*[@id='resultTable']//tr//td[@class='left'][1]")
	public List<WebElement> resultLeaveType;
	
	@FindBy	(xpath = "//*[@id='resultTable']//tr//td[@class='left'][2]")
	public List<WebElement> resultEntitlementType;
	
	@FindBy	(xpath = "//select[@id='entitlements_leave_type']/option")
	public List<WebElement> leaveTypes;
	
	@FindBy	(xpath = "//*[@id='resultTable']//tr[@class='total']//td[@class='right']")
	public WebElement total;
	
	@FindBy	(xpath = "//*[@id='resultTable']//tr[@class='even']//td[@class='right']")
	public List<WebElement> evenListDays;
	
	@FindBy	(xpath = "//*[@id='resultTable']//tr[@class='odd']//td[@class='right']")
	public List<WebElement> oddListDays;
	
	public int sum(List<WebElement> days) {
		int s = 0;
		for (WebElement day : days) 
		s+=Double.parseDouble(day.getText());
	return s;
	}
	
}


