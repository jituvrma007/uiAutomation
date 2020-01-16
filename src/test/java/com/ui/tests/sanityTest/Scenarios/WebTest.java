package com.ui.tests.sanityTest.Scenarios;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.ui.testware.base.UiBaseSetup;
import com.ui.testware.helpers.pageObjects.DashBoardPage;
import com.ui.testware.helpers.pageObjects.HomePage;
import com.ui.testware.helpers.pageObjects.LoginPage;
import com.ui.testware.helpers.pageObjects.OrderSummaryPage;
import com.ui.testware.helpers.pageObjects.SignUpPage;

public class WebTest extends UiBaseSetup {

	@Test(dataProvider = "dataProvider", description = "Generate a new customer with all customer data")
	public void signInTest(Hashtable<String, String> data) {
		// Preconditions - Existing Customer.

		// Test steps
		HomePage homePage = new HomePage(driver, wait);
		click(homePage.signInLink());
		testSteps.log(Status.PASS, "Clicked on 'Sign in' link on HomePage (on the header)");
		log.info("Clicked on 'Sign in' link on HomePage (on the header)");

		LoginPage loginPage = new LoginPage(driver, wait, testSteps, log);
		type(loginPage.createNewUsernameEmailAddressInputBox(), common.generateRandomEmailAddress());
		testSteps.log(Status.PASS,
				"Filling Email address in email address input box - " + data.get("existingUserEmail"));
		log.info("Filling Email address in email address input box - " + data.get("existingUserEmail"));
		click(loginPage.createAnAccountButton());
		testSteps.log(Status.PASS, "Clicking on 'Create an account' button");
		log.info("Clicking on 'Create an account' button");
		stopTheScript(1);

		SignUpPage signUpPage = new SignUpPage(driver, wait);
		signUpPage.fillTheSignUpForm(data.get("gender"), data.get("passwd"), data.get("state"));
		testSteps.log(Status.PASS, "Filled all fields with correct relevant data");
		log.info("Filled all fields with correct relevant data");

		String fName = readValue(signUpPage.customerFirstname());
		String lName = readValue(signUpPage.customerLastname());
		click(signUpPage.submitAccount());
		stopTheScript(1);
		DashBoardPage dashBoardPage = new DashBoardPage(driver, wait, testSteps, log);

		// Assertions
		assertEquals(data.get("headingText"), readText(dashBoardPage.dashBoardText()));
		testSteps.log(Status.PASS, "heading text on the dashboard page is - " + data.get("headingText"));
		log.info("heading text on the dashboard page is - " + data.get("headingText"));

		assertTrue(readText(dashBoardPage.accountInfoText()).contains(data.get("account_info")));
		testSteps.log(Status.PASS, "account info text on the dashboard page is - " + data.get("account_info"));
		log.info("account info text on the dashboard page is - " + data.get("account_info"));

		assertTrue(isElementPresent(homePage.logoutLink()));
		testSteps.log(Status.PASS, "Log out link is available on HomePage (on the header)");
		log.info("Log out action is available on HomePage (on the header)");

		assertTrue(getPageURL().contains(data.get("urlContent")));
		testSteps.log(Status.PASS, "My account page(?controller=my-account) is opened in browser");
		log.info("My account page(?controller=my-account) is opened in browser");

		assertEquals(readText(dashBoardPage.fullNameUsername()), fName + " " + lName);
		testSteps.log(Status.PASS, "Proper username is shown in the header - " + fName + " " + lName);
		log.info("Proper username is shown in the header - " + fName + " " + lName);
	}

