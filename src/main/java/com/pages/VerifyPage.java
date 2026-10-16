package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VerifyPage {
	public AndroidDriver driver;

	public VerifyPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

	}

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Verify\")")
	public WebElement VerifyOption;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"verify-input\")")
	public WebElement IdInputField;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Verify certificate\").instance(1)")
	public WebElement Verifybutton;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Not verified\")")
	public WebElement notVerified;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Valid certificate\")")
	public WebElement ValidCertificate;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement back;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sign in\")")
	public WebElement signIn;

}
