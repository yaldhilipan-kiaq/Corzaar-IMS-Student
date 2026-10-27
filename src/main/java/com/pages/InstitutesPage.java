package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class InstitutesPage {

	public AndroidDriver driver;

	public InstitutesPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

	}

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Institutes\")")
	public WebElement InstitutesModule;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"All courses\")")
	public WebElement allCourseText;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement back;

}
