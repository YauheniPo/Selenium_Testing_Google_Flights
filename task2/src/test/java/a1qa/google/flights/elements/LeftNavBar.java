package a1qa.google.flights.elements;

import static a1qa.framework.utils.ConstantValue.*;
import static org.testng.Assert.*;

import org.openqa.selenium.By;

import a1qa.framework.elements.BaseElement;
import a1qa.framework.elements.Button;
import a1qa.framework.elements.Combobox;
import a1qa.framework.utils.Language;
import a1qa.google.flights.utils.Currency;
import a1qa.google.flights.utils.LanguagesLocators;

public class LeftNavBar extends BaseElement{
	
	private final static By LEFT_BAR = By.xpath("//div[contains(@class, 'w-x')]");
	private final static By LANGUAGE = By.xpath("//div[contains(text(), 'anguage')]");
	private final static By LANG_COMBOBOX = By.xpath("//div[contains(@class, 'c-h')]");
	private final static By CURRENCY = By.xpath("//div[contains(@class, 'w-d')]/div[1]");
	private final static By CURRENCY_COMBOBOX = By.xpath("//div[contains(@class, 'S-b')]");

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
			setWaitClickable(LANGUAGE);
			new Button(LANGUAGE).clickBnt();
			swapLang(language);
		}
	}

	private void swapLang(Language lang) {
		element = new Combobox(LANG_COMBOBOX).getElement();
		
		log.info("Change the language to " + lang.toString());
		element.findElement(LanguagesLocators.valueOf(lang.toString()).getLocator()).click();
		
		assertTrue(getAttribute(HTML, INPUT_ATRIBUTE_LANG).indexOf(properties.getProperty(PROP_LANG)) >= 0, "Error swap language");
	}
	
	public void selectСurrency(String currency) {
		if (getElement(CURRENCY).getText().indexOf(currency) < 0) {
			setWaitClickable(CURRENCY);
			new Button(CURRENCY).clickBnt();
			element = new Combobox(CURRENCY_COMBOBOX).getElement();

			log.info("Change the currency");
			element.findElement(Currency.valueOf(currency).getLocator()).click();
		}
		log.info("Checking currency");
		assertTrue(getElement(CURRENCY).getText().indexOf(currency.toString()) >= 0, "Error swap currency");
	}
}