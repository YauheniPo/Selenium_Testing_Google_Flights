package a1qa.google.flights.elements;

import static a1qa.framework.utils.ConstantValue.*;
import static org.testng.Assert.*;
import static a1qa.google.flights.utils.Locators.*;

import org.openqa.selenium.By;

import a1qa.framework.entity.elements.BaseElement;
import a1qa.framework.entity.elements.Button;
import a1qa.framework.entity.elements.Combobox;
import a1qa.framework.entity.elements.Label;
import a1qa.framework.utils.Language;
import a1qa.google.flights.utils.CurrenciesLocators;
import a1qa.google.flights.utils.LanguagesLocators;

public class LeftNavBar extends BaseElement{
	
	private final static By LEFT_BAR = By.xpath("//div[contains(@class, 'w-x')]");
	private final By LANGUAGE = By.xpath("//div[contains(text(), 'anguage')]");
	private final By LANG_COMBOBOX = By.xpath("//div[contains(@class, 'c-h')]");
	private final By CURRENCY = By.xpath("//div[contains(@class, 'w-d')]/div[1]");
	private final By CURRENCY_COMBOBOX = By.xpath("//div[contains(@class, 'S-b')]");

	public LeftNavBar() {
		super(LEFT_BAR);
		log.info("Open left bar");
	}

	public void choiceLanguage() {
		log.info("Сlicked on the desired language");
		final String propLang = properties.getProperty(PROP_LANG);

		log.info("Checked language " + propLang);
		String currentLanguage = getAttribute(HTML, INPUT_ATRIBUTE_LANG);
		if (currentLanguage.indexOf(propLang) < 0) {
			Language language;
			try {
				language = Language.valueOf(propLang.toUpperCase());
			} catch (EnumConstantNotPresentException e) {
				language = Language.EN;
			}
			log.info("Swap language");
			fluentWaitForPresenceOf(LANGUAGE);
			new Button(LANGUAGE).clickBnt();
			swapLang(language);
		}
	}

	private void swapLang(Language lang) {
		element = new Combobox(LANG_COMBOBOX).getElement();
		
		log.info("Change the language to " + lang.toString());
		By langLocator = LanguagesLocators.valueOf(lang.toString()).getLocator();
		fluentWaitForPresenceOf(langLocator);
		element.findElement(langLocator).click();
		setWaitClickable(LEFT_NAV_BAR);
		assertTrue(getAttribute(HTML, INPUT_ATRIBUTE_LANG).indexOf(properties.getProperty(PROP_LANG)) >= 0, "Error swap language");
	}
	
	public void selectСurrency(String currency) {
		if (new Label(CURRENCY).getTitleLabel().indexOf(currency) < 0) {
			setWaitClickable(CURRENCY);
			new Button(CURRENCY).clickBnt();
			element = new Combobox(CURRENCY_COMBOBOX).getElement();

			log.info("Change the currency");
			element.findElement(CurrenciesLocators.valueOf(currency).getLocator()).click();
		}
		log.info("Checking currency");
		assertTrue(new Label(CURRENCY).getTitleLabel().indexOf(currency.toString()) >= 0, "Error swap currency");
	}
}