package a1qa.google.flights.utils;

import org.openqa.selenium.By;

public enum Currency {

	USD(By.xpath(".//div[contains(text(), 'USD')]")),
	EUR(By.xpath(".//div[contains(text(), 'EUR')]"));
	
	private By locator;
	
	Currency(By locator) {
		this.locator = locator;
	}
	
	public By getLocator() {
		return locator;
	}
}