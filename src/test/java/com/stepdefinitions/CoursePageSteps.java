package com.stepdefinitions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

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
//		List<String> names = new ArrayList<String>();
//		for (WebElement e : course.AllCourseName) {
//			names.add(e.getText().trim());
//		}
//		System.out.println(names);
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
		String actual = getText(DeviceSessionManager.getDriver(), course.ReviewInput);

		Assert.assertEquals("What worked well? What can improve?", actual);
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

	// -----------------------------------------------------------------------

	@Given("User is on the all Course page")
	public void user_is_on_the_all_course_page() {
		// click(DeviceSessionManager.getDriver(), course.CoursesOption);
	}

	@Then("Displayed course count should match the total courses listed")
	public void displayed_course_count_should_match_the_total_courses_listed() {
		int displayedCount = getDisplayedCount();
		int actualCount = getTotalCoursesBySwiping();

		System.out.println("Displayed: " + displayedCount + " | Actual: " + actualCount);
		Assert.assertEquals("Course count mismatch", displayedCount, actualCount);
	}

	private int getDisplayedCount() {
		String text = course.resultsCount.getText();
		String firstPart = text.trim().split(" ")[0];
		return Integer.parseInt(firstPart.replaceAll("[^0-9]", ""));
	}

	private int getTotalCoursesBySwiping() {
		Set<String> allCourses = new HashSet<>();
		int swipesWithNoNewCourse = 0;

		while (swipesWithNoNewCourse < 2) {
			int countBefore = allCourses.size();

			for (WebElement card : course.courseCount) {
				allCourses.add(card.getAttribute("resource-id"));
			}

			if (allCourses.size() == countBefore) {
				swipesWithNoNewCourse++;
			} else {
				swipesWithNoNewCourse = 0;
			}
			MobileswipeUp(DeviceSessionManager.getDriver());
		}
		System.out.println("Total courses found: " + allCourses.size());
		return allCourses.size();
	}

}
