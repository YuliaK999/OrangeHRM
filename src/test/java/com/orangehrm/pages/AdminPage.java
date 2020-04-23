package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.Driver;

public class AdminPage {
	
	public AdminPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id = "menu_admin_viewAdminModule")
	public WebElement mainMenuAdmin;

	@FindBy(tagName = "h1")
	public WebElement headingSystemUsers;

	@FindBy(id = "search_form")
	public WebElement searchForm;

	@FindBy(xpath = "(//div[@id='content']//a)[1]")
	public WebElement header;
	
	@FindBy(id = "searchSystemUser_userName")
    public WebElement UserName;
    
    @FindBy(id = "searchSystemUser_userType")
    public WebElement UserType;
    
    @FindBy (xpath="/html/body/div[1]/div[3]/div[1]/div[2]/form/fieldset/ol/li[2]/select/option[3]")
    public WebElement checkboxUserRole;
    
    @FindBy (xpath="//*[@id=\"searchSystemUser_userType\"]/option[3]")
    public WebElement NameUserRole;
    
    @FindBy (id="searchSystemUser_employeeName_empName")
    public WebElement EmployeeName;
    
    @FindBy (id="searchSystemUser_status")
    public WebElement SystemStatusUser;
    
    @FindBy (xpath="//*[@id=\"searchSystemUser_status\"]/option[2]")
    public WebElement SystemStatusOption;
    
    @FindBy (id="searchBtn")
    public WebElement BtnSearch;
    
    @FindBy (id="ohrmList_chkSelectRecord_10")
    public WebElement SelectRecord;
    
    @FindBy (id="btnDelete")
    public WebElement ButtonDelete;
    
    @FindBy (id="dialogDeleteBtn")
    public WebElement DiaButtonDelete;
    
    @FindBy (xpath="//*[@id=\"resultTable\"]/tbody/tr/td")
    public WebElement noRecordsFoundText;

}
