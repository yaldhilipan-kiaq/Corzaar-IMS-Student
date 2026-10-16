package com.stepdefinitions;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.driver.DeviceSessionManager;
import com.pages.ProfilePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfileSteps extends BaseClass {

	ProfilePage profile = new ProfilePage(DeviceSessionManager.getDriver());

	@Given("User click Profile option")
	public void user_click_profile_option() {
		click(DeviceSessionManager.getDriver(), profile.profile);
	}

	@When("User Clicks Mark Curriculumn Progress")
	public void user_clicks_mark_curriculumn_progress() {
		swipeUp(DeviceSessionManager.getDriver());
		click(DeviceSessionManager.getDriver(), profile.markCurriculum1);

	}

	@When("User Clicks Customer Journey to complete the progress")
	public void user_clicks_customer_journey_to_complete_the_progress() {
		click(DeviceSessionManager.getDriver(), profile.customerJourney);
		click(DeviceSessionManager.getDriver(), profile.profile);
	}

	@When("User Clicks content system to complete the progress")
	public void user_clicks_content_system_to_complete_the_progress() {
		click(DeviceSessionManager.getDriver(), profile.contentSystem);
		click(DeviceSessionManager.getDriver(), profile.profile);
	}

	@When("User Clicks growth experiment to complete the progress")
	public void user_clicks_growth_experiment_to_complete_the_progress() {
		click(DeviceSessionManager.getDriver(), profile.growthExperiment);
		click(DeviceSessionManager.getDriver(), profile.profile);
	}

	@When("User verifys the course is completed")
	public void user_verifys_the_course_is_completed() {
		String actual = profile.CourseCompleted.getText();
		String expected = "active · 100% done";
		Assert.assertEquals(expected, actual);
	}

	@Then("User clicks sign out button")
	public void user_clicks_sign_out_button() {
		scrollToElementByText(DeviceSessionManager.getDriver(), "Sign out");
		click(DeviceSessionManager.getDriver(), profile.SignOut);
	}

}

//Training program 1234
