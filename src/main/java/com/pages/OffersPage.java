package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OffersPage {

	public AndroidDriver driver;

	public OffersPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

	}

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Offers\")")
	public WebElement offersModule;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'live')]")
	public WebElement LiveOffers;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'% OFF')]")
	public List<WebElement> OffersTotal;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Offers\")")
	public WebElement offersText;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Offers\")")
	public WebElement back;
}

//android.widget.TextView[contains(@text,'Use at checkout')]