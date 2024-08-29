package com.avi.pages;

import org.openqa.selenium.By;

import com.avi.enums.WaitStrategy;
import com.avi.utils.DynamicXpathUtils;

public final class AmazonHamburgerMenuPage extends BasePage {

	private String linkMobileAndComputers = "//div[text()='Mobiles, Computers']/parent::a";
	private String linkSubMenu = "//a[text()='%s']";
	
	public AmazonHamburgerMenuPage clickComputer() {
		click(By.xpath(linkMobileAndComputers), WaitStrategy.CLICKABLE, "Mobiles and Computers");
		return this;
	}
	
	public AmazonLaptopPage clickOnSubMenuItem(String menuText) {
		String newxpath= DynamicXpathUtils.getXpath(linkSubMenu, menuText);
		click(By.xpath(newxpath), WaitStrategy.CLICKABLE, menuText);
		if(menuText.contains("Laptops")) {
			return new AmazonLaptopPage();
		}
		return null;
	}
}
