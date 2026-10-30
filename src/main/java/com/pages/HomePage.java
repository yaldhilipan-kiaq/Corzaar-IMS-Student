package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	public AndroidDriver driver;

	public HomePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"home-search-input\")")
	public WebElement searchInput;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"home-search-cta\")")
	public WebElement homeSearchBtn;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Design\")")
	public WebElement design;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Technology\")")
	public WebElement technology;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement navigateBack;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Design\").instance(2)")
	public WebElement designText;

	@AndroidFindBy(xpath = "new UiSelector().text(\"Technology\").instance(2)")
	public WebElement technologyText;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'results')]")
	public WebElement results;

}
//new UiSelector().text("Data Analytics with Python")valid 
//new UiSelector().text("Product Design Foundations") invalid gaming
//new UiSelector().text("Search courses")
//new UiSelector().text("Top categories")
//new UiSelector().text("Explore")
//new UiSelector().resourceId("topcat-Design")
//new UiSelector().resourceId("topcat-Technology")
//new UiSelector().text("Popular right now")
//new UiSelector().text("View all").instance(0)
//new UiSelector().text("View all").instance(0) trusted institutes
//new UiSelector().text("All courses")
//new UiSelector().text("Institute portal")
//new UiSelector().text("Institute")
//new UiSelector().text("Admin")
//new UiSelector().text("") -  institute back
//new UiSelector().text("Admin")
//discovery
//new UiSelector().text("Institutes")
//new UiSelector().resourceId("disc-filter")
//browse category 
//new UiSelector().text("Design")
//new UiSelector().text("Technology")
//new UiSelector().text("Bengaluru")
//new UiSelector().text("Mumbai")
//new UiSelector().text("Pune")