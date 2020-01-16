package com.ui.testware.utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.ui.testware.driverFactory.DriverType;

public class CommonHelperMethods {

	public String takeScreenShot(WebDriver driver) {

		File file = new File(Constants.SCREENSHOT_PATH);
		if (!file.exists()) {
			file.mkdirs();
		}

		Date date = new Date();
		String screenShotFile = date.toString().replace(":", "_").replace(" ", "_") + ".png";
		String screenShotPath = Constants.SCREENSHOT_PATH + screenShotFile;

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(screenShotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenShotPath;
	}
	
		public void fetchCommandLineArgs()
	    {
			if (System.getProperty("url")!= null)
			{
				
			}
			
	    }
	

	public static String getBrowserTpeDependingOnOS(DriverType Type) {
		String osName = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
		if (osName.contains("windows")) {
			if (Type == DriverType.CHROME)
				return Constants.WINDOWS_CHROME_DRIVER_PATH;
			else if (Type == DriverType.FIREFOX)
				return Constants.WINDOWS_GEKO_DRIVER_PATH;
		} else if (osName.contains("mac")) {
			if (Type == DriverType.CHROME)
				return Constants.MAC_CHROME_DRIVER_PATH;
			else if (Type == DriverType.FIREFOX)
				return Constants.MAC_GEKO_DRIVER_PATH;

		}

		return Constants.MAC_CHROME_DRIVER_PATH;

	}

	public String generateRandomEmailAddress() {
		String timestamp = String.valueOf(new Date().getTime());
		String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
		return email;
	}

	public String generateRandomMobileNumber() {
		Random r = new Random();
		int low = 7;
		int high = 9;

		int i1 = r.nextInt(high - low) + low;
		int i2 = r.nextInt(8);
		int i3 = r.nextInt(8);
		int i4 = r.nextInt(742); // returns random number between 0 and 741
		int i5 = r.nextInt(10000); // returns random number between 0 and 9999

		String phoneNumber = String.format("+91%d%d%d%03d%04d", i1, i2, i3, i4, i5);
		return phoneNumber;
	}

	public String getRandomText(int length) {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = length;
		Random random = new Random();

		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + random.nextInt(rightLimit - leftLimit + 1);
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();
		return generatedString;
	}

	public int getRandomInt(int low, int high) {
		Random r = new Random();
		return r.nextInt(high - low) + low;
	}

	public String getRandomNumberOfDigits(int length) {
		char[] chars = "123456789".toCharArray();
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++)
			sb.append(chars[rnd.nextInt(chars.length)]);

		return sb.toString();
	}
}
