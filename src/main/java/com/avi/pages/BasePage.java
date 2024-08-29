package com.avi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.avi.driver.DriverManager;
import com.avi.enums.WaitStrategy;
import com.avi.factory.ExplicitWaitFactory;
import com.avi.reports.ExtentLogger;

public class BasePage {

	protected void click(By by, WaitStrategy waitStrategy, String elementName) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		element.click();
		ExtentLogger.pass(elementName + " is Clicked.", true);
	}

	protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementName) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		element.sendKeys(value);
		ExtentLogger.pass(value + " is entered successfull in " + elementName, true);
	}

	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
}
