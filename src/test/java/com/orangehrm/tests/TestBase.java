package com.orangehrm.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.orangehrm.pages.AddEntitlementsPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.BrowserUtilities;
import com.orangehrm.utils.ConfigReader;
import com.orangehrm.utils.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class TestBase {
	
protected WebDriver driver;
protected Actions actions;
protected static ExtentReports reporter;
protected static ExtentSparkReporter htmlreporter;
protected static ExtentTest logger;

	
	@BeforeSuite (alwaysRun = true)
	public void setUpSuite() {
		reporter = new ExtentReports();
		String path = System.getProperty("user.dir") + "/test-output/extentReports/index.html";
		htmlreporter = new ExtentSparkReporter(path);
		htmlreporter.config().setReportName("OrangeHRM Automation Tests");
		//htmlreporter.config().setTheme(Theme.DARK);
		
		reporter.attachReporter(htmlreporter);
		
		reporter.setSystemInfo("Tester", "Team Delta");
		reporter.setSystemInfo("Environment", "Staging/Pre-production");
		reporter.setSystemInfo("OS", System.getProperty("os.name"));
		reporter.setSystemInfo("browser", ConfigReader.getConfiguration("browser"));
		}
	
	
	
	@BeforeMethod (alwaysRun = true)
	@Parameters ("browser")
	public void setUp (@Optional String browser) {
		driver = Driver.getDriver(browser);
		actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(
				ConfigReader.getConfiguration("implicitTimeout")), TimeUnit.SECONDS);
		driver.navigate().to(ConfigReader.getConfiguration("url"));
		LoginPage loginPage = new LoginPage();
		loginPage.positiveLogin();
		BrowserUtilities.waitFor(3);
		
	}
	
	
	@AfterMethod (alwaysRun = true)
	public void tearDown(ITestResult testResult) throws IOException {
		
		if(testResult.getStatus() == ITestResult.FAILURE) {
			logger.fail("FAILED test case: " + testResult.getName());
			logger.fail(testResult.getThrowable());
			String imagePath = BrowserUtilities.getScreenshot(testResult.getName());
			logger.addScreenCaptureFromPath(imagePath);
			
			
		}else if(testResult.getStatus() == ITestResult.SKIP) {
			logger.skip("SKIPPED test case: " + testResult.getName());
			logger.skip(testResult.getThrowable());
		}
		
		
		
		Driver.closeDriver();
	}
	
	
	@AfterSuite (alwaysRun = true)
	
	public void tearDownSuite() {
		reporter.flush();
	}

}
