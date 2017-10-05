package a1qa.google.flights.pages;

import org.openqa.selenium.By;

import a1qa.framework.elements.Button;
import a1qa.framework.elements.TextBox;
import a1qa.framework.pages.BasePage;
import a1qa.google.flights.elements.Header;
import a1qa.google.flights.elements.LeftNavBar;

import static a1qa.google.flights.utils.Locators.*;

import java.util.StringTokenizer;

public class HomePage extends BasePage {

	private final static By HOME_PAGE_LOCATOR = By.xpath("//div[contains(@class, 'Q-g')]");
	private final By HOME_PAGE_PLACES = By.xpath(".//*[@id='root']/div[3]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div/div/div[4]/div[2]/div[3]");
	private final By HOME_PAGE_PLACE_INPUT = By.xpath("//div[contains(@class, 'Q-g')]//input");
	private final By HOME_PAGE_PLACE_CONTENT = By.xpath("//div[contains(@class, 'ontent')]/div");

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
		log.info("Click place tag");
		new Button(HOME_PAGE_PLACES).clickBnt();
		return this;
	}
	
	public HomePage typePlace(String place) {
		log.info("Place input");
		setWaitClickable(HOME_PAGE_PLACE_INPUT);
		new TextBox(HOME_PAGE_PLACE_INPUT).inputData(place);
		return this;
	}
	
	public HomePage clickPlaceResult(String place) {
		log.info("Click place result");
		String content = getElement(HOME_PAGE_PLACE_CONTENT).getText().trim();
		StringTokenizer tokenizer = new StringTokenizer(content, ", "); 
		while (tokenizer.hasMoreTokens()) {
			if(place.indexOf(tokenizer.nextToken()) < 0) {
				log.error("Incorrected place result");
				return null;
			}
		}
		new Button(HOME_PAGE_PLACE_CONTENT).clickBnt();
		return this;
	}
}