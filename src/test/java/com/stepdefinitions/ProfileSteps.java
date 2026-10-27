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

	// PROFILE FIELD
	// EMPTY-------------------------------------------------------------

	@Given("User verifies the Profile name before completion")
	public void user_verifies_the_profile_name_before_completion() {
		visibilityWait(DeviceSessionManager.getDriver(), profile.profile);
		click(DeviceSessionManager.getDriver(), profile.profile);
	}

	@When("user leaves the profile name empty")
	public void user_leaves_the_profile_name_empty() {
		sendKeys(DeviceSessionManager.getDriver(), profile.profileName, "");
	}

	@When("user leaves the profile email empty")
	public void user_leaves_the_profile_email_empty() {
		sendKeys(DeviceSessionManager.getDriver(), profile.profileEmail, "");
	}

	@When("User clicks the save profile")
	public void user_clicks_the_save_profile() {
		click(DeviceSessionManager.getDriver(), profile.SaveProfile);
	}

	@Then("Complete your profile is displayed")
	public void complete_your_profile_is_displayed() {
		visibilityWait(DeviceSessionManager.getDriver(), profile.incompleteProfile);
		String actual = getText(DeviceSessionManager.getDriver(), profile.incompleteProfile);

		Assert.assertEquals("Complete your profile", actual);
	}

	// PROFILE
	// COMPLETE------------------------------------------------------------------

	@Given("User enters {string} in profile name field")
	public void user_enters_in_profile_name_field(String string) {
		sendKeys(DeviceSessionManager.getDriver(), profile.profileName, string);
	}

	@When("User enters {string} in profile email field")
	public void user_enters_in_profile_email_field(String string) {
		sendKeys(DeviceSessionManager.getDriver(), profile.profileEmail, string);
	}

	@When("User Clicks Save profile button")
	public void user_clicks_save_profile_button() {
		click(DeviceSessionManager.getDriver(), profile.SaveProfile);
	}

	@Then("The profile name is changed successfully")
	public void the_profile_name_is_changed_successfully() {
		visibilityWait(DeviceSessionManager.getDriver(), profile.completedProfile);
		String actual = getText(DeviceSessionManager.getDriver(), profile.completedProfile);

		Assert.assertEquals("NEW STUDENT", actual);
	}

	// REFRRAL CODE
	// ---------------------------------------------------------------------------

	@Given("User clicks Referal option")
	public void user_clicks_referal_option() {
		click(DeviceSessionManager.getDriver(), profile.wallet);
	}

	@When("User verifies the Referral code")
	public void user_verifies_the_referral_code() {
		visibilityWait(DeviceSessionManager.getDriver(), profile.referalCode);
		String actual = getText(DeviceSessionManager.getDriver(), profile.referalCode);

		Assert.assertEquals("REF9D150ABE", actual);
	}

	@When("user clicks back button")
	public void user_clicks_back_button() {
		click(DeviceSessionManager.getDriver(), profile.ReferalBack);
	}

	@Then("User navigates back to profile")
	public void user_navigates_back_to_profile() {

	}

//MARK CURRICULUMN -----------------------------------------------------------------

	@Given("User click Profile option")
	public void user_click_profile_option() {

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
		String actual = getText(DeviceSessionManager.getDriver(), profile.CourseCompleted);

		Assert.assertEquals("active · 100% done", actual);
	}

	@When("User Verifies view Certificate")
	public void user_verifies_view_certificate() {
		Assert.assertTrue("Button is clickable", profile.CertificateView.isDisplayed());
	}

	@When("user verfiies Download pdf")
	public void user_verfiies_download_pdf() {
		Assert.assertTrue("Button is clickable", profile.DownloadPDF.isDisplayed());
	}

	@Then("User clicks sign out button")
	public void user_clicks_sign_out_button() {
		scrollToElementByText(DeviceSessionManager.getDriver(), "Sign out");
		click(DeviceSessionManager.getDriver(), profile.SignOut);
	}

}

//Training program 1234
