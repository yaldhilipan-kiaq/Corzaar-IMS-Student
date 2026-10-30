package com.stepdefinitions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;
import com.driver.DeviceSessionManager;
import com.pages.FilterPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterSteps extends BaseClass {

	FilterPage filter = new FilterPage(DeviceSessionManager.getDriver());

// COURSE THROUGH SEARCH --------------------------------------------------------
	String searchedCourse;

	@Given("User Clicks course option to search course")
	public void user_clicks_course_option_to_search_course() {
		click(DeviceSessionManager.getDriver(), filter.CoursesOption);
	}

	@When("User enters  Course {string} name")
	public void user_enters_course_name(String string) {
		searchedCourse = string;
		sendKeys(DeviceSessionManager.getDriver(), filter.SearchBox, string);
	}

//
	@When("User Clicks the Search button for valid course")
	public void user_clicks_the_search_button_for_valid_course() {

		click(DeviceSessionManager.getDriver(), filter.SearchApply);
	}

	@Then("Search Result should be {string}")
	public void search_result_should_be(String string) {
//		 visibilityWait(DeviceSessionManager.getDriver(), filter.allCourseName);
//		WebElement text = getTexts(DeviceSessionManager.getDriver(), filter.allCourseName);
//		try {
//			Assert.assertEquals(text, string);
//		} finally {
//			Assert.assertFalse("No course ", filter.allCourseName.isEmpty());
//		}
		List<String> Names = filter.getAllCourseNames();
		System.out.println("Courses on screen " + Names);
		String actual = filter.isCourseDisplayed(searchedCourse) ? "displayed" : "not displayed";
		if (actual.equals("not displayed")) {
			System.out.println("Course '" + string + "'is not displayed");
		}

		Assert.assertEquals("Searched course mismatch = " + searchedCourse, actual, string);
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

	@When("User clicks {string} category")
	public void user_clicks_category(String string) {
		List<WebElement> categories = filter.allCategoriesName;
		WebElement categorychip = null;
		boolean clicked = false;
		String selectedCategory = string;

		for (WebElement tab : categories) {
			String name = tab.getDomAttribute("content-desc");
			if (name.equalsIgnoreCase(string)) {
				tab.click();
				clicked = true;
				break;
			}
			if (categorychip == null && !name.equalsIgnoreCase("All")) {
				categorychip = tab;
			}
			if (!clicked && categorychip != null)
				selectedCategory = categorychip.getAttribute("content-desc");
			categorychip.click();
			clicked = true;
		}
		Assert.assertTrue("No Category chip could be clicked = " + string, clicked);

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

	@When("User clicks \"{int} {int} months\"month")
	public void user_clicks_months_month(Integer int1, Integer int2) {
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
//	click(DeviceSessionManager.getDriver(), filter.FilterandSort);
//	click(DeviceSessionManager.getDriver(), filter.threeto6months);
//	
//	clickableWait(DeviceSessionManager.getDriver(), filter.applyFilter);
//	tapUpperPart(DeviceSessionManager.getDriver(), filter.applyFilter);
//	
//	visibilityWait(DeviceSessionManager.getDriver(), filter.sixmonthsText);
//	String actual = getText(DeviceSessionManager.getDriver(), filter.sixmonthsText);
//
//	Assert.assertEquals("6 Months", actual);

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

	// MINIMUM RATING---------------------------------------------------------------
	@Given("User is on the courses page after selecting free course")
	public void user_is_on_the_courses_page_after_selecting_free_course() {

	}

	@When("User clicks the Filter & Sort option to select course by rating")
	public void user_clicks_the_filter_sort_option_to_select_course_by_rating() {

	}

	@When("User clicks {string} for the Course")
	public void user_clicks_for_the_course(String string) {

	}

	@When("User clicks the Apply Filter to filter the course")
	public void user_clicks_the_apply_filter_to_filter_the_course() {

	}

	@Then("Courses are displayed for selected rating")
	public void courses_are_displayed_for_selected_rating() {

	}

	// ONLINE
	// COURSE-----------------------------------------------------------------------
	@Given("User is on the courses page after selecting the rating")
	public void user_is_on_the_courses_page_after_selecting_the_rating() {

	}

	@When("User clicks the Filter & Sort option to select mode")
	public void user_clicks_the_filter_sort_option_to_select_mode() {
		click(DeviceSessionManager.getDriver(), filter.FilterandSort);
	}

	@When("User clicks {string} Course Only")
	public void user_clicks_course_only(String string) {
		scrollToElementByText(DeviceSessionManager.getDriver(), "Recommended");
		// click(DeviceSessionManager.getDriver(), filter.online);

		List<WebElement> modes = filter.allModes;
		WebElement modeschip = null;
		boolean clicked = false;
		String selectedMode = string;

		for (WebElement tab : modes) {
			String name = tab.getDomAttribute("content-desc");
			if (name.equalsIgnoreCase(string)) {
				tab.click();
				clicked = true;
				break;
			}
			if (modeschip == null && !name.equalsIgnoreCase("All")) {
				modeschip = tab;
			}
			if (!clicked && modeschip != null)
				selectedMode = modeschip.getAttribute("content-desc");
			modeschip.click();
			clicked = true;
		}
		Assert.assertTrue("No Category chip could be clicked = " + string, clicked);

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

	// Sortby
	// ---------------------------------------------------------------------------

	@Given("User is on the courses page after selecting mode")
	public void user_is_on_the_courses_page_after_selecting_mode() {

	}

	@When("User clicks the Filter & Sort option to sort")
	public void user_clicks_the_filter_sort_option_to_sort() {
		click(DeviceSessionManager.getDriver(), filter.FilterandSort);
	}

	@When("User clicks {string} Course")
	public void user_clicks_course(String string) {
		scrollToElementByText(DeviceSessionManager.getDriver(), "Recommended");
		List<WebElement> sort = filter.allSortBy;
		WebElement sortchip = null;
		boolean clicked = false;
		String selectedsort = string;

		for (WebElement tab : sort) {
			String name = tab.getDomAttribute("content-desc");
			if (name.equalsIgnoreCase(string)) {
				tab.click();
				clicked = true;
				break;
			}
			if (sortchip == null && !name.equalsIgnoreCase("All")) {
				sortchip = tab;
			}
			if (!clicked && sortchip != null)
				selectedsort = sortchip.getAttribute("content-desc");
			sortchip.click();
			clicked = true;
		}
		Assert.assertTrue("No Sort by chip could be clicked = " + string, clicked);
	}

	@When("User clicks the Apply Filter to sort the  course")
	public void user_clicks_the_apply_filter_to_sort_the_course() {
		clickableWait(DeviceSessionManager.getDriver(), filter.applyFilter);
		tapUpperPart(DeviceSessionManager.getDriver(), filter.applyFilter);
	}

	@Then("Courses are displayed for applied filter")
	public void courses_are_displayed_for_applied_filter() {

	}

}
