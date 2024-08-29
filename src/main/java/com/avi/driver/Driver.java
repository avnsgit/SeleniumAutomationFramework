package com.avi.driver;

import java.net.MalformedURLException;
import java.util.Objects;

import com.avi.enums.ConfigProperties;
import com.avi.exceptions.BrowserInvocationFailedException;
import com.avi.factory.DriverFactory;
import com.avi.utils.PropertyUtils;

public final class Driver {

	private Driver() {

	}

	public static void initDriver(String browser, String version) {
		if (Objects.isNull(DriverManager.getDriver())) {
			try {
				DriverManager.setDriver(DriverFactory.getDriver(browser, version));
			} catch (MalformedURLException e) {
				throw new BrowserInvocationFailedException(
						"Browser invocation failed. Please check the capabilities of browser");
			}
		}
		DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
