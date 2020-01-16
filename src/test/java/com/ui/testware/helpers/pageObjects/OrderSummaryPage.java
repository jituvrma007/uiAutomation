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

public class OrderSummaryPage extends UiBaseSetup {
	WebElement element;

	public OrderSummaryPage(WebDriver driver, WebDriverWait wait, ExtentTest testSteps, Logger log) {
		this.driver = driver;
		this.wait = wait;
		this.testSteps = testSteps;
		this.log = log;
	}

	public WebElement proceedToCheckoutButton() {
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']")));
		return element;
	}

	public WebElement processAddressButton() {
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("processAddress")));
		return element;
	}

	public WebElement tNcAgreeButton() {
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-cgv")));
		return element;
	}

	public WebElement shippingProceedToCheckoutButton() {
		element = driver.findElement(By.name("processCarrier"));
		return element;

	}

	public WebElement bankwire() {
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bankwire")));
		return element;
	}

	public WebElement finalConfirmationButton() {
		element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cart_navigation']/button")));
		return element;
	}

	public void doFinalConfirmationCheckout() {
		click(proceedToCheckoutButton());
		testSteps.log(Status.PASS, "Click on 'Proceed To Checkout' button to checkout");
		log.info("Click on 'Proceed To Checkout' button to checkout");

		click(processAddressButton());
		testSteps.log(Status.PASS, "Click on 'Proceed Address' button to checkout");
		log.info("Click on 'Proceed Address' button to checkout");

		click(tNcAgreeButton());
		testSteps.log(Status.PASS, "Clicked on 'Terms of service' checkbox to agree");
		log.info("Clicked on 'Terms of service' checkbox to agree");

		click(shippingProceedToCheckoutButton());
		testSteps.log(Status.PASS, "Click on 'Proceed To Checkout' button to checkout");
		log.info("Click on 'Proceed To Checkout' button to checkout");

		click(bankwire());
		testSteps.log(Status.PASS, "Click on payment method 'Pay by bank wire'");
		log.info("Click on payment method 'Pay by bank wire'");

		click(finalConfirmationButton());
		testSteps.log(Status.PASS, "Clicked on 'Final Confirmation button'");
		log.info("Clicked on 'Final Confirmation button'");

	}

}