	@Test(dataProvider = "dataProvider", description = "Existing customer can 'Sign in' to application using credentials")
	public void logInTest(Hashtable<String, String> data) {

		// Preconditions - Existing Customer.

		// Test steps
		HomePage homePage = new HomePage(driver, wait);
		click(homePage.signInLink());
		testSteps.log(Status.PASS, "Clicked on 'Sign in' link on HomePage (on the header)");
		log.info("Clicked on 'Sign in' link on HomePage (on the header)");

		LoginPage loginPage = new LoginPage(driver, wait, testSteps, log);
		loginPage.doLogin(data.get("existingUserEmail"), data.get("existingUserPassword"));
		DashBoardPage dashBoardPage = new DashBoardPage(driver, wait, testSteps, log);
		stopTheScript(2);

		// Assertions
		assertEquals(data.get("headingText"), readText(dashBoardPage.dashBoardText()));
		testSteps.log(Status.PASS, "heading text on the dashboard page is - " + data.get("headingText"));
		log.info("heading text on the dashboard page is - " + data.get("headingText"));

		assertTrue(readText(dashBoardPage.accountInfoText()).contains(data.get("account_info")));
		testSteps.log(Status.PASS, "account info text on the dashboard page is - " + data.get("account_info"));
		log.info("account info text on the dashboard page is - " + data.get("account_info"));

		assertEquals(data.get("fullName"), readText(dashBoardPage.fullNameUsername()));
		testSteps.log(Status.PASS, "Proper username is shown in the header as - " + data.get("fullName"));
		log.info("Proper username is shown in the header as - " + data.get("fullName"));

		assertTrue(isElementPresent(homePage.logoutLink()));
		testSteps.log(Status.PASS, "Log out link is available on HomePage (on the header)");
		log.info("Log out action is available on HomePage (on the header)");

		assertTrue(getPageURL().contains(data.get("urlContent")));
		testSteps.log(Status.PASS, "My account page(?controller=my-account) is opened in browser");
		log.info("My account page(?controller=my-account) is opened in browser");

	}

	@Test(dataProvider = "dataProvider", description = "Existing customer can order product, verify order details on checkout")
	public void checkoutTest(Hashtable<String, String> data) {

		// Preconditions - Existing Customer.

		// Test steps
		HomePage homePage = new HomePage(driver, wait);
		click(homePage.signInLink());
		testSteps.log(Status.PASS, "Clicked on 'Sign in' link on HomePage (on the header)");
		log.info("Clicked on 'Sign in' link on HomePage (on the header)");

		LoginPage loginPage = new LoginPage(driver, wait, testSteps, log);
		loginPage.doLogin(data.get("existingUserEmail"), data.get("existingUserPassword"));

		DashBoardPage dashBoardPage = new DashBoardPage(driver, wait, testSteps, log);
		dashBoardPage.addToCartAndCheckoutProduct(data.get("linkOnMenu"), data.get("productDetails"),
				data.get("productSize"), data.get("productColour"));

		OrderSummaryPage orderSummaryPage = new OrderSummaryPage(driver, wait, testSteps, log);
		stopTheScript(2);
		orderSummaryPage.doFinalConfirmationCheckout();

		// Assertions
		assertEquals(data.get("headingText"), readText(dashBoardPage.dashBoardText()));
		testSteps.log(Status.PASS, "heading text on the dashboard page is - " + data.get("headingText"));
		log.info("heading text on the dashboard page is - " + data.get("headingText"));

		assertTrue(isElementPresent(dashBoardPage.shippingProcessConfirmation()));
		testSteps.log(Status.PASS, "Shipping confirmation is shown on the dashboard page");
		log.info("Shipping confirmation is shown on the dashboard page");

		assertTrue(isElementPresent(dashBoardPage.paymentProcessConfirmation()));
		testSteps.log(Status.PASS, "Payment confirmation is shown on the dashboard page");
		log.info("Payment confirmation is shown on the dashboard page");

		assertTrue(readText(dashBoardPage.orderStatus()).contains(data.get("orderStatus")));
		testSteps.log(Status.PASS, "Order status info on the dashboard page is - " + data.get("orderStatus"));
		log.info("Order status info on the dashboard page is - " + data.get("orderStatus"));

		assertTrue(getPageURL().contains(data.get("urlContent")));
		testSteps.log(Status.PASS, "My account page(controller=order-confirmation) is opened in browser");
		log.info("My account page(controller=order-confirmation) is opened in browser");

	}
}
