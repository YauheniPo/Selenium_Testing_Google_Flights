package a1qa.google.flights.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import a1qa.framework.elements.Button;
import a1qa.framework.elements.Combobox;
import a1qa.framework.pages.BasePage;
import a1qa.framework.utils.TimeoutConfig;

import static a1qa.google.flights.utils.Locators.*;

public class HotelsPage extends BasePage {
	
	private static final By HOTELS_PAGE_LOCATOR = By.xpath("//div[@id='bpfc']");
	private final By HOTELS_PAGE_MAP = By.xpath("//div[@class='gm-style']");
	private final By HOTELS = By.xpath("//div[contains(@class, 'rlfl__tls rl_tls r')]");
	private final By HOTELS_ELEMENT = By.xpath("./div[@jstcache='0']");
	private final By HOTELS_PRICE_TAG = By.xpath("//div[@data-idx='1']/span");
	public static final By HOTELS_ELEMENT_PRICE = By.xpath(".//div[@class='_cYm']");
		
	public HotelsPage() {
		super(HOTELS_PAGE_LOCATOR);
		log.info("Opened hotels page");
	}
	
	public HotelsPage clickPriceTag() {
		log.info("Click price tag");
		fluentWaitForPresenceOf(HOTELS_PAGE_MAP);
		setWaitClickable(HOTELS_PRICE_TAG);
		new Button(HOTELS_PRICE_TAG).clickBnt();
		waitingForDownload(SPINNER, TimeoutConfig.SECONDS.getTimeout());
		return this;
	}
	
	public List<WebElement> getListHotels() {
		log.info("Fetch hotels list");
		fluentWaitForPresenceOf(HOTELS_ELEMENT_PRICE);
		List<WebElement> list = new Combobox(HOTELS).fetchListElements(HOTELS_ELEMENT).getListElements();
		return list;
	}
}