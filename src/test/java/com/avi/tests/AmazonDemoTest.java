package com.avi.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.avi.annotations.FrameworkAnnotation;
import com.avi.enums.CategoryType;
import com.avi.pages.AmazonHomePage;

public final class AmazonDemoTest extends BaseTest {

	private AmazonDemoTest() {

	}

	@FrameworkAnnotation(author= {"Avinash","Mahesh"},category= {CategoryType.SANITY,CategoryType.SMOKE})
	@Test
	public void amazonTest(Map<String, String> data) {
		String title = new AmazonHomePage().clickHamburger().clickComputer().clickOnSubMenuItem(data.get("menuname"))
				.getTitle();
		Assertions.assertThat(title).isNotNull().isNotBlank();
	}
}
