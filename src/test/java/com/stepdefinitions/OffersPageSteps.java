package com.stepdefinitions;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;
import com.driver.DeviceSessionManager;
import com.pages.OffersPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OffersPageSteps extends BaseClass {

	OffersPage offer = new OffersPage(DeviceSessionManager.getDriver());
	int LiveCount;

	@Given("User verifies Live offers displayed")
	public void user_verifies_live_offers_displayed() {
		String text = getText(DeviceSessionManager.getDriver(), offer.LiveOffers);
		LiveCount = Integer.parseInt(text.replaceAll("[^0-9]", ""));
	}

	@When("User clicks the Offers module to copy the offers")
	public void user_clicks_the_offers_module_to_copy_the_offers() {
		click(DeviceSessionManager.getDriver(), offer.offersModule);
	}

	@When("User Verifies the Offers count that are present")
	public void user_verifies_the_offers_count_that_are_present() {
		Set<String> coupons = new LinkedHashSet<String>();
		int noNewCount = 0;
		while (noNewCount < 3) {
			int before = coupons.size();
			for (WebElement element : offer.OffersTotal) {
				// coupons.add(element.getText());
				try {
					coupons.add(element.getText().trim());
				} catch (Exception e) {
				}
			}
			noNewCount = (coupons.size() == before) ? noNewCount + 1 : 0;
			MobileswipeUp(DeviceSessionManager.getDriver());
		}
		System.out.println("coupons found - " + coupons);
		Assert.assertEquals("Coupons displayed " + coupons, LiveCount, coupons.size());
	}

	@Then("User Navigate back to the homepage")
	public void user_navigate_back_to_the_homepage() {
		scrollToElementByText(DeviceSessionManager.getDriver(), "Offers");
		click(DeviceSessionManager.getDriver(), offer.back);

		visibilityWait(DeviceSessionManager.getDriver(), offer.signIn);
		String actual = offer.signIn.getText();
		String expected = "Sign in";

		Assert.assertEquals(expected, actual);
	}

}
