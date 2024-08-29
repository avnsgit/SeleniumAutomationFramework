package com.avi.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.avi.annotations.FrameworkAnnotation;
import com.avi.enums.CategoryType;
import com.avi.pages.OrangeHRMLoginPage;

public final class OrangeHRMTests extends BaseTest {

	private OrangeHRMTests() {

	}

	@FrameworkAnnotation(author = { "Avinash", "Mahesh" }, category = { CategoryType.SANITY, CategoryType.SMOKE })
	@Test
	public void loginLogoutTest(Map<String, String> data) {
		String title = new OrangeHRMLoginPage().enterUserName(data.get("username")).enterPassword(data.get("password"))
				.clickLogin().clickWelcome().clickLogout().getTitle();
		Assertions.assertThat(title).isEqualTo("OrangeHRM");
	}

	@Test
	public void newTest(Map<String, String> data) {
		String title = new OrangeHRMLoginPage().enterUserName(data.get("username")).enterPassword(data.get("password"))
				.clickLogin().clickWelcome().clickLogout().getTitle();
		Assertions.assertThat(title).isEqualTo("OrangeHRM");
	}
}
