package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.Driver;

public class CustomFieldsPage {
	
	public CustomFieldsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id = "menu_pim_Configuration")
	 public WebElement configurationMenu;
	
	@FindBy(id = "menu_pim_listCustomFields")
	 public WebElement customFieldsMenu;
	
	@FindBy(tagName = "h1")
	public WebElement addCustomFieldHeader;
	
	@FindBy(id = "customField_name")
	 public WebElement fieldNameField;
	
	@FindBy(id = "customField_screen")
	 public WebElement screenSelectField;
	
	@FindBy(id = "customField_type")
	 public WebElement typeSelectField;
	
	@FindBy(id = "customField_extra_data")
	 public WebElement selectOptionsField;
	
	@FindBy(id = "btnSave")
	 public WebElement saveButton;
	
	@FindBy(id = "buttonRemove")
	 public WebElement deleteButton;
	
	@FindBy(id = "buttonAdd")
	 public WebElement addButton;
	
	@FindBy(id = "fieldsleft")
	 public WebElement numOfRemainFields;
	
	@FindBy(id = "allCheck")
	 public WebElement checkAll;
	
	@FindBy(xpath = "//td[@class='fieldName']//a")
	public List<WebElement> addedCustomFieldNames;
	
		
	@FindBy(id = "dialogDeleteBtn")
	public WebElement alertOKButton;
	
		

}
