package a1qa.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import a1qa.framework.elements.Combobox;
import a1qa.framework.pages.BasePage;
import a1qa.google.elements.header.Header;
import a1qa.google.utils.NavBar;

public class HomePage extends BasePage {

	private final static By HOME_PAGE_LOCATOR = By.xpath("//div[contains(@class, 'home_page')]");

	public HomePage() {
		super(HOME_PAGE_LOCATOR);
		log.info("Opened home page");
	}

	public HomePage pointNavbar(By locator) {
		log.info("Point to an element in navbar");
		new Combobox(NavBar.LOCATOR_NAV_BAR.getLocator()).fetchListElements(NavBar.ELEMENTS_NAV_BAR.getLocator())
				.findElement(locator).pointToElement();
		return this;
	}
	
	public Header choiceHeader() {
		log.info("Choice header");
		return new Header();
	}

	public WebElement choiceElementNavbar(By locator) {
		log.info("Click element in combobox in navbar");
		element = new Combobox(NavBar.COMBO_BOX_GAMES_BAR.getLocator())
				.fetchListElements(NavBar.ELEMENTS_GAMES_BAR.getLocator()).findElement(locator).getElement();
		return element;
	}
}