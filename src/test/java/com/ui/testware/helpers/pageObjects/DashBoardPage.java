package com.ui.testware.helpers.pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ui.testware.base.UiBaseSetup;

public class DashBoardPage extends UiBaseSetup {
	WebDriver driver;
	WebElement element;
	WebDriverWait wait;

	public DashBoardPage(WebDriver driver, WebDriverWait wait, ExtentTest testSteps, Logger log) {
		this.driver = driver;
		this.wait = wait;
		this.testSteps = testSteps;
		this.log = log;
	}

	public WebElement dashBoardText() {

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
		return element;
	}

	public WebElement fullNameUsername() {
		element = driver.findElement(By.className("account"));
		return element;
	}

	public WebElement accountInfoText() {
		element = driver.findElement(By.className("info-account"));
		return element;
	}

	public WebElement linkOnMenu(String menuLink) {

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(menuLink)));
		return element;
	}

	public WebElement productName(String productName) {
		element = driver.findElement(By.xpath("//a[@title='" + productName + "']/ancestor::li"));
		return element;
	}

	public WebElement productSize() {
		element = driver.findElement(By.cssSelector("#uniform-group_1 #group_1"));
		return element;
	}

	public WebElement productColour(String productColour) {
		element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[@title='" + productColour + "']/ancestor::li")));
		return element;
	}

	public WebElement addToCartButton() {
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Submit")));
		return element;
	}

	public WebElement proceedTocheckoutButton() {
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']")));
		return element;
	}

	public WebElement shippingProcessConfirmation() {
		element = driver.findElement(By.xpath("//li[@class='step_done step_done_last four']"));
		return element;
	}

	public WebElement paymentProcessConfirmation() {

		element = driver.findElement(By.xpath("//li[@id='step_end' and @class='step_current last']"));
		return element;
	}

	public WebElement orderStatus() {
		element = driver.findElement(By.xpath("//*[@class='cheque-indent']/strong"));
		return element;
	}

	public void addToCartAndCheckoutProduct(String linkOnMenu, String productDetails, String productSize,
			String productColour) {
		click(linkOnMenu(linkOnMenu));
		testSteps.log(Status.PASS, "Clicked 'Women' button in the menu header");
		log.info("Clicked 'Women' button in the menu header");
		stopTheScript(2);

		click(productName(productDetails));
		testSteps.log(Status.PASS, "Click the product with name - " + productDetails);
		log.info("Click the product with name - " + productDetails);

		click(productName(productDetails));
		testSteps.log(Status.PASS, "Click the product with name - " + productDetails);
		log.info("seocnd Click the product with name - " + productDetails);

		selectValueFromDropDownByVisibleText(productSize(), productSize);
		testSteps.log(Status.PASS, "Changing the size of the product to " + productSize);
		log.info("Changing the size of the product to " + productSize);
		stopTheScript(1);

		click(productColour(productColour));
		testSteps.log(Status.PASS, "Changing the colour of the product to " + productColour);
		log.info("Changing the colour of the product to " + productColour);
		stopTheScript(2);

		click(addToCartButton());
		testSteps.log(Status.PASS, "Added the product with name 'Faded Short Sleeve T-shirts' to cart ");
		log.info("Added the product with name 'Faded Short Sleeve T-shirts' to cart ");

		click(proceedTocheckoutButton());
		testSteps.log(Status.PASS, "Click on 'Proceed To Checkout' button to checkout");
		log.info("Click on 'Proceed To Checkout' button to checkout");
	}

}