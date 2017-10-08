package a1qa.google.flights.pages;

import org.openqa.selenium.By;

import a1qa.framework.elements.Button;
import a1qa.framework.elements.TextBox;
import a1qa.framework.pages.BasePage;
import a1qa.google.flights.elements.Header;
import a1qa.google.flights.elements.LeftNavBar;

import static a1qa.google.flights.utils.Locators.*;

public class HomePage extends BasePage {

	private static final By HOME_PAGE_LOCATOR = By.xpath("//div[contains(@class, 'Q-g')]");
	private final By HOME_PAGE_MAP = By.xpath("//div[contains(@class, 'O-a')]");
	private final By HOME_PAGE_PLACES = By.xpath("//div[@class='DQX2Q1B-Q-r'][1]");
	private final By HOME_PAGE_PLACE_INPUT = By.xpath("//div[contains(@class, 'Q-g')]//input");
	private final By HOME_PAGE_PLACE = By.xpath("//div[contains(@class, 'nb-a')]");
	private final By HOME_PAGE_PLACE_FLIGHTS = By.xpath("//div[@class='DQX2Q1B-K-M DQX2Q1B-K-t']");
	private final By HOME_PAGE_PLACE_HOTELS = By.xpath("//div[contains(@class, 'K-x')]");
	private final By HOME_PAGE_PLACE_NAME = By.xpath(".//div[contains(@class, 'nb-u')]");
	private final By HOME_PAGE_PLACE_PRICE = By.xpath(".//span[contains(@class, 'nb-p')]");
	public static final By HOME_PAGE_PLACE_CONTENT = By.xpath("//div[contains(@class, 'ontent')]/div");

	public HomePage() {
		super(HOME_PAGE_LOCATOR);
		log.info("Opened home page");
	}

	public LeftNavBar clickLeftBar() {
		log.info("Choice left bar");
		new Button(LEFT_NAV_BAR).clickBnt();
		return new LeftNavBar();
	}
	
	public Header choiceHeader() {
		log.info("Choice header");
		return new Header();
	}
	
	public HomePage clickPlacesTag() {
		log.info("Click places tag");
		fluentWaitForPresenceOf(HOME_PAGE_MAP);
		new Button(HOME_PAGE_PLACES).pointToElement().click();
		return this;
	}
	
	public HomePage typePlace(String place) {
		log.info("Place input");
		fluentWaitForPresenceOf(HOME_PAGE_PLACE_INPUT);
		new TextBox(HOME_PAGE_PLACE_INPUT).inputData(place);
		return this;
	}
	
	public HomePage clickPlaceResult() {
		log.info("Click place result");
		new Button(HOME_PAGE_PLACE_CONTENT).clickBnt();
		return this;
	}
	
	public HomePage clickPlace() {
		log.info("Click place");
		new Button(HOME_PAGE_PLACE).clickBnt();
		return this;
	}
	
	public HomePage clickPlaceFlights() {
		log.info("Click place");
		new Button(HOME_PAGE_PLACE_FLIGHTS).clickBnt();
		return this;
	}
	
	public HomePage clickPlaceHotels() {
		log.info("Click place");
		new Button(HOME_PAGE_PLACE_HOTELS).clickBnt();
		return this;
	}
	
	public String getPlaceName() {
		log.info("Fetch place name");
		fluentWaitForPresenceOf(HOME_PAGE_PLACE);
		return getElement(HOME_PAGE_PLACE).findElement(HOME_PAGE_PLACE_NAME).getText();
	}
	
	public String getPlacePrice() {
		log.info("Fetch place price");
		fluentWaitForPresenceOf(HOME_PAGE_PLACE);
		return getElement(HOME_PAGE_PLACE).findElement(HOME_PAGE_PLACE_PRICE).getText();
	}
}