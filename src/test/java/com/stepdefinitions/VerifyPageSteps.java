package com.stepdefinitions;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.driver.DeviceSessionManager;
import com.pages.VerifyPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyPageSteps extends BaseClass {

	VerifyPage verify = new VerifyPage(DeviceSessionManager.getDriver());

	@Given("User is on the Home page")
	public void user_is_on_the_home_page() {

	}

	@When("User Clicks Verify Option to verify certificate")
	public void user_clicks_verify_option_to_verify_certificate() {
		click(DeviceSessionManager.getDriver(), verify.VerifyOption);
	}

	@When("User enters Invalid Certificate {string} ID")
	public void user_enters_invalid_certificate_id(String string) {
		sendKeys(DeviceSessionManager.getDriver(), verify.IdInputField, string);
	}

	@When("user Clicks the Verify certificate button")
	public void user_clicks_the_verify_certificate_button() {
		click(DeviceSessionManager.getDriver(), verify.Verifybutton);
	}

	@Then("An Error message should be displayed for invalid certificate ID")
	public void an_error_message_should_be_displayed_for_invalid_certificate_id() {
		visibilityWait(DeviceSessionManager.getDriver(), verify.notVerified);
		String actual = getText(DeviceSessionManager.getDriver(), verify.notVerified);

		Assert.assertEquals("Not verified", actual);

	}

	@Given("User enters valid Certificate {string} ID")
	public void user_enters_valid_certificate_id(String string) {
		sendKeys(DeviceSessionManager.getDriver(), verify.IdInputField, string);
	}

	@When("User Clicks the verify certificate button for valid ID")
	public void user_clicks_the_verify_certificate_button_for_valid_id() {
		click(DeviceSessionManager.getDriver(), verify.Verifybutton);
	}

	@When("A valid Certificate is found")
	public void a_valid_certificate_is_found() {
		visibilityWait(DeviceSessionManager.getDriver(), verify.ValidCertificate);

		String actual = getText(DeviceSessionManager.getDriver(), verify.ValidCertificate);

		Assert.assertEquals("Valid certificate", actual);

	}

	@Then("user navigate backs to home page")
	public void user_navigate_backs_to_home_page() {
		click(DeviceSessionManager.getDriver(), verify.back);
		visibilityWait(DeviceSessionManager.getDriver(), verify.signIn);
		String actual = getText(DeviceSessionManager.getDriver(), verify.signIn);

		Assert.assertEquals("Sign in", actual);
	}

}
