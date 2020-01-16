package com.ui.testware.utility;

public class Constants {

	public static String BROWSER = "CHROME";
	public static String URL = "http://automationpractice.com/index.php";

	/* Browsers Driver */
	public static String MAC_CHROME_DRIVER_PATH = System.getProperty("user.dir") + "/drivers/mac/chromedriver";
	public static String MAC_GEKO_DRIVER_PATH = System.getProperty("user.dir") + "/drivers/mac/geckodriver";

	public static String WINDOWS_CHROME_DRIVER_PATH = System.getProperty("user.dir")
			+ "/drivers/windows/chromedriver.exe";
	public static String WINDOWS_GEKO_DRIVER_PATH = System.getProperty("user.dir") + "/drivers/windows/geckodriver.exe";

	public static int IMPLICIT_WAIT = 40;
	public static long TIME_OUT_IN_SECONDS = 50;
	public static long SLEEP_IN_MILLIS = 60;

	public static String SCREENSHOT_PATH = System.getProperty("user.dir") + "/report/screenShots/";
	public static String DATA_XLS_PATH = System.getProperty("user.dir") + "/data/TestData.xlsx";
	public static String TESTDATA_SHEET_UI = "TestDataUI";

	/* Extent Report Properties */
	public static String REPORTS_PATH = System.getProperty("user.dir") + "/report/htmlReports/";
	public static String REPORTS_NAME = "UI Automation Test Report";
	public static String DOCUMENT_TITLE = "UI Automation Test Report";

}