package com.avi.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.avi.driver.DriverManager;

public class LoginPageTests extends BaseTest {

	private LoginPageTests() {

	}

	@Test
	public void test1() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Jobs for Selenium Testing", Keys.ENTER);
	}
}
