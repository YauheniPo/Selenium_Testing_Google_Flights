package a1qa.google.pages;

import org.openqa.selenium.By;

import a1qa.framework.elements.Combobox;
import a1qa.framework.pages.BasePage;

public class GamePage extends BasePage {
	
	public static final By LOCATOR_GAME_PAGE_NAME = By.xpath("//*[@class='apphub_AppName' or @class='pageheader']");
	private final By LOCATOR_GAME_PAGE_PRICE = By.xpath("//div[contains(@id, 'purchase')]//div[contains(@class, 'final_price')]");
	private final By LOCATOR_GAME_PAGE_DISCOUNT = By.xpath("//div[contains(@id, 'purchase')]//div[contains(@class, 'pct')]");
	private final By BTN_ALL_TAG_GAME = By.xpath("//div[contains(@onclick, 'AppTag')]");
	private final By LOCATOR_TAG_GAME = By.xpath("//div[contains(@class, 'app_tags')]");

	public GamePage() {
		super(LOCATOR_GAME_PAGE_NAME);
		log.info("A page with games was opened");
	}
	
	public String getName() {
		log.info("Find name field");
		return getElement().getText();
	}
	
	public String getDiscount() {
		log.info("Find discount field");
		return getElement(LOCATOR_GAME_PAGE_DISCOUNT).getText();
	}
	
	public String getPrice() {
		log.info("Find price field");
		return getElement(LOCATOR_GAME_PAGE_PRICE).getText();
	}
	
	public Combobox switchAllTags() {
		log.info("Click all tags button of game");
		clickElement(BTN_ALL_TAG_GAME);
		return new Combobox(LOCATOR_TAG_GAME);
	}
}