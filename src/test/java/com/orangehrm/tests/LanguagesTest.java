package com.orangehrm.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.orangehrm.pages.LanguagesPage;
import com.orangehrm.utils.BrowserUtilities;


public class LanguagesTest extends TestBase{
	@Ignore
	@Test(dataProvider="addLanguages",dataProviderClass=DataproviderClass.class)

	public void verifyLanguages(String language1, String language2, String language3) throws InterruptedException, IOException{
	logger = reporter.createTest("Verify \"languages\"");
	LanguagesPage languagePage = new LanguagesPage();

	logger.info("Login and navigate to \"Admin\" main menu");
	BrowserUtilities.hover(languagePage.mainMenuAdmin);
	BrowserUtilities.hover(languagePage.menuQualifications);
	BrowserUtilities.waitFor(3);
	languagePage.subMenuLanguages.click();

	logger.info("Verify the URL contains \"Languages\"");
	Assert.assertTrue(driver.getCurrentUrl().contains("Languages"));

	logger.info("Verify the page's heading is \"Languages\"");
	Assert.assertTrue(languagePage.headingLanguages.getText().contains("Languages"));

	logger.info("Add the languages");

	String[] inputLanguages = {language1,language2,language3};

	List<String> resultLanguages = BrowserUtilities.getElementsText(languagePage.resultLanguages);

	logger.info("Verify languages are added to the table");
	for (String language : inputLanguages) {
	languagePage.buttonAdd.click();
	languagePage.fieldName.sendKeys(language);
	languagePage.buttonSave.click();
	BrowserUtilities.waitFor(3);
	resultLanguages = BrowserUtilities.getElementsText(languagePage.resultLanguages);
	Assert.assertTrue(resultLanguages.contains(language));
	}
	Assert.assertEquals(resultLanguages.size(), inputLanguages.length);

	logger.info("Verify languages are displayed in the alphabetical order");
	List<String> sorted = new ArrayList<>(resultLanguages);
	Collections.sort(sorted);
	Assert.assertEquals(resultLanguages,sorted);

	logger.info("Verify \"checkAll\" checkbox");
	languagePage.checkboxCheckAll.click();
	BrowserUtilities.waitFor(3);
	for (WebElement checkbox : languagePage.resultCheckboxes)  
	Assert.assertTrue(!checkbox.isSelected());
	BrowserUtilities.takeFullScreenshot("Clicked Check ALL");

	languagePage.checkboxCheckAll.click();
	BrowserUtilities.waitFor(3);
	for (WebElement checkbox : languagePage.resultCheckboxes)
	Assert.assertFalse(checkbox.isSelected());

	logger.info("Verify delete button");
	WebElement firstCheckbox = languagePage.resultCheckboxes.get(0);
	String firstElement = languagePage.firstLanguage.getText();
	if (!firstCheckbox.isSelected())
	firstCheckbox.click();
	languagePage.buttonDelete.click();
	BrowserUtilities.waitFor(3);
	resultLanguages = BrowserUtilities.getElementsText(languagePage.resultLanguages);
	Assert.assertFalse(resultLanguages.contains(firstElement));
	logger.pass("Verified \"languages\"");
	}

	@Test(dataProvider="addSkills",dataProviderClass=DataproviderClass.class)

	public void verifySkills(String skill1, String skill2, String skill3) throws InterruptedException, IOException{
	logger = reporter.createTest("Verify \"skills\"");
	LanguagesPage languagePage = new LanguagesPage();

	logger.info("Login and navigate to \"Admin\" main menu");
	BrowserUtilities.hover(languagePage.mainMenuAdmin);
	BrowserUtilities.hover(languagePage.menuQualifications);
	BrowserUtilities.waitFor(3);
	languagePage.subMenuSkills.click();

	logger.info("Verify the URL contains \"Skills\"");
	Assert.assertTrue(driver.getCurrentUrl().contains("Skills"));

	logger.info("Verify the page's heading is \"Skills\"");
	Assert.assertTrue(languagePage.headingLanguages.getText().contains("Skills"));

	logger.info("Add the skills");

	List<String> skills = new ArrayList<>(3);
	skills.add(skill1);
	skills.add(skill2);
	skills.add(skill3);

	logger.info("Verify skills are added to the table");
	JavascriptExecutor js = (JavascriptExecutor)driver;

	for (String skill : skills) {
	languagePage.buttonAdd.click();
	languagePage.fieldName2.sendKeys(skill);
	languagePage.buttonSave.click();
	BrowserUtilities.waitFor(3);
	BrowserUtilities.takeFullScreenshot("Successful message");
	Assert.assertTrue(languagePage.getSkill(skill).isDisplayed());

	languagePage.buttonAdd.click();
	languagePage.fieldName2.sendKeys(skill3);
	languagePage.buttonSave.click();
	BrowserUtilities.waitFor(3);
	Assert.assertEquals(languagePage.messageAlreadyExists.getText(),"Already exists");

	logger.pass("Verified \"skills\"");
	}

	}
}
