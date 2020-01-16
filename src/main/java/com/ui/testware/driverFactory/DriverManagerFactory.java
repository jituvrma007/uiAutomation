package com.ui.testware.driverFactory;

public class DriverManagerFactory {

	public static DriverManager getManager(DriverType type) {

		DriverManager driverManager = null;

		switch (type) {
		case CHROME:
			driverManager = new ChromeDriverManager();
			break;

		case FIREFOX:
			driverManager = new FireFoxDriverManager();
			break;

		default:
			driverManager = new ChromeDriverManager();

		}
		return driverManager;
	}
}