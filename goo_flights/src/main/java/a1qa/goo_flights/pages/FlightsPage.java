package a1qa.goo_flights.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import a1qa.framework.entity.elements.Button;
import a1qa.framework.entity.elements.Combobox;
import a1qa.framework.entity.elements.EntityElement;
import a1qa.framework.entity.pages.BasePage;
import a1qa.framework.utils.Numbers;
import a1qa.framework.utils.TimeoutConfig;

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
	
	public boolean isNewStatusSwitchTrackPrices(String status) {
		log.info("Status has changed");
		setFluensWaitTextInElement(FLIGHTS_PAGE_SWITCH_TRACK_PRICES, status);
		return true;
	}
	
	public FlightsPage clickAirline() {
		log.info("Click sorting airlines");
		fluentWaitForVisibilityOf(FLIGHTS_PAGE_AIRLINE);
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
		return this;
	}
	
	public List<String> getListTitleAirlines() {
		fluentWaitForVisibilityOf(FLIGHTS_PAGE_AIRLINE_TITLE);
		List<WebElement> listAirlines = null;
		List<String> titleAirlines = new ArrayList<String>();
		int n = 0;
		do {
			try {
				Thread.sleep(TimeoutConfig.MIN.getTimeout());
				listAirlines = new Combobox(FLIGHTS_PAGE_SET_AIRLINES).fetchListElements(FLIGHTS_PAGE_ELEMENT_AIRLINES)
						.getListElements();
				for(int i = 0, l = listAirlines.size(); i < l; ++i) {
					titleAirlines.add(i, listAirlines.get(i).findElement(FLIGHTS_PAGE_AIRLINE_TITLE).getText());
				}
				return titleAirlines;
			} catch (Exception e) {
				++n;
			}
		} while (n < Numbers.THIRTY.getNumber());
		log.error("Error airlines titles");
		return null;
	}
	
	public boolean isCorrectSorting(List<String> airlines, String requiredAirline) {
		for(int i = 0, l = airlines.size(); i < l; ++i) {
			if(!requiredAirline.equals(airlines.get(i))) {
				return false;
			}
		}
		return true;
	}
}