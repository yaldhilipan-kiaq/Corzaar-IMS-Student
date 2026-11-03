package com.stepdefinitions;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.driver.DeviceSessionManager;
import com.pages.InstitutesPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InstituteSteps extends BaseClass {

	InstitutesPage institute = new InstitutesPage(DeviceSessionManager.getDriver());

	@Given("User is on home page to view the institutes")
	public void user_is_on_home_page_to_view_the_institutes() {
		visibilityWait(DeviceSessionManager.getDriver(), institute.corzaar);
		String actual = getText(DeviceSessionManager.getDriver(), institute.corzaar);

		Assert.assertEquals("CORZAAR", actual);
	}

	@When("User Clicks the Institute module to view all the institutes")
	public void user_clicks_the_institute_module_to_view_all_the_institutes() {
		click(DeviceSessionManager.getDriver(), institute.InstitutesModule);
	}

	@When("User should navigate to Institute page")
	public void user_should_navigate_to_institute_page() {
		visibilityWait(DeviceSessionManager.getDriver(), institute.allCourseText);

		Assert.assertFalse("Institue Page is not visible", institute.allCourseText.isDisplayed());
	}

	@Then("User navigate back to homepage")
	public void user_navigate_back_to_homepage() {
		click(DeviceSessionManager.getDriver(), institute.back);

		visibilityWait(DeviceSessionManager.getDriver(), institute.signIn);
		String actual = getText(DeviceSessionManager.getDriver(), institute.signIn);

		Assert.assertEquals("Sign in", actual);
	}

}
