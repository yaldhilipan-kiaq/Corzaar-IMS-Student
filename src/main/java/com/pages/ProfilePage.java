package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProfilePage {

	public AndroidDriver driver;

	public ProfilePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

	}

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement profile;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Mark curriculum progress\").instance(0)")
	public WebElement markCurriculum;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Mark curriculum progress\")")
	public WebElement markCurriculum1;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement module1;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\").instance(0)")
	public WebElement customerJourney;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\").instance(0)")
	public WebElement contentSystem;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement growthExperiment;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"View certificate\")")
	public WebElement CertificateView;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Download PDF\")")
	public WebElement DownloadPDF;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"active · 100% done\")")
	public WebElement CourseCompleted;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sign out\")")
	public WebElement SignOut;

}
