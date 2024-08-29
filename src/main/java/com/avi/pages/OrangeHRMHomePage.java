package com.avi.pages;

import org.openqa.selenium.By;

import com.avi.enums.WaitStrategy;

public final class OrangeHRMHomePage extends BasePage {

	private final By linkWelcome = By.id("welcome");
	private final By linkLogout = By.xpath("//a[text()='Logout']");

	public OrangeHRMHomePage clickWelcome() {
		click(linkWelcome, WaitStrategy.PRESENCE, "Welcome Link");
		return this;
	}

	public OrangeHRMLoginPage clickLogout() {
		// Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
		click(linkLogout, WaitStrategy.CLICKABLE, "Logout Link");
		return new OrangeHRMLoginPage();
	}
}
