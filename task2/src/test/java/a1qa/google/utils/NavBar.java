package a1qa.google.utils;

import static a1qa.framework.utils.ConstantValue.*;

import org.openqa.selenium.By;

import a1qa.framework.utils.ConfigReader;
import a1qa.framework.utils.Language;

public enum NavBar {
	
	
	LOCATOR_NAV_BAR(By.xpath("//div[@class='store_nav']")),
	ELEMENTS_NAV_BAR(By.xpath("//div[contains(@id, '_tab')]")),
	GAMES(By.xpath("//div[contains(@id, 'genre_tab')]")),
	COMBO_BOX_GAMES_BAR(By.xpath("//div[@id='genre_flyout']/div")),
	ELEMENTS_GAMES_BAR(By.xpath("//div[@id='genre_flyout']//a"));
	
	private By locator;
	public static final By BTN_ACTION = (ConfigReader.getInstance().getProperties().getProperty(PROP_LANG).toUpperCase()
			.equals(Language.EN.toString())) ? By.xpath(".//div[contains(@id, 'genre')]//a[contains(@href, 'ction')]")
					: By.xpath(".//div[contains(@id, 'genre')]//a[contains(@href, '/Ak')]");
	public static final By BTN_CASUAL = (ConfigReader.getInstance().getProperties().getProperty(PROP_LANG).toUpperCase()
			.equals(Language.EN.toString())) ? By.xpath(".//div[contains(@id, 'genre')]//a[contains(@href, 'asual')]")
					: By.xpath(".//div[contains(@id, 'genre')]//a[contains(@href, '/Nen')]");
			
	
	NavBar(By locator) {
		this.locator = locator;
	}
	
	public By getLocator() {
		return locator;
	}
}