package com.ui.testware.driverFactory;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.ui.testware.utility.CommonHelperMethods;

public class ChromeDriverManager extends DriverManager {

    private ChromeDriverService chromeDriverService;
    
    @Override
    public void startService() {
        if (null == chromeDriverService) {

        	try {
            	
                chromeDriverService = new ChromeDriverService.Builder()
                		.usingDriverExecutable(new File(CommonHelperMethods.getBrowserTpeDependingOnOS(DriverType.CHROME)))
                		.usingAnyFreePort().build();
                chromeDriverService.start();
            	
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stopService() {
        if (null != chromeDriverService && chromeDriverService.isRunning())
            chromeDriverService.stop();
    }

    @Override
    public void createDriver() {
    	System.setProperty("webdriver.chrome.driver", CommonHelperMethods.getBrowserTpeDependingOnOS(DriverType.CHROME));
    	driver = new ChromeDriver(chromeDriverService);
    	driver.manage().window().fullscreen();
    }

}