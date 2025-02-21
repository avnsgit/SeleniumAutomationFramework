package com.avi.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.avi.driver.DriverManager;
import com.avi.enums.WaitStrategy;

public final class ExplicitWaitFactory {

	private ExplicitWaitFactory() {

	}

	public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by) {
		WebElement element = null;
		if (waitStrategy == WaitStrategy.CLICKABLE) {
			element = new WebDriverWait(DriverManager.getDriver(), 10)
					.until(ExpectedConditions.elementToBeClickable(by));
		} else if (waitStrategy == WaitStrategy.PRESENCE) {
			element = new WebDriverWait(DriverManager.getDriver(), 10)
					.until(ExpectedConditions.presenceOfElementLocated(by));
		} else if (waitStrategy == WaitStrategy.VISIBLE) {
			element = new WebDriverWait(DriverManager.getDriver(), 10)
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		} else if (waitStrategy == WaitStrategy.NONE) {
			element = DriverManager.getDriver().findElement(by);
		}
		return element;
	}

}
