package com.stepdefinitions;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.driver.DeviceSessionManager;
import com.pages.SignInRemainderPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInRemainderSteps extends BaseClass {

	SignInRemainderPage sign = new SignInRemainderPage(DeviceSessionManager.getDriver());

	// APPLY COUPON WITHOUT
	// SIGNIN-----------------------------------------------------

	@Given("User is on the Home Page after SignOut")
	public void user_is_on_the_home_page_after_sign_out() {
		visibilityWait(DeviceSessionManager.getDriver(), sign.signIn);
		String actual = sign.signIn.getText();
		String expected = "Sign in";
		Assert.assertEquals(expected, actual);
	}

	@When("User clicks Course module")
	public void user_clicks_course_module() {
		click(DeviceSessionManager.getDriver(), sign.CoursesModule);
	}

	@When("User select a course to apply Coupon")
	public void user_select_a_course_to_apply_coupon() {
		click(DeviceSessionManager.getDriver(), sign.paymentCourse);
	}

	@When("User clicks Apply Coupon button")
	public void user_clicks_apply_coupon_button() {
		scrollToElementByText(DeviceSessionManager.getDriver(), "Apply");
		click(DeviceSessionManager.getDriver(), sign.applyCoupon);
	}

	@When("It remainds user needs to SignIn before apply Coupon")
	public void it_remainds_user_needs_to_sign_in_before_apply_coupon() {
		visibilityWait(DeviceSessionManager.getDriver(), sign.Student);
		String actual = sign.Student.getText();
		String expected = "Student";
		Assert.assertEquals(expected, actual);

		click(DeviceSessionManager.getDriver(), sign.closeButton);
	}

	@Then("User navigates back to Home Page")
	public void user_navigates_back_to_home_page() {
		scrollToElementByText(DeviceSessionManager.getDriver(), "Course details");
		click(DeviceSessionManager.getDriver(), sign.backtoHome);
	}

	// START PAYMENT WITHOUT
	// SIGNIN-----------------------------------------------------

	@Given("User is on the Home Page")
	public void user_is_on_the_home_page() {
		click(DeviceSessionManager.getDriver(), sign.home);
	}

	@When("User Clicks Course module to Initiate Payment")
	public void user_clicks_course_module_to_initiate_payment() {
		click(DeviceSessionManager.getDriver(), sign.CoursesModule);
	}

	@When("User selects a course to Initiate payment")
	public void user_selects_a_course_to_initiate_payment() {
		click(DeviceSessionManager.getDriver(), sign.paymentCourse);
	}

	@When("User Clicks Start Payment button")
	public void user_clicks_start_payment_button() {
		scrollToElementByTextContains(DeviceSessionManager.getDriver(), "Start payment");
		click(DeviceSessionManager.getDriver(), sign.StartPayment);
	}

	@When("It remainds user needs to signIn before start a payment")
	public void it_remainds_user_needs_to_sign_in_before_start_a_payment() {
		visibilityWait(DeviceSessionManager.getDriver(), sign.Student);
		String actual = sign.Student.getText();
		String expected = "Student";
		Assert.assertEquals(expected, actual);
	}

	@When("User close the Student Sign In portal")
	public void user_close_the_student_sign_in_portal() {
		click(DeviceSessionManager.getDriver(), sign.closeButton);
	}

	@Then("User navigates back")
	public void user_navigates_back() {
		scrollToElementByText(DeviceSessionManager.getDriver(), "Course details");
		click(DeviceSessionManager.getDriver(), sign.backtoHome);

	}

	// ADD FAVOURITES WITHOUT
	// SIGNIN-------------------------------------------------------

	@Given("User is on Course discover page")
	public void user_is_on_course_discover_page() {

	}

	@Given("User clicks Favourites button")
	public void user_clicks_favourites_button() {
		click(DeviceSessionManager.getDriver(), sign.Favourites);
	}

	@Given("It remainds user needs to signIn before adding to favourites")
	public void it_remainds_user_needs_to_sign_in_before_adding_to_favourites() {
		visibilityWait(DeviceSessionManager.getDriver(), sign.Student);
		String actual = sign.Student.getText();
		String expected = "Student";
		Assert.assertEquals(expected, actual);
	}

	@Given("User closes the student sign in button")
	public void user_closes_the_student_sign_in_button() {
		click(DeviceSessionManager.getDriver(), sign.closeButton);
	}

	@Then("User is on the homepage and signin option is visible")
	public void user_is_on_the_homepage_and_signin_option_is_visible() {
		click(DeviceSessionManager.getDriver(), sign.home);

		visibilityWait(DeviceSessionManager.getDriver(), sign.signIn);
		String actual = sign.signIn.getText();
		String expected = "Sign in";
		Assert.assertEquals(expected, actual);
	}

}
