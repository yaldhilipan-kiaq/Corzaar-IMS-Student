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

	@Given("User verifies Live offers")
	public void user_verifies_live_offers() {
		String text = getText(DeviceSessionManager.getDriver(), offer.LiveOffers);
		LiveCount = Integer.parseInt(text.replaceAll("[^0-9]", ""));

	}

	@When("User clicks the Offers module")
	public void user_clicks_the_offers_module() {
		click(DeviceSessionManager.getDriver(), offer.offersModule);
	}

	@When("User Verifies the Offers count")
	public void user_verifies_the_offers_count() {
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

//		
//		MobileswipeUp(DeviceSessionManager.getDriver());
//		int displayed = offer.OffersTotal.size();
//		Assert.assertEquals("Coupons count mismatch", LiveCount, displayed);
	}

	@Then("User Navigate back")
	public void user_navigate_back() {
		scrollToElementByText(DeviceSessionManager.getDriver(), "Offers");
		click(DeviceSessionManager.getDriver(), offer.back);
	}

}
