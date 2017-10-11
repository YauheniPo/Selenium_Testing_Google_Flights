package a1qa.goo_flights.utils;

import org.openqa.selenium.By;

public enum CurrenciesLocators {

	USD(By.xpath(".//div[contains(text(), 'USD')]")),
	EUR(By.xpath(".//div[contains(text(), 'EUR')]"));
	
	private By locator;
	
	CurrenciesLocators(By locator) {
		this.locator = locator;
	}
	
	public By getLocator() {
		return locator;
	}
}