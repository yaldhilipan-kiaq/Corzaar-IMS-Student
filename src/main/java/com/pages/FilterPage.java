package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FilterPage {

	public AndroidDriver driver;

	public FilterPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"qtile-courses\")")
	public WebElement CoursesOption;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"discover-input\")")
	public WebElement SearchBox;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement SearchApply;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Chemical Course \")")
	public WebElement ChemicalCourse;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\").instance(0)")
	public WebElement Favourites;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Filter & Sort\")")
	public WebElement FilterandSort;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Design\")")
	public WebElement design;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Technology\")")
	public WebElement technology;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Technology\").instance(1)")
	public WebElement technologyText;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"1–3 months\")")
	public WebElement oneto3months;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"3 Months\").instance(0)")
	public WebElement threemonthsText;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"3–6 months\")")
	public WebElement threeto6months;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"6 Months\")")
	public WebElement sixmonthsText;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Bengaluru\")")
	public WebElement bengaluru;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"filter-price-min\")")
	public WebElement minPrice;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"filter-price-max\")")
	public WebElement maxPrice;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Online\")")
	public WebElement online;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Live online\").instance(0)")
	public WebElement LiveonlineText;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Offline\")")
	public WebElement offline;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement FreeCheckbox;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Free\")")
	public WebElement FreeText;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"filter-apply\")")
	public WebElement applyFilter;

	@AndroidFindBy(id = "filter-apply")
	public WebElement applyFilterID;

	@AndroidFindBy(accessibility = "Apply filters")
	public WebElement applyFilterAccID;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Apply filters\"]")
	public WebElement applyFilterXpath;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"prem-course-a3a16ceb-5f3e-4d79-aada-ec083e5d44e7\")")
	public WebElement FreeCourse;

}
