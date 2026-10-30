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

	@When("User enters  Certificate {string} ID")
	public void user_enters_certificate_id(String string) {
		sendKeys(DeviceSessionManager.getDriver(), verify.IdInputField, string);
	}

	@When("user Clicks the Verify certificate button")
	public void user_clicks_the_verify_certificate_button() {
		click(DeviceSessionManager.getDriver(), verify.Verifybutton);
	}

	@When("A Certificate is found")
	public void a_certificate_is_found() {

	}

	@Then("user navigate backs to home page")
	public void user_navigate_backs_to_home_page() {
		click(DeviceSessionManager.getDriver(), verify.back);
		visibilityWait(DeviceSessionManager.getDriver(), verify.signIn);
		String actual = getText(DeviceSessionManager.getDriver(), verify.signIn);

		Assert.assertEquals("Sign in", actual);
	}
//	visibilityWait(DeviceSessionManager.getDriver(), verify.notVerified);
//	String actual = getText(DeviceSessionManager.getDriver(), verify.notVerified);
//
//	Assert.assertEquals("Not verified", actual);
//
//	visibilityWait(DeviceSessionManager.getDriver(), verify.ValidCertificate);
//
//	String actual = getText(DeviceSessionManager.getDriver(), verify.ValidCertificate);
//
//	Assert.assertEquals("Valid certificate", actual);

}
