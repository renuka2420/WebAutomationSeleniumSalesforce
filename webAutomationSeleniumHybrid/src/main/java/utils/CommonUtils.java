package utils;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;

import constants.FileConstants;
import constants.WaitConstants;

public class CommonUtils {

	public static boolean waitForElement(WebDriver driver, WebElement element) {
		boolean isElementClickable = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitConstants.WAIT_FOR_ELEMENT);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			isElementClickable = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isElementClickable;
	}

	public static boolean waitForElementToDisappear(WebDriver driver, WebElement element) {
		boolean isElementFound = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitConstants.WAIT_FOR_ELEMENT_TO_DISAPPEAR);
		try {
			wait.until(ExpectedConditions.invisibilityOf(element));
			isElementFound = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isElementFound;
	}

	public static void moveToElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public static void dragAndDrop(WebDriver driver, WebElement element1, WebElement element2) {
		Actions action = new Actions(driver);
		action.dragAndDrop(element1, element2).build().perform();
	}

	public static void dragAndDropBy(WebDriver driver, WebElement element, int x, int y) {
		Actions action = new Actions(driver);
		action.dragAndDropBy(element, x, y).build().perform();
	}

	public static String getStringDateandTimeStamp() {

		String value = new SimpleDateFormat("YYYYMMddHHmmss").format(new Date());
		return value;
	}

	public static String getScreenshot(WebDriver driver) throws IOException {
		String path = FileConstants.SCREENSHOT_PATH;

		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);

		File dst = new File(path);
		FileUtils.copyFile(src, dst);
		return path;

	}

	public static void frameByIndex(WebDriver driver, int i) {

		driver.switchTo().frame(i);
	}

	public static void frameByName(WebDriver driver, String name) {

		driver.switchTo().frame(name);
	}

	public static void frameById(WebDriver driver, WebElement element) {

		driver.switchTo().frame(element);
	}
	
	public static void frameSwitchToParent(WebDriver driver) {
		
		driver.switchTo().parentFrame();
	}
}
