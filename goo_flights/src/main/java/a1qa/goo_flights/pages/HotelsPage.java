package a1qa.goo_flights.pages;

import static a1qa.goo_flights.utils.Locators.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import a1qa.framework.entity.elements.Button;
import a1qa.framework.entity.elements.Combobox;
import a1qa.framework.entity.pages.BasePage;
import a1qa.framework.utils.TimeoutConfig;

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
		fluentWaitForVisibilityOf(HOTELS_PAGE_MAP);
		setWaitClickable(HOTELS_PRICE_TAG);
		new Button(HOTELS_PRICE_TAG).clickBnt();
		waitingForDownload(SPINNER, TimeoutConfig.SECONDS.getTimeout());
		return this;
	}
	
	public List<WebElement> getListHotels() {
		log.info("Fetch hotels list");
		fluentWaitForVisibilityOf(HOTELS_ELEMENT_PRICE);
		List<WebElement> list = new Combobox(HOTELS).fetchListElements(HOTELS_ELEMENT).getListElements();
		return list;
	}
}