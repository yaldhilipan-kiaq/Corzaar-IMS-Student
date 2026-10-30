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

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Profile\")")
	public WebElement Profile1;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement profile;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement wallet;

	@AndroidFindBy(uiAutomator = "//android.widget.TextView[@text='Your referral code']/following-sibling::android.widget.TextView[1]")
	public WebElement referalCode;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement ReferalBack;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Complete your profile\")")
	public WebElement incompleteProfile;

	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Sign out']/following-sibling::android.view.ViewGroup[1]/following-sibling::android.widget.TextView[2]")
	public WebElement headerName;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"profile-name\")")
	public WebElement profileName;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"profile-email\")")
	public WebElement profileEmail;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Save profile\")")
	public WebElement SaveProfile;

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
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Request refund\")")
	public WebElement Requestrefund;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Reason for refund\")")
	public WebElement RequestForrefund;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Submit\")")
	public WebElement Submit;
	
	

}
