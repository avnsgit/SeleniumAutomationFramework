package com.avi.pages;

import org.openqa.selenium.By;

import com.avi.enums.WaitStrategy;

public final class OrangeHRMLoginPage extends BasePage {

	/*
	 * id name className linkText partiallinkText xpath/css
	 */

	private final By textboxUsername = By.id("txtUsername");
	private final By textboxPassword = By.xpath("//input[@id='txtPassword' and @type ='password']");
	private final By buttonLogin = By.id("btnLogin");

	public OrangeHRMLoginPage enterUserName(String userName) {
		sendKeys(textboxUsername, userName, WaitStrategy.CLICKABLE, "UserName TextBox.");
		return this;
	}

	public OrangeHRMLoginPage enterPassword(String password) {
		sendKeys(textboxPassword, password, WaitStrategy.CLICKABLE, "Password TextBox.");
		return this;
	}

	public OrangeHRMHomePage clickLogin() {
		click(buttonLogin, WaitStrategy.CLICKABLE, "LoginButton");
		return new OrangeHRMHomePage();
	}

	public String getTitle() {
		return getPageTitle();
	}
}