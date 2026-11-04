package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignInRemainderPage {
	public AndroidDriver driver;

	public SignInRemainderPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

	}

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sign in\")")
	public WebElement signIn;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement home;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\").instance(0)")
	public WebElement Favourites;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"All courses\")")
	public WebElement AllCoursestext;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"qtile-courses\")")
	public WebElement CoursesModule;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"prem-course-a5cbaaa1-c39e-4046-b194-65c0679ecee8\")")
	public WebElement paymentCourse;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Apply\")")
	public WebElement applyCoupon;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Student\")")
	public WebElement Student;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement closeButton;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Course details\")")
	public WebElement CourseDetails;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement backtoHome;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Start payment · ₹4,999\")")
	public WebElement StartPayment;

}
