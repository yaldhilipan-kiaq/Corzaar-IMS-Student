package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CoursePage {

	public AndroidDriver driver;

	public CoursePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

	}

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Training program 1234\")")
	public WebElement FreeCourse;

	@AndroidFindBy(uiAutomator = "prem-course-a3a16ceb-5f3e-4d79-aada-ec083e5d44e7")
	public WebElement FreeCourseID;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Free\")")
	public WebElement FreeText;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enroll for free\")")
	public WebElement Enroll;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"review-input\")")
	public WebElement ReviewInput;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Submit review\")")
	public WebElement Submit;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Course details\")")
	public WebElement CourseDetails;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement backtoHome;

}
