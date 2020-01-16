package com.ui.testware.base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ui.testware.driverFactory.DriverManager;
import com.ui.testware.driverFactory.DriverManagerFactory;
import com.ui.testware.driverFactory.DriverType;
import com.ui.testware.utility.CommonHelperMethods;
import com.ui.testware.utility.Constants;
import com.ui.testware.utility.ExtentManager;
import com.ui.testware.utility.SpreadSheetReader;

public class UiBaseSetup {

	public Logger log;

	public ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest testReport;
	public ExtentTest testSteps;

	public WebDriver driver;
	public WebDriverWait wait;
	public DriverManager driverManager;

	public CommonHelperMethods common = new CommonHelperMethods();

	public UiBaseSetup() {

	}

	public UiBaseSetup(WebDriver driver) {
		this.driver = driver;
	}

	public void type(WebElement locatorKey, String data) {
		locatorKey.sendKeys(data);
	}

	public void click(WebElement locatorKey) {
		locatorKey.click();
	}

	public String readText(WebElement locatorKey) {
		return locatorKey.getText();
	}

	public String readValue(WebElement locatorKey) {
		return locatorKey.getAttribute("value");
	}

	public String getPageURL() {
		return driver.getCurrentUrl();
	}

	public void selectValueFromDropDownByVisibleText(WebElement locator, String locatorValue) {
		Select selectDropDown = new Select(locator);
		selectDropDown.selectByVisibleText(locatorValue);
	}

	public void selectValueFromDropDownByValue(WebElement locator, String LocatorValue) {
		Select selectDropDown = new Select(locator);
		selectDropDown.selectByValue(LocatorValue);
	}

	public boolean isElementPresent(WebElement locator) {
		if (locator.isDisplayed())
			return true;
		else
			return false;
	}

	public void stopTheScript(int timeInSeconds) {
		timeInSeconds = timeInSeconds * 1000;
		try {
			Thread.sleep(timeInSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void writeTestReportStatus(ITestResult result) {
		if (result.isSuccess()) {
			testSteps.log(Status.PASS, "Test Pass");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			testSteps.log(Status.FAIL, "Test Failed");
			try {
				testSteps.addScreenCaptureFromPath(common.takeScreenShot(driver));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (result.getStatus() == ITestResult.SKIP) {
			testSteps.log(Status.SKIP, "Test Skipped");
		}
		if (extent != null) {
			extent.flush();
		}
	}

	public WebDriver testEnvironmentSetUp() {
		
		String browserType = System.getProperty("browser");
		String url = System.getProperty("url");
		
		if (browserType == null) {
			browserType = Constants.BROWSER;
		}
		if (url == null) {
			url = Constants.URL;
		}
		
		driverManager = DriverManagerFactory.getManager(DriverType.valueOf(browserType));
		driver = driverManager.getDriver();
		testSteps.log(Status.INFO, "Setup is done, Going to start Test Execution");
		log.info("Setup is done, Going to start Test Execution");

		driver.get(url);
		testSteps.log(Status.INFO, "Opening 'Home Page' !!");
		log.info("Opening 'Home Page' !!");

		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		return driver;
	}

	public WebDriverWait returnWaitObject(long timeOutTime, long sleepTime) {
		wait = new WebDriverWait(driver, Constants.TIME_OUT_IN_SECONDS, Constants.SLEEP_IN_MILLIS);
		return wait;
	}

	@BeforeSuite
	public void beforeSuite() {
		log = LogManager.getLogger(this.getClass());
		log.info("===============================================================");
		log.info("======= Starting UI TestCase Execution, Opening Browser =======");
		log.info("===============================================================");
	}

	@AfterSuite
	public void afterSuite() {
		log.info("===============================================================");
		log.info("======== Ending UI TestCase Execution, Closing Browser ========");
		log.info("===============================================================");
	}

	@BeforeClass()
	public void beforeClass() {
		testReport = extent.createTest(this.getClass().getSimpleName());
	}

	@BeforeMethod
	public void beforeMethod(Method method) {

		String testDescription = method.getAnnotation(Test.class).description();
		String methodName = method.getName();
		testReport.info(testDescription + "<br/> => " + methodName);
		testSteps = testReport.createNode(testDescription + " => " + methodName);
		driver = testEnvironmentSetUp();
		wait = returnWaitObject(Constants.TIME_OUT_IN_SECONDS, Constants.SLEEP_IN_MILLIS);
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		writeTestReportStatus(result);
		driverManager.quitDriver();
	}

	@DataProvider
	public Object[][] dataProvider(Method method) {
		SpreadSheetReader xls = new SpreadSheetReader();
		return xls.getData(method.getName());
	}

}