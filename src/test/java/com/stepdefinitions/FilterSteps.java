package com.stepdefinitions;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.driver.DeviceSessionManager;
import com.pages.FilterPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterSteps extends BaseClass {

	FilterPage filter = new FilterPage(DeviceSessionManager.getDriver());

//VALID COURSE THROUGH SEARCH --------------------------------------------------------

	@Given("User Clicks course option to search course")
	public void user_clicks_course_option_to_search_course() {
		click(DeviceSessionManager.getDriver(), filter.CoursesOption);
	}

	@When("User enters Valid Course {string} name")
	public void user_enters_valid_course_name(String string) {
		sendKeys(DeviceSessionManager.getDriver(), filter.SearchBox, string);
	}

	@When("User Clicks the Search button for valid course")
	public void user_clicks_the_search_button_for_valid_course() {
		click(DeviceSessionManager.getDriver(), filter.SearchApply);
	}

	@Then("Valid Course is displayed")
	public void valid_course_is_displayed() {
		visibilityWait(DeviceSessionManager.getDriver(), filter.ChemicalCourse);
		String actual = getText(DeviceSessionManager.getDriver(), filter.ChemicalCourse);

		Assert.assertEquals("Chemical Course ", actual);
	}

	// INVALID COURSE THROUGH
	// SEARCH--------------------------------------------------
	@Given("User enters InValid Course {string} name")
	public void user_enters_in_valid_course_name(String string) {
		sendKeys(DeviceSessionManager.getDriver(), filter.SearchBox, string);
	}

	@When("User apply the search to check the courses")
	public void user_apply_the_search_to_check_the_courses() {
		click(DeviceSessionManager.getDriver(), filter.SearchApply);
	}

	@Then("No  Course should be displayed")
	public void no_course_should_be_displayed() {
		visibilityWait(DeviceSessionManager.getDriver(), filter.ChemicalCourse);

		Assert.assertFalse("Course is displayed for an Invalid search", filter.ChemicalCourse.isDisplayed());
	}

	// FAVOURITES
	// --------------------------------------------------------------------

	@Given("User is on the Course page")
	public void user_is_on_the_course_page() {

	}

	@Given("User Click the Favourites button to add course")
	public void user_click_the_favourites_button_to_add_course() {
		click(DeviceSessionManager.getDriver(), filter.Favourites);
	}

	@Then("The Course is added in favourites")
	public void the_course_is_added_in_favourites() {
		visibilityWait(DeviceSessionManager.getDriver(), filter.Favouritesadded);
		Assert.assertTrue("Course is added to favourites", filter.Favouritesadded.isDisplayed());
	}

	// CATEGORY-------------------------------------------------------------------------

	@Given("User clicks the Filter & Sort option to select category")
	public void user_clicks_the_filter_sort_option_to_select_category() {
		click(DeviceSessionManager.getDriver(), filter.FilterandSort);
	}

	@When("User clicks Technology category")
	public void user_clicks_technology_category() {
		click(DeviceSessionManager.getDriver(), filter.technology);
	}

	@When("User clicks the Apply Filter button")
	public void user_clicks_the_apply_filter_button() {
//		System.out.println("Displayed - "+ filter.applyFilter.isDisplayed());
//		System.out.println("Enabled - "+ filter.applyFilter.isEnabled());
//		System.out.println("Location - "+ filter.applyFilter.getRect());
		// applyFilterClick(DeviceSessionManager.getDriver(), filter.applyFilter);
		// click(DeviceSessionManager.getDriver(), filter.applyFilter);
		clickableWait(DeviceSessionManager.getDriver(), filter.applyFilter);
		tapUpperPart(DeviceSessionManager.getDriver(), filter.applyFilter);
	}

	@Then("Courses are displayed for selected category")
	public void courses_are_displayed_for_selected_category() {
		visibilityWait(DeviceSessionManager.getDriver(), filter.technologyText);
		String actual = getText(DeviceSessionManager.getDriver(), filter.technologyText);

		Assert.assertEquals("Technology", actual);
	}

//1 - 3 MONTHS DURATION----------------------------------------------------------------------------

	@Given("User is on the courses page after selecting category")
	public void user_is_on_the_courses_page_after_selecting_category() {

	}

	@When("User clicks the Filter & Sort option for duration")
	public void user_clicks_the_filter_sort_option_for_duration() {
		click(DeviceSessionManager.getDriver(), filter.FilterandSort);
	}

	@When("User clicks 1to3 months")
	public void user_clicks_1to3_months() {
		click(DeviceSessionManager.getDriver(), filter.oneto3months);
	}

	@When("User clicks the Apply Filter")
	public void user_clicks_the_apply_filter() {
		clickableWait(DeviceSessionManager.getDriver(), filter.applyFilter);
		tapUpperPart(DeviceSessionManager.getDriver(), filter.applyFilter);
	}

	@Then("Courses are displayed for selected duration")
	public void courses_are_displayed_for_selected_duration() {
		visibilityWait(DeviceSessionManager.getDriver(), filter.threemonthsText);
		String actual = getText(DeviceSessionManager.getDriver(), filter.threemonthsText);

		Assert.assertEquals("3 Months", actual);
	}
	// 3 - 6 MONTHS
	// DURATION---------------------------------------------------------------

	@Given("User is on the courses page after selected duration")
	public void user_is_on_the_courses_page_after_selected_duration() {

	}

	@When("User clicks the Filter & Sort option for new duration")
	public void user_clicks_the_filter_sort_option_for_new_duration() {
		click(DeviceSessionManager.getDriver(), filter.FilterandSort);
	}

	@When("User clicks 3to6 months")
	public void user_clicks_3to6_months() {
		click(DeviceSessionManager.getDriver(), filter.threeto6months);
	}

	@When("User clicks the Apply Filter for duration")
	public void user_clicks_the_apply_filter_for_duration() {
		clickableWait(DeviceSessionManager.getDriver(), filter.applyFilter);
		tapUpperPart(DeviceSessionManager.getDriver(), filter.applyFilter);
	}

	@Then("Courses are displayed for newly selected duration")
	public void courses_are_displayed_for_newly_selected_duration() {
		visibilityWait(DeviceSessionManager.getDriver(), filter.sixmonthsText);
		String actual = getText(DeviceSessionManager.getDriver(), filter.sixmonthsText);

		Assert.assertEquals("6 Months", actual);
	}

	// FREE
	// COURSE---------------------------------------------------------------------

	@Given("User is on the courses page after selecting Duration")
	public void user_is_on_the_courses_page_after_selecting_duration() {

	}

	@When("User clicks the Filter & Sort option for free course")
	public void user_clicks_the_filter_sort_option_for_free_course() {
		click(DeviceSessionManager.getDriver(), filter.FilterandSort);
	}

	@When("User clicks Free Course Only")
	public void user_clicks_free_course_only() {
		click(DeviceSessionManager.getDriver(), filter.FreeCheckbox);
	}

	@When("User clicks the Apply Filter to select free course")
	public void user_clicks_the_apply_filter_to_select_free_course() {
		clickableWait(DeviceSessionManager.getDriver(), filter.applyFilter);
		tapUpperPart(DeviceSessionManager.getDriver(), filter.applyFilter);
	}

	@Then("Courses are displayed")
	public void courses_are_displayed() {
		visibilityWait(DeviceSessionManager.getDriver(), filter.FreeText);
		String actual = getText(DeviceSessionManager.getDriver(), filter.FreeText);

		Assert.assertEquals("Free", actual);
	}

	// ONLINE
	// COURSE-----------------------------------------------------------------------

	@Given("User is on the courses page after selecting free course")
	public void user_is_on_the_courses_page_after_selecting_free_course() {

	}

	@When("User clicks the Filter & Sort option to select mode")
	public void user_clicks_the_filter_sort_option_to_select_mode() {
		click(DeviceSessionManager.getDriver(), filter.FilterandSort);
	}

	@When("User clicks Online Course Only")
	public void user_clicks_online_course_only() {
		scrollToElementByText(DeviceSessionManager.getDriver(), "Online");
		click(DeviceSessionManager.getDriver(), filter.online);
	}

	@When("User clicks the Apply Filter to select mode of the  course")
	public void user_clicks_the_apply_filter_to_select_mode_of_the_course() {
		clickableWait(DeviceSessionManager.getDriver(), filter.applyFilter);
		tapUpperPart(DeviceSessionManager.getDriver(), filter.applyFilter);
	}

	@Then("Courses are displayed for selected mode")
	public void courses_are_displayed_for_selected_mode() {
		visibilityWait(DeviceSessionManager.getDriver(), filter.LiveonlineText);
		String actual = getText(DeviceSessionManager.getDriver(), filter.LiveonlineText);
		Assert.assertEquals("Live online", actual);
	}

}
