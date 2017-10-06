package a1qa.google.flights.pages;

import org.openqa.selenium.By;

import a1qa.framework.pages.BasePage;

public class FlightsPage extends BasePage {
	
	private final static By FLIGHTS_PAGE_SWITCH_TRACK_PRICES = By.xpath("//div[contains(@class, 'Ub-g')]");
	private final static By FLIGHTS_PAGE_SWITCH_STATUS = By.xpath(".//div[@elm]");

	public FlightsPage() {
		super(FLIGHTS_PAGE_SWITCH_TRACK_PRICES);
	}
	
	public FlightsPage clickTrackPrices() {
		log.info("Click track prices");
		getElement(FLIGHTS_PAGE_SWITCH_TRACK_PRICES).findElement(FLIGHTS_PAGE_SWITCH_STATUS).click();
		return this;
	}
	
	public String getStatusSwitchTrackPrices() {
		return getElement(FLIGHTS_PAGE_SWITCH_TRACK_PRICES).getText();
	}
}