package com.stepdefinitions;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.driver.DeviceSessionManager;
import com.pages.CoursePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CoursePageSteps extends BaseClass {

	CoursePage course = new CoursePage(DeviceSessionManager.getDriver());

	@Given("User selects a Course to Enroll")
	public void user_selects_a_course_to_enroll() {
		click(DeviceSessionManager.getDriver(), course.FreeCourse);

	}

	@When("User Clicks Enroll button")
	public void user_clicks_enroll_button() {
		scrollToElementByText(DeviceSessionManager.getDriver(), "Enroll for free");
		// MobileswipeUp(DeviceSessionManager.getDriver());
		click(DeviceSessionManager.getDriver(), course.Enroll);
	}

	@When("User  verifies review input field")
	public void user_verifies_review_input_field() {
		scrollToElementByText(DeviceSessionManager.getDriver(), "What worked well? What can improve?");
		String actual = course.ReviewInput.getText();
		String expected = "What worked well? What can improve?";
		Assert.assertEquals(expected, actual);
	}

	@When("User verifies the Submit Review button")
	public void user_verifies_the_submit_review_button() {
		// MobileswipeUp(DeviceSessionManager.getDriver());
		scrollToElementByText(DeviceSessionManager.getDriver(), "Submit review");
		click(DeviceSessionManager.getDriver(), course.Submit);

	}

	@Then("User gets back to Profile To complete enrollment")
	public void user_gets_back_to_profile_to_complete_enrollment() {
		scrollToElementByText(DeviceSessionManager.getDriver(), "Course details");
		// MobileswipeDown(DeviceSessionManager.getDriver());
		click(DeviceSessionManager.getDriver(), course.backtoHome);
	}

}
