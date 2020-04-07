package com.orangehrm.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends TestBase {
	
	@Test(enabled=false)
	public void loginPOMPattern() {
		logger = reporter.createTest("Positive Login Test");
		
		LoginPage loginPage = new LoginPage();
		logger.info("Logging in by entering the correct credentials");
		loginPage.positiveLogin();
		logger.info("Verifying the title contains \"OrangeHRM\"");
		
		Assert.assertTrue(driver.getTitle().contains("OrangeHRM"));
		
		logger.pass("Verified that the title contains \"OrangeHRM\"");
		
	}
	
	@Test(enabled=false)
	public void loginPOMPatternNegative() {
		logger = reporter.createTest("Negative Login Test");
		
		LoginPage loginPage = new LoginPage();
		logger.info("Entering the invalid credentials");

		loginPage.usernameField.sendKeys(new StringBuilder(ConfigReader.getConfiguration("usrname")).reverse().toString());
		loginPage.passwordField.sendKeys(new StringBuilder(ConfigReader.getConfiguration("password")).reverse().toString());
		logger.info("Clicking on login button");
		loginPage.loginButton.click();
		String expected = "Invalid credentials";
		String actual = loginPage.errorMessage.getText();
		logger.info("Verifying that the error message is \"Invalid credentials");
		Assert.assertEquals(actual, expected);
		
		logger.pass("Verified that the error message is Invalid credentials.");
	}
	
	@Test(enabled=false)
	public void loginFailingTest() {
		logger = reporter.createTest("Login Test with invalid credentials");
		
		LoginPage loginPage = new LoginPage();
		logger.info("Entering the invalid credentials");

		loginPage.usernameField.sendKeys(new StringBuilder(ConfigReader.getConfiguration("username")).reverse().toString());
		loginPage.passwordField.sendKeys(new StringBuilder(ConfigReader.getConfiguration("password")).reverse().toString());
		logger.info("Clicking on login button");

		loginPage.loginButton.click();
		logger.info("Verifying that the title is equal to \"OrangeHRM\"");

		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
		logger.pass("Verified that the  title is equal to\"OrangeHRM\"");
		
	}
	
	
		
}

	
	
	
	
	
	
	


