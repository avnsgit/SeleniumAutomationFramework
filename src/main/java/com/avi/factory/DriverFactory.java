package com.avi.factory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.avi.enums.ConfigProperties;
import com.avi.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {

	private DriverFactory() {

	}

	public static WebDriver getDriver(String browser, String version) throws MalformedURLException {
		WebDriver driver = null;
		String runmode = PropertyUtils.get(ConfigProperties.RUNMODE);
		if (browser.equalsIgnoreCase("chrome")) {
			if (runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.CHROME);
				if (!version.isEmpty()) {
					cap.setVersion(version);
				}
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			} else if (runmode.equalsIgnoreCase("local")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
		} else if (browser.equalsIgnoreCase("firefox")) {
			if (runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.FIREFOX);
				if (!version.isEmpty()) {
					cap.setVersion(version);
				}
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			} else if (runmode.equalsIgnoreCase("local")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		}
		return driver;
	}
}
