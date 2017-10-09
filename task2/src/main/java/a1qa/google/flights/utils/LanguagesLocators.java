package a1qa.google.flights.utils;

import org.openqa.selenium.By;

public enum LanguagesLocators {
	
	EN(By.xpath(".//div[contains(text(), 'tates')]"));
	
	private By locator;
	
	LanguagesLocators(By locator) {
		this.locator = locator;
	}
	
	public By getLocator() {
		return locator;
	}
}