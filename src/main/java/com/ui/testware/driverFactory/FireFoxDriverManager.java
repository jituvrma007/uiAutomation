package com.ui.testware.driverFactory;

import java.io.File;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

import com.ui.testware.utility.CommonHelperMethods;

public class FireFoxDriverManager extends DriverManager {
	private GeckoDriverService firfoxDriverService;

	@Override
	public void startService() {
		if (null == firfoxDriverService) {
			try {
				firfoxDriverService = new GeckoDriverService.Builder()
						.usingDriverExecutable(
								new File(CommonHelperMethods.getBrowserTpeDependingOnOS(DriverType.FIREFOX)))
						.usingAnyFreePort().build();
				firfoxDriverService.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void stopService() {
		if (null != firfoxDriverService && firfoxDriverService.isRunning())
			firfoxDriverService.stop();
	}

	@Override
	public void createDriver() {
		System.setProperty("webdriver.gecko.driver",
				CommonHelperMethods.getBrowserTpeDependingOnOS(DriverType.FIREFOX));
//		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
//		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
		driver = new FirefoxDriver(firfoxDriverService);
		driver.manage().window().fullscreen();
	}

}
