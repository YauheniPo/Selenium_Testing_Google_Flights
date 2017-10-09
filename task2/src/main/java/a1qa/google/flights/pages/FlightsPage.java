package a1qa.google.flights.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import a1qa.framework.entity.elements.Button;
import a1qa.framework.entity.elements.Combobox;
import a1qa.framework.entity.elements.EntityElement;
import a1qa.framework.entity.elements.Label;
import a1qa.framework.entity.pages.BasePage;

public class FlightsPage extends BasePage {
	
	private static final By FLIGHTS_PAGE_SWITCH_TRACK_PRICES = By.xpath("//div[contains(@class, 'Ub-g')]");
	private final By FLIGHTS_PAGE_SWITCH_STATUS = By.xpath(".//div[@elm]");
	private final By FLIGHTS_PAGE_AIRLINE = By.xpath("//div[contains(@class, 's-b')]");
	private final By FLIGHTS_PAGE_SET_AIRLINE = By.xpath("//div[contains(@class, 'jb-g')]");
	private final By FLIGHTS_PAGE_ELEMENT_AIRLINE = By.xpath(".//div[contains(@class, 'jb-c')]");
	private final By FLIGHTS_PAGE_SET_AIRLINES = By.xpath("//div[contains(@class, '-d-P')]");
	private final By FLIGHTS_PAGE_ELEMENT_AIRLINES = By.xpath(".//a[contains(@class, 'd-X')]/.");
	private final By FLIGHTS_PAGE_SWITCH_AIRLINE = By.xpath(".//div[contains(@class, 'jb-a')]");
	public static final By FLIGHTS_PAGE_AIRLINE_TITLE = By.xpath(".//div[contains(@class, 'd-j')]");

	public FlightsPage() {
		super(FLIGHTS_PAGE_SWITCH_TRACK_PRICES);
		log.info("Opened flights page");
	}
	
	public FlightsPage clickTrackPrices() {
		log.info("Click track prices");
		new EntityElement(FLIGHTS_PAGE_SWITCH_TRACK_PRICES).getEntityElement().findElement(FLIGHTS_PAGE_SWITCH_STATUS).click();
		return this;
	}
	
	public String getStatusSwitchTrackPrices() {
		log.info("Get switch status");
		return new Label(FLIGHTS_PAGE_SWITCH_TRACK_PRICES).getTitleLabel();
	}
	
	public FlightsPage clickAirline() {
		fluentWaitForVisibilityOf(FLIGHTS_PAGE_AIRLINE);
		log.info("Click sorting airlines"); 
		new Button(FLIGHTS_PAGE_AIRLINE).clickBnt();
		return this;
	}
	
	public FlightsPage switchAirline(String titleAirline) {
		fluentWaitForVisibilityOf(FLIGHTS_PAGE_SET_AIRLINES);
		List<WebElement> airlines = new Combobox(FLIGHTS_PAGE_SET_AIRLINE).fetchListElements(FLIGHTS_PAGE_ELEMENT_AIRLINE).getListElements();
		for(int i = 0, l = airlines.size(); i < l; ++i) {
			String airline = airlines.get(i).getText();
			if(airline.equals(titleAirline)) {
				airlines.get(i).findElement(FLIGHTS_PAGE_SWITCH_AIRLINE).click();
				log.info("Clicked " + titleAirline);
				break;
			}
		}
		new Button(FLIGHTS_PAGE_AIRLINE).clickBnt();
		fluentWaitForVisibilityOf(FLIGHTS_PAGE_AIRLINE_TITLE);
		return this;
	}
	
	public List<WebElement> getListFlights() {
		fluentWaitForPresenceOf(FLIGHTS_PAGE_AIRLINE_TITLE);
		List<WebElement> list = new Combobox(FLIGHTS_PAGE_SET_AIRLINES).fetchListElements(FLIGHTS_PAGE_ELEMENT_AIRLINES).getListElements();
		return list;
	}
}