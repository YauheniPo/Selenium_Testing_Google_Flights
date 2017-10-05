package a1qa.google.pages;

import static a1qa.google.utils.SteamLocators.*;
import static org.testng.Assert.*;

import org.openqa.selenium.By;

import a1qa.framework.elements.Combobox;
import a1qa.framework.pages.BasePage;

public class ActionPage extends BasePage {

	public ActionPage(String name) {
		super(PATH_TO_PAGE);
		assertTrue(getElement().getText().endsWith(name), "Another page is open");
		log.info("A page with discount games was opened");
	}
	
	public ActionPage clickTab(By locator) {
		log.info("Click tab store");
		new Combobox(TABBAR).fetchListElements(TABBAR_ELEMENT).clickElement(locator);
		return this;
	}
}