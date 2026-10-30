package com.stepdefinitions;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.driver.DeviceSessionManager;
import com.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps  extends BaseClass{
	
	HomePage home = new HomePage(DeviceSessionManager.getDriver());
	
	@Given("User Clicks Design to Search design related courses")
	public void user_clicks_design_to_search_design_related_courses() {
		//click(DeviceSessionManager.getDriver(), sign.CoursesModule);
	}

	@When("User Clicks the Search button")
	public void user_clicks_the_search_button() {
	    
	}

	@Then("It Shows design Related Courses")
	public void it_shows_design_related_courses() {
//		visibilityWait(DeviceSessionManager.getDriver(), sign.signIn);
//		String actual = getText(DeviceSessionManager.getDriver(), sign.signIn);
//
//		Assert.assertEquals("Sign in", actual);
	}
//------------------------------------------------------------------------------
	@Given("User Clicks Technology to Search design related courses")
	public void user_clicks_technology_to_search_design_related_courses() {
	    
	}

	@When("User Clicks the Search button for technology course")
	public void user_clicks_the_search_button_for_technology_course() {
	    
	}

	@Then("It Shows technology Related Courses")
	public void it_shows_technology_related_courses() {
	    
	}
}
