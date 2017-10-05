package a1qa.google.utils;

import org.openqa.selenium.By;

public class SteamLocators {

	public static final By SPINNER_CHANGE_LANG = By.xpath("//div[contains(@class, 'newmodal')]");
	public static final By LOGO_LOCATOR = By.xpath("//span[contains(@id, 'logo')]");

	public static final By LOCATOR_SPECIALS = By.xpath("//div[contains(@id, 'tab_select_Discounts')]");
	public static final By TABBAR = By.xpath("//div[contains(@class, 'tabbar store')]");
	public static final By TABBAR_ELEMENT = By.xpath("//div[contains(@class, 'tabbar store')]/*");
	
	public static final By LOCATOR_SORT_CHECKING = By.xpath("//div[@class='tab_filters']");
	public static final By LOCATOR_ELEMENT_SORT_CHECKING = By.xpath("//div[@class='tab_filter']");
	public static final By LOCATOR_SET_GAMES = By.xpath("//div[contains(@id, 'DiscountsRows')]");
	public static final By LOCATOR_GAME_NAME = By.xpath(".//div[@class='tab_item_name']");
	public static final By LOCATOR_GAME_PRICE = By.xpath(".//div[@class='discount_final_price']");
	public static final By LOCATOR_GAME_DISCOUNT_PCT = By.xpath(".//div[@class='discount_pct']");
	public static final By LOCATOR_SET_GAME_TAGS = By.xpath(".//div[contains(@class, 'tab_item_top_tags')]");
	public static final By LOCATOR_GAME_TAGS = By.xpath(".//span[contains(@class, 'tag')]");
	public static final By PATH_TO_PAGE = By.xpath("//div[contains(@class, 'breadcrumbs')]");
	public static final By ELEMENT_TAG_GAME = By.xpath("//div[@data-tagid]");

	public static final By FORM = By.xpath("//form[contains(@id, 'agecheck')]");
	public static final By FORM_YEAR = By.xpath("//select[contains(@id, 'ear')]");
	public static final By FORM_ENTER = By.xpath("//a[contains(@onclick, 'ubmit')]");
}