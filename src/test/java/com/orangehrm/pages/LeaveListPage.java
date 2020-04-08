package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orangehrm.utils.BrowserUtilities;
import com.orangehrm.utils.ConfigReader;
import com.orangehrm.utils.Driver;

public class LeaveListPage {
		
	public LeaveListPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id = "menu_leave_viewLeaveModule")
	public WebElement mainMenuLeave;
			
	@FindBy(id = "menu_leave_viewLeaveList")
	public WebElement menuLeaveList;
	
	@FindBy(id = "calFromDate")
	public WebElement calendarFrom;
	
	@FindBy(id = "calToDate")
	public WebElement calendarTo;
	
	@FindBy (xpath="//div[@id='leaveList_chkSearchFilter_checkboxgroup']/input")
	public List<WebElement> checkboxleaveStatuses;
	
	@FindBy(id = "leaveList_chkSearchFilter_checkboxgroup_allcheck")
	public WebElement checkboxLeaveStatusAll;
	
	@FindBy(id = "leaveList_chkSearchFilter_-1")
	public WebElement checkboxLeaveStatusRejected;
	
	@FindBy(id = "leaveList_chkSearchFilter_0")
	public WebElement checkboxLeaveStatusCancelled;
	
	@FindBy(id = "leaveList_chkSearchFilter_1")
	public WebElement checkboxLeaveStatusPendingApproval;
	
	@FindBy(id = "leaveList_chkSearchFilter_2")
	public WebElement checkboxLeaveStatusScheduled;
	
	@FindBy(id = "leaveList_chkSearchFilter_3")
	public WebElement checkboxLeaveStatusTaken;	
	
	@FindBy(name = "leaveList[txtEmployee][empName]")
	public WebElement fieldEmployee;
	
	@FindBy(id = "leaveList_cmbSubunit")
	public WebElement dropdownSubUnit;
	
	@FindBy(id = "leaveList_cmbWithTerminated")
	public WebElement checkboxIncludePastEmployees;
	
	@FindBy(id = "btnSearch")
	public WebElement buttonSearch;
	
	@FindBy(id = "btnReset")
	public WebElement buttonReset;
	
	@FindBy(xpath="//select[@data-handler='selectMonth']")
	public WebElement dropdownSelectMonth;
	
	@FindBy(xpath="//select[@data-handler='selectYear']")
	public WebElement dropdownSelectYear;
	
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']")
	public WebElement tableSelectDay;
	
	//@FindBy(partialLinkText =" to ")
	//public WebElement leaveDate;
	
	@FindBy(xpath ="//*[@id='resultTable']//tr//td[1]")
	public WebElement leaveDate;
	
	@FindBy (xpath="//*[@id='resultTable']//tr//td[2]")
	public WebElement employeeName;
	
	@FindBy (xpath="//*[@id='resultTable']//tr//td[5]")
	public WebElement numberOfDays;
	
	@FindBy (xpath="//*[@id='resultTable']//tr//td[6]")
	public WebElement leaveStatus;
	
	@FindBy (xpath="//*[@id='resultTable']//tr//td")
	public WebElement messageNoRecords;
	
	public void selectDate( String month, int year, int day){
		BrowserUtilities.selectByVisibleText(dropdownSelectMonth, month);
		BrowserUtilities.selectByVisibleText(dropdownSelectYear,""+year);
		selectCalendarDay (tableSelectDay, day);
	}
	
	
	
	public void selectCalendarDay (WebElement calendar, int day) {
		List<WebElement> rows = calendar.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
				for (WebElement cell : cells) {
					if (cell.getText().equals(""+day)) {
						cell.click();
						break;
					}
				}
			}
	}
	
	
	
	
	

	
}
