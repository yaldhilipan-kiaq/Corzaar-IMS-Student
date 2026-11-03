package com.stepdefinitions;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.driver.DeviceSessionManager;
import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps extends BaseClass {

	LoginPage log = new LoginPage(DeviceSessionManager.getDriver());

	@Given("Corzaar IMS  application is Launched")
	public void corzaar_ims_application_is_launched() {
		relaunchApp(DeviceSessionManager.getDriver());
	}

	@When("User taps the SignIn button")
	public void user_taps_the_sign_in_button() {
		click(DeviceSessionManager.getDriver(), log.signIn);
	}

	@When("User enters mobile number {string}")
	public void user_enters_mobile_number(String string) {
		sendKeys(DeviceSessionManager.getDriver(), log.mobileNumber, string);
	}

	@When("User clicks Continue with OTP button")
	public void user_clicks_continue_with_otp_button() {
		click(DeviceSessionManager.getDriver(), log.continueWithOTP);
	}

	@Then("User should be on the {string}")
	public void user_should_be_on_the(String expectedpage) {
		if (expectedpage.equals("mobilenumber")) {
			visibilityWait(DeviceSessionManager.getDriver(), log.EnterOTPCode);
			String actual = log.EnterOTPCode.getText();
			String expected = "Enter the 6-digit code sent to +91 1234512345.";

			Assert.assertEquals(expected, actual);
		} else {
			visibilityWait(DeviceSessionManager.getDriver(), log.Student);
			String actual = log.Student.getText();
			String expected = "Student";

			Assert.assertEquals(expected, actual);
		}
	}

	@Given("User is on the OTP Verification Page")
	public void user_is_on_the_otp_verification_page() {
		visibilityWait(DeviceSessionManager.getDriver(), log.OTPField);
	}

	@When("User enters the OTP number {string}")
	public void user_enters_the_otp_number(String string) {
		otpSendKeys(DeviceSessionManager.getDriver(), log.OTPField, string);
	}

	@When("User clicks the Verify and Continue button")
	public void user_clicks_the_verify_and_continue_button() {
		click(DeviceSessionManager.getDriver(), log.VerifyandContinue);
	}

	@Then("User should be on  {string}")
	public void user_should_be_on(String expectedPage) {
		if (expectedPage.equals("otp")) {
			visibilityWait(DeviceSessionManager.getDriver(), log.Student);
			String actual = log.Student.getText();
			String expected = "Student";

			Assert.assertEquals(expected, actual);

		} else {
			visibilityWait(DeviceSessionManager.getDriver(), log.Profiletext);
			String actual = log.Profiletext.getText();
			String expected = "Profile";

			Assert.assertEquals(expected, actual);
		}

	}

}
