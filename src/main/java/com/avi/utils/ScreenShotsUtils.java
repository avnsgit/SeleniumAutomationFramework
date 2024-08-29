package com.avi.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.avi.driver.DriverManager;

public final class ScreenShotsUtils {
	
	private ScreenShotsUtils() {
		
	}
	
	public static String getBase64Image() {
		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
}
