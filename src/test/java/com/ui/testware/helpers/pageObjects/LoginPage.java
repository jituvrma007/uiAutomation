package com.ui.testware.helpers.pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ui.testware.base.UiBaseSetup;

public class LoginPage extends UiBaseSetup {
	WebElement element;
	
	public LoginPage(WebDriver driver, WebDriverWait wait, ExtentTest testSteps, Logger log) {
		this.driver = driver;
		this.wait = wait;
		this.testSteps = testSteps;
		this.log = log;
	}

	public WebElement emailAddressUsernameInputBox() {
		element = driver.findElement(By.id("email"));
		return element;
	}

	public WebElement passwordInputBox() {
		element = driver.findElement(By.id("passwd"));
		return element;
	}

	public WebElement signInButton() {
		element = driver.findElement(By.id("SubmitLogin"));
		return element;
	}

	public WebElement createNewUsernameEmailAddressInputBox() {
		element = driver.findElement(By.id("email_create"));
		return element;
	}

	public WebElement createAnAccountButton() {
		element = driver.findElement(By.id("SubmitCreate"));
		return element;
	}

	public void doLogin(String existingUserEmail, String existingUserPassword) {

		type(emailAddressUsernameInputBox(), existingUserEmail);
		testSteps.log(Status.PASS, "Filling Email address in email address input box - " + existingUserEmail);
		log.info("Filling Email address in email address input box - " + existingUserEmail);

		type(passwordInputBox(), existingUserPassword);
		testSteps.log(Status.PASS, "Filling Password in password input box - " + existingUserPassword);
		log.info("Filling Password in password input box - " + existingUserPassword);

		click(signInButton());
		testSteps.log(Status.PASS, "Clicked on 'Sign in' button");
		log.info("Clicked on 'Sign in' button");
	}

}
