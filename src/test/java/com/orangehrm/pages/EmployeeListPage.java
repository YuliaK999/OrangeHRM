package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.Driver;

public class EmployeeListPage {
	
	public EmployeeListPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id = "menu_pim_viewEmployeeList")
	public WebElement mainEmployeeList;
	
	@FindBy(tagName = "h1")
	public WebElement headingEmployeeInformation;
	
	@FindBy	(xpath = "//label[@for='empsearch_employee_name']")
	public WebElement labelEmployeeName;
	
	@FindBy	(xpath = "//label[@for='empsearch_id']")
	public WebElement labelID;
	
	@FindBy	(xpath = "//label[@for='empsearch_employee_status']")
	public WebElement labelEmploymentStatus;
	
	@FindBy	(xpath = "//label[@for='empsearch_supervisor_name']")
	public WebElement labelSupervisorName;
	
	@FindBy	(xpath = "//label[@for='empsearch_job_title']")
	public WebElement labelJobTitle;
	
	@FindBy	(xpath = "//label[@for='empsearch_sub_unit']")
	public WebElement labelSubUnit;
	
	@FindBy	(xpath = "//label[@for='empsearch_termination']")
	public WebElement labelInclude;
	
	@FindBy(id = "empsearch_employee_name_empName")
	public WebElement employeeNameField;
	
	@FindBy(id = "empsearch_id")
	public WebElement iDField;
	
	@FindBy (xpath="//*[@id='resultTable']//tr//td[2]")
	public WebElement resultId;
	
	@FindBy (xpath="//*[@id='resultTable']//tr//td[3]")
	public WebElement resultFirstName;
	
	@FindBy (xpath="//*[@id='resultTable']//tr//td[4]")
	public WebElement resultLastName;
	
	@FindBy(id = "searchBtn")
	public WebElement searchButton;
	
	@FindBy(id = "btnAdd")
	public WebElement addButton;
	
	@FindBy(id = "empsearch_employee_status")
	public WebElement employmentStatusField;
	
	@FindBy(id = "empsearch_job_title")
	public WebElement jobTitleField;
	
	@FindBy(id = "empsearch_sub_unit")
	public WebElement subUnitField;
	
	@FindBy(id = "resetBtn")
	public WebElement resetButton;
	
	@FindBy (xpath="//option[.='All']")
	public WebElement selectedAll;
	

}
