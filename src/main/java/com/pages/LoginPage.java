package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {

	public AndroidDriver driver;

	public LoginPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

	}

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Profile\")")
	public WebElement Profiletext;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sign in\")")
	public WebElement signIn;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Student\")")
	public WebElement Student;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"auth-phone\")")
	public WebElement mobileNumber;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Continue with OTP\")")
	public WebElement continueWithOTP;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"auth-otp\")")
	public WebElement OTPField;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enter the 6-digit code sent to +91 1234512345.\")")
	public WebElement EnterOTPCode;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"auth-verify\")")
	public WebElement VerifyandContinue;

}
