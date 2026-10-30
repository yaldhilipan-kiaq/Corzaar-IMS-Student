package com.pages;

import java.time.Duration;
import java.util.List;

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

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"qtile-courses\")")
	public WebElement CoursesOption;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Free\")")
	public WebElement FreeCourse;

	@AndroidFindBy(uiAutomator = "prem-course-a3a16ceb-5f3e-4d79-aada-ec083e5d44e7")
	public WebElement FreeCourseID;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Free\")")
	public WebElement FreeText;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='prem-course-course-product']//android.widget.TextView[following-sibling::android.widget.TextView[1][@text='Design' or @text='Technology' or @text='Business']]")
	public List<WebElement> AllCourseName;
	
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
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'results')]")
	public WebElement resultsCount;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[starts-with(@resource-id,'prem-course-')]")
	public List<WebElement> courseCount;
	
	
}
