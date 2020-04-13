package com.orangehrm.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.orangehrm.pages.LanguagesPage;
import com.orangehrm.utils.BrowserUtilities;

public class LanguagesTest extends TestBase{
	
	LanguagesPage languagePage = new LanguagesPage();
	SoftAssert softAssert = new SoftAssert();
	
	@Test(dataProvider="addLanguages",dataProviderClass=DataproviderClass.class)
	
	public void verifyLanguages(String language1, String language2, String language3, String language4) throws InterruptedException, IOException{
		logger = reporter.createTest("Verify \"languages\"");
		
		logger.info("Login and navigate to \"Admin\" main menu");
		BrowserUtilities.hover(languagePage.mainMenuAdmin);
		BrowserUtilities.hover(languagePage.menuQualifications);
		languagePage.subMenuLanguages.click();
				
		logger.info("Verify the URL contains \"Languages\"");
		Assert.assertTrue(driver.getCurrentUrl().contains("Languages"));
		
		logger.info("Verify the page's heading is \"Languages\"");
		Assert.assertTrue(languagePage.headingLanguages.getText().contains("Languages"));
		
		logger.info("Add the languages");
		
		String[] inputLanguages = {language1,language2,language3,language4};
		
		List<String> resultLanguages = BrowserUtilities.getElementsText(languagePage.resultLanguages);
				
		logger.info("Verify languages are added to the table");
		for (String language : inputLanguages) {
			languagePage.buttonAdd.click();
			languagePage.fieldName.sendKeys(language);
			languagePage.buttonSave.click();	
			Assert.assertTrue(resultLanguages.contains(language));
		}		
		Assert.assertEquals(resultLanguages.size(), inputLanguages.length);
		
		logger.info("Verify languages are displayed in the alphabetical order");
		List<String> sorted = new ArrayList<>(resultLanguages);
		Collections.sort(sorted);
		Assert.assertEquals(resultLanguages,sorted);
		
		//First failer
		logger.info("Verify \"checkAll\" checkbox");
		languagePage.checkboxCheckAll.click();
		for (WebElement checkbox : languagePage.resultCheckboxes)  
			Assert.assertTrue(checkbox.isSelected());
		BrowserUtilities.takeFullScreenshot("Clicked Check ALL");
		
		languagePage.checkboxCheckAll.click();
		for (WebElement checkbox : languagePage.resultCheckboxes) 
			Assert.assertFalse(checkbox.isSelected());
		BrowserUtilities.takeFullScreenshot("Clicked Check ALL again");
		
		//Second failer
		logger.info("Verify delete button");
		WebElement firstElement = languagePage.resultLanguages.get(0);
		WebElement firstCheckbox = languagePage.resultCheckboxes.get(0);
		if (!firstCheckbox.isSelected())
			firstCheckbox.click();
		languagePage.buttonDelete.click();
		Assert.assertFalse(resultLanguages.contains(firstElement.getText()));
		
	}

}
