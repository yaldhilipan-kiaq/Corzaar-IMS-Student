package com.stepdefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;
import com.driver.DeviceSessionManager;
import com.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps extends BaseClass {

	HomePage home = new HomePage(DeviceSessionManager.getDriver());
	String selectedCategory;

	@Given("User is on the home page")
	public void user_is_on_the_home_page() {
		visibilityWait(DeviceSessionManager.getDriver(), home.corzaar);
		String actual = getText(DeviceSessionManager.getDriver(), home.corzaar);

		Assert.assertEquals("CORZAAR", actual);
	}

	@When("User selects {string} category")
	public void user_selects_category(String string) {
		List<WebElement> categories = home.allcategory;
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

	@When("User taps the search courses button")
	public void user_taps_the_search_courses_button() {
		click(DeviceSessionManager.getDriver(), home.homeSearchBtn);
	}

	@Then("The courses are displayed for the selected Category")
	public void the_courses_are_displayed_for_the_selected_category() {
		visibilityWait(DeviceSessionManager.getDriver(), home.technologyText);
		String actual = getText(DeviceSessionManager.getDriver(), home.technologyText);

		Assert.assertEquals("Technology", actual);
	}

//------------------------------------------------------------------------------
}
