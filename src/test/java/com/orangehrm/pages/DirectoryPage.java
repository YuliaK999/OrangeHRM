package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.orangehrm.utils.Driver;

public class DirectoryPage {
	
public DirectoryPage () {
		
		PageFactory.initElements(Driver.getDriver(), this);
		
		
	
	}
	@FindBy(id="menu_directory_viewDirectory")
	public WebElement directory;
	
	@FindBy(xpath="//input[@name='searchDirectory[emp_name][empName]']")
	public WebElement directorySearchName;
	
	@FindBy(id="searchDirectory_job_title")
	public WebElement directoryJobTitle;
	
	@FindBy(id="searchDirectory_location")
	public WebElement directoryLocation;
	
	@FindBy(id="searchBtn")
	public WebElement directorySearch;
	
	@FindBy(id="resetBtn")
	public WebElement directoryReset;
	
	@FindBy(xpath="//li[@style='font-size: 12px;'][2]")
	public WebElement lindaAnderson;
	
	@FindBy(xpath="(//div[@class='inner'])[2]")
	public WebElement noRecordsFind;
	
	@FindBy(id ="search_form")
	public WebElement searchHiddenButton;

	
	
	
	
}
	
	


