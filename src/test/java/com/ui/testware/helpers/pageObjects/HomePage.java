package com.ui.testware.helpers.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ui.testware.base.UiBaseSetup;

public class HomePage extends UiBaseSetup {
	WebDriver driver;
	WebElement element;
	WebDriverWait wait;

	public HomePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement signInLink() {
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login")));
		return element;
	}

	public WebElement logoutLink() {
		element = driver.findElement(By.className("logout"));
		return element;
	}

}
