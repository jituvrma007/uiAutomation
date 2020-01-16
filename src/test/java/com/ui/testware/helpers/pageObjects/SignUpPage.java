package com.ui.testware.helpers.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ui.testware.base.UiBaseSetup;

public class SignUpPage extends UiBaseSetup {

	WebDriver driver;
	WebElement element;
	WebDriverWait wait;

	public SignUpPage(WebDriver driver, WebDriverWait wait) {

		this.driver = driver;
		this.wait = wait;
	}

	public WebElement gender(String gender) {
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(gender)));
		return element;
	}

	public WebElement customerFirstname() {
		element = driver.findElement(By.id("customer_firstname"));
		return element;
	}

	public WebElement customerLastname() {
		element = driver.findElement(By.id("customer_lastname"));
		return element;
	}

	public WebElement passwd() {
		element = driver.findElement(By.id("passwd"));
		return element;
	}

	public WebElement dobDays() {
		element = driver.findElement(By.id("days"));
		return element;
	}

	public WebElement dobMonths() {
		element = driver.findElement(By.id("months"));
		return element;
	}

	public WebElement dobYears() {
		element = driver.findElement(By.id("years"));
		return element;
	}

	public WebElement newsletter() {
		element = driver.findElement(By.id("newsletter"));
		return element;
	}

	public WebElement optin() {
		element = driver.findElement(By.id("optin"));
		return element;
	}

	public WebElement company() {
		element = driver.findElement(By.id("company"));
		return element;
	}

	public WebElement address1() {
		element = driver.findElement(By.id("address1"));
		return element;
	}

	public WebElement address2() {
		element = driver.findElement(By.id("address2"));
		return element;
	}

	public WebElement city() {
		element = driver.findElement(By.id("city"));
		return element;
	}

	public WebElement State() {
		element = driver.findElement(By.id("id_state"));
		return element;
	}

	public WebElement postcode() {
		element = driver.findElement(By.id("postcode"));
		return element;
	}

	public WebElement other() {
		element = driver.findElement(By.id("other"));
		return element;
	}

	public WebElement homePhone() {
		element = driver.findElement(By.id("phone"));
		return element;
	}

	public WebElement mobilePhone() {
		element = driver.findElement(By.id("phone_mobile"));
		return element;
	}

	public WebElement alias() {
		element = driver.findElement(By.id("alias"));
		return element;
	}

	public WebElement submitAccount() {
		element = driver.findElement(By.id("submitAccount"));
		return element;
	}

	public WebElement account() {
		element = driver.findElement(By.className("account"));
		return element;
	}

	public WebElement info_account() {
		element = driver.findElement(By.className("info-account"));
		return element;
	}

	public void fillTheSignUpForm(String gender, String password, String state) {
		click(gender(gender.toLowerCase().equals("mr.") ? "uniform-id_gender1" : "uniform-id_gender2"));
		type(customerFirstname(), common.getRandomText(8));
		type(customerLastname(), common.getRandomText(8));
		type(passwd(), password);

		selectValueFromDropDownByValue(dobDays(), String.valueOf(common.getRandomInt(1, 28)));
		selectValueFromDropDownByValue(dobMonths(), String.valueOf(common.getRandomInt(1, 12)));
		selectValueFromDropDownByValue(dobYears(), String.valueOf(common.getRandomInt(1990, 2000)));
		click(newsletter());
		click(optin());

		type(company(), common.getRandomText(20));
		type(address1(), common.getRandomText(20));
		type(address2(), common.getRandomText(20));
		type(city(), common.getRandomText(10));
		selectValueFromDropDownByVisibleText(State(), state);
		type(postcode(), common.getRandomNumberOfDigits(5));
		type(other(), common.getRandomText(10));
		type(homePhone(), common.generateRandomMobileNumber());
		type(mobilePhone(), common.generateRandomMobileNumber());
		type(alias(), common.getRandomText(5));

	}

}
