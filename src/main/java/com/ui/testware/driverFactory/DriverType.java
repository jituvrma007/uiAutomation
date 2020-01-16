package com.ui.testware.driverFactory;

public enum DriverType {
	CHROME("CH"),
	FIREFOX("FF");

	private String value;

	public String getValue() {
		return value;
	}

	DriverType(String value) {
		this.value = value;
	}

	public DriverType find(String value) {
		for (DriverType driver : DriverType.values()) {
			if (driver.value.equals(value))
				return driver;
		}
		return null;
	}
}