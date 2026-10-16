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

	@When("User enters Invalid Certificate ID")
	public void user_enters_invalid_certificate_id() {
		sendKeys(DeviceSessionManager.getDriver(), verify.IdInputField, "QQQQQ");
	}

	@When("user Clicks the Verify certificate button")
	public void user_clicks_the_verify_certificate_button() {
		click(DeviceSessionManager.getDriver(), verify.Verifybutton);
	}

	@Then("An Error message should be displayed for invalid certificate ID")
	public void an_error_message_should_be_displayed_for_invalid_certificate_id() {
		visibilityWait(DeviceSessionManager.getDriver(), verify.notVerified);
		String actual = verify.notVerified.getText();
		String expected = "Not verified";
		Assert.assertEquals(expected, actual);
	}

	@Given("User enters valid Certificate ID")
	public void user_enters_valid_certificate_id() {
		sendKeys(DeviceSessionManager.getDriver(), verify.IdInputField, "CZ-CERT-22B0538E");
	}

	@When("User Clicks the verify certificate button for valid ID")
	public void user_clicks_the_verify_certificate_button_for_valid_id() {
		click(DeviceSessionManager.getDriver(), verify.Verifybutton);
	}

	@When("A valid Certificate is found")
	public void a_valid_certificate_is_found() {
		visibilityWait(DeviceSessionManager.getDriver(), verify.ValidCertificate);
		String actual = verify.ValidCertificate.getText();
		String expected = "Valid certificate";
		Assert.assertEquals(expected, actual);
	}

	@Then("user navigate backs to home page")
	public void user_navigate_backs_to_home_page() {
		click(DeviceSessionManager.getDriver(), verify.back);
		visibilityWait(DeviceSessionManager.getDriver(), verify.signIn);
		String actual = verify.signIn.getText();
		String expected = "Sign in";
		Assert.assertEquals(expected, actual);
	}

}
