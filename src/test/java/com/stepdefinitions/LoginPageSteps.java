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

	// INVALID MOBILE NUMBER

	@Given("Corzaar application is launched")
	public void corzaar_application_is_launched() {

	}

	@When("User taps SignIn button")
	public void user_taps_sign_in_button() {
		click(DeviceSessionManager.getDriver(), log.signIn);
	}

	@When("User enters  invalid mobile number")
	public void user_enters_invalid_mobile_number() {
		sendKeys(DeviceSessionManager.getDriver(), log.mobileNumber, "12345");
	}

	@When("User clicks the continue with otp button")
	public void user_clicks_the_continue_with_otp_button() {
		click(DeviceSessionManager.getDriver(), log.continueWithOTP);
		visibilityWait(DeviceSessionManager.getDriver(), log.continueWithOTP);
		String actual = log.continueWithOTP.getText();
		String expected = "Continue with OTP";

		Assert.assertEquals(expected, actual);

	}

	@Then("User should remain on the student login page")
	public void user_should_remain_on_the_student_login_page() {
		visibilityWait(DeviceSessionManager.getDriver(), log.Student);
		String actual = log.Student.getText();
		String expected = "Student";

		Assert.assertEquals(expected, actual);
	}

	// VALID MOBILE
	// NUMBER-------------------------------------------------------------------

	@Given("User is on the Student login page")
	public void user_is_on_the_student_login_page() {

	}

	@When("User enters  valid mobile number")
	public void user_enters_valid_mobile_number() {
		sendKeys(DeviceSessionManager.getDriver(), log.mobileNumber, "1234512345");
	}

	@When("User clicks the continue with otp button to generate otp")
	public void user_clicks_the_continue_with_otp_button_to_generate_otp() {
		click(DeviceSessionManager.getDriver(), log.continueWithOTP);
	}

	@Then("User should naviagtes to otp verification page")
	public void user_should_naviagtes_to_otp_verification_page() {
		visibilityWait(DeviceSessionManager.getDriver(), log.EnterOTPCode);
		String actual = log.EnterOTPCode.getText();
		String expected = "Enter the 6-digit code sent to +91 1234512345.";

		Assert.assertEquals(expected, actual);
	}

//INVALID OTP---------------------------------------------------------------------------

	@Given("User is on the OTP Verification Page")
	public void user_is_on_the_otp_verification_page() {

	}

	@When("User enters  Invalid OTP number")
	public void user_enters_invalid_otp_number() {
		otpSendKeys(DeviceSessionManager.getDriver(), log.OTPField, "123");
	}

	@When("User clicks the Verify and Continu button")
	public void user_clicks_the_verify_and_continu_button() {
		// clickableWait(DeviceSessionManager.getDriver(), log.VerifyandContinue);
		boolean enabled = log.VerifyandContinue.isEnabled();
		Assert.assertTrue("button is Enabled", enabled);

		click(DeviceSessionManager.getDriver(), log.VerifyandContinue);

	}

	@Then("User should Remain on the Otp Verification page")
	public void user_should_remain_on_the_otp_verification_page() {
//		visibilityWait(DeviceSessionManager.getDriver(), log.EnterOTPCode);
//		String actual = log.EnterOTPCode.getText();
//		String expected = "Enter the 6-digit code sent to +91 1234512345.";
//
//		Assert.assertEquals(expected, actual);
	}

	// VALID
	// OTP----------------------------------------------------------------------

	@Given("User is on the OTP Verification Page after entering invalid otp")
	public void user_is_on_the_otp_verification_page_after_entering_invalid_otp() {

	}

	@When("User enters  valid OTP number")
	public void user_enters_valid_otp_number() {
		otpSendKeys(DeviceSessionManager.getDriver(), log.OTPField, "123456");
	}

	@When("User clicks the Verify and Continu button for successful login")
	public void user_clicks_the_verify_and_continu_button_for_successful_login() {
		click(DeviceSessionManager.getDriver(), log.VerifyandContinue);
	}

	@Then("User should Logged in Successfully")
	public void user_should_logged_in_successfully() {
		visibilityWait(DeviceSessionManager.getDriver(), log.Profiletext);
		String actual = log.Profiletext.getText();
		String expected = "Profile";

		Assert.assertEquals(expected, actual);
	}

}
