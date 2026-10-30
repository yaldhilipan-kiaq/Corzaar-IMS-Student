package com.baseclass;

import java.awt.Dimension;
import java.io.File;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class BaseClass {

	private static final Duration TIMEOUT = Duration.ofSeconds(60);

	public static void click(AndroidDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

		wait.until(ExpectedConditions.elementToBeClickable(element));

		element.click();
	}

	public static void relaunchApp(AndroidDriver driver) {
		driver.terminateApp("com.corzaar.app");
		driver.activateApp("com.corzaar.app");
	}

	public String getText(AndroidDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

		wait.until(ExpectedConditions.visibilityOf(element));

		return element.getText();

	}

	public WebElement getTexts(AndroidDriver driver, List<WebElement> allCourseName) {
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

		wait.until(ExpectedConditions.visibilityOf((WebElement) allCourseName));

		return allCourseName.getFirst();

	}

	public static void sendKeys(AndroidDriver driver, WebElement element, String text) {

		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear(); // element.click();
		element.sendKeys(text);
		driver.hideKeyboard();
	}

	public static void otpSendKeys(AndroidDriver driver, WebElement element, String text) {

		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

		wait.until(ExpectedConditions.visibilityOf(element));

		element.clear();// element.click();
		element.sendKeys(text);

	}

	public static void applyFilterClick(AndroidDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

		wait.until(ExpectedConditions.elementToBeClickable(element));

		System.out.println("Button is Enabled " + element.isEnabled());
		try {
			element.click();
			System.out.println("Element Clicked Successfully");

		} catch (Exception e) {
			System.out.println("Click Failed - " + e.getMessage());
			throw e;
		}
	}

	public static boolean displayed(AndroidDriver driver, WebElement element) {

		return element.isDisplayed();
	}

	public static void takeScreenshot(AndroidDriver driver, String fileName) throws Exception {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		File destination = new File("screenshots/" + fileName + ".png");

		FileUtils.copyFile(source, destination);
	}

	public static void visibilityWait(AndroidDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void clickableWait(AndroidDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void swipeUp(AndroidDriver driver) {

		driver.executeScript("mobile: swipeGesture",
				Map.of("left", 100, "top", 100, "width", 200, "height", 600, "direction", "up", "percent", 0.75));
	}

	public static void swipeDown(AndroidDriver driver) {

		driver.executeScript("mobile: scrollGesture",
				Map.of("left", 100, "top", 400, "width", 800, "height", 1400, "direction", "down", "percent", 0.9));
	}

//swipeup
	public static void MobileswipeUp(AndroidDriver driver) {

		org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		int x = size.width / 2;
		int startY = (int) (size.height * 0.75);
		int endY = (int) (size.height * 0.30);

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence swipe = new Sequence(finger, 1);
		swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, startY));
		swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), x, endY));
		swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(List.of(swipe));
	}

	public static void MobileswipeDown(AndroidDriver driver) {

		org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		int left = size.width / 10;
		int top = size.height / 4;
		int width = size.width * 8 / 10;
		int height = size.height / 2;

		driver.executeScript("mobile: scrollGesture",
				Map.of("left", left, "top", top, "width", width, "height", height, "direction", "up", "percent", 1.5));
	}

	public void scrollToElementByText(AndroidDriver driver, String text) {

		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"

				+ ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"));
	}

	public void scrollToElementByTextContains(AndroidDriver driver, String text) {

		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"

				+ ".scrollIntoView(new UiSelector().textContains(\"" + text + "\"))"));
	}

	public void tapUpperPart(AndroidDriver driver, WebElement element) {
		org.openqa.selenium.Rectangle rect = element.getRect();
		int x = rect.getX() + (rect.getWidth() / 2);
		int y = rect.getY() + (int) (rect.getHeight() * 0.30);
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence tap = new Sequence(finger, 1);
		tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
		tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Collections.singletonList(tap));

	}

}
