package a1qa.goo_flights.pages;

import static a1qa.goo_flights.utils.Locators.*;
import static a1qa.goo_flights.elements.LeftNavBar.*;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;

import a1qa.goo_flights.elements.Header;
import a1qa.goo_flights.elements.LeftNavBar;
import a1qa.framework.entity.elements.Button;
import a1qa.framework.entity.elements.EntityElement;
import a1qa.framework.entity.elements.Label;
import a1qa.framework.entity.elements.TextBox;
import a1qa.framework.entity.pages.BasePage;
import a1qa.framework.utils.Numbers;
import a1qa.framework.utils.TimeoutConfig;

public class HomePage extends BasePage {

	private static final By HOME_PAGE_LOCATOR = By.xpath("//div[contains(@class, 'Q-g')]");
	private final By HOME_PAGE_PLACES = By.xpath("//div[@class='DQX2Q1B-Q-r'][1]//div[contains(@class, 'Q-v')]");
	private final By HOME_PAGE_PLACE_INPUT = By.xpath("//div[contains(@class, 'Q-g')]//input");
	private final By HOME_PAGE_PLACE = By.xpath("//div[contains(@class, 'nb-a')]");
	private final By HOME_PAGE_PLACE_FLIGHTS = By.xpath("//div[@class='DQX2Q1B-K-M DQX2Q1B-K-t']");
	private final By HOME_PAGE_PLACE_HOTELS = By.xpath("//div[contains(@class, 'K-x')]");
	private final By HOME_PAGE_PLACE_NAME = By.xpath(".//div[contains(@class, 'nb-u')]");
	private final By HOME_PAGE_PLACE_CONTENT = By.xpath("//div[contains(@class, 'ontent')]/div");
	public static final By HOME_PAGE_PLACE_PRICE = By.xpath(".//span[contains(@class, 'nb-p')]");

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
		fluentWaitForVisibilityOf(HOME_PAGE_PLACES);
		int n = 0;
		do {
			try {
				Thread.sleep(TimeoutConfig.MIN.getTimeout());
				new Button(HOME_PAGE_PLACES).clickBnt();
				return this;
			} catch (Exception e) {
				++n;
			}
		} while (n < Numbers.THIRTY.getNumber());
		log.error("Click error places tab");
		return this;
	}
	
	public HomePage typePlace(String place) {
		log.info("Place input");
		int n = 0;
		do {
			try {
				fluentWaitForPresenceOf(HOME_PAGE_PLACE_INPUT);
				Thread.sleep(TimeoutConfig.MIN.getTimeout());
				new TextBox(HOME_PAGE_PLACE_INPUT).clearData().inputData(place);
				return this;
			} catch (Exception e) {
				++n;
			}
		} while (n < Numbers.THIRTY.getNumber());
		log.error("Error place input");
		return null;
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
		fluentWaitForVisibilityOf(HOME_PAGE_PLACE);
		return new EntityElement(HOME_PAGE_PLACE).getEntityElement().findElement(HOME_PAGE_PLACE_NAME).getText();
	}
	
	public String getPlacePrice() {
		log.info("Fetch place price");
		fluentWaitForVisibilityOf(HOME_PAGE_PLACE);
		return new EntityElement(HOME_PAGE_PLACE).getEntityElement().findElement(HOME_PAGE_PLACE_PRICE).getText();
	}
	
	public String getPlaceContent() {
		log.info("Fetch place content");
		fluentWaitForVisibilityOf(HOME_PAGE_PLACE_CONTENT);
		int n = 0;
		do {
			try {
				Thread.sleep(TimeoutConfig.MIN.getTimeout());
				String title = new Label(HOME_PAGE_PLACE_CONTENT).getTitleLabel().trim();
				return title;
			} catch (Exception e) {
				++n;
			}
		} while (n < Numbers.THIRTY.getNumber());
		log.error("Error place content");
		return null;
	}
	
	public boolean checkCurrency(String currency) {
		log.info("Checking currency " + currency);
		String currencyPage = null;
		int n = 0;
		do {
			try {
				Thread.sleep(TimeoutConfig.MIN.getTimeout());
				currencyPage= new Label(CURRENCY).getTitleLabel();
				if(currencyPage.indexOf(currency.toString()) >= 0);
					return true;
			} catch (ElementNotInteractableException | InterruptedException e) {
				++n;
			}
			++n;
		} while (n < Numbers.THIRTY.getNumber());
		log.error("Error currency");
		return false;
	}
}