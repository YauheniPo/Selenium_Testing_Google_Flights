package a1qa.google.flights.elements;

import static a1qa.framework.utils.ConstantValue.*;
import static org.testng.Assert.*;
import static a1qa.google.flights.utils.Locators.*;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;

import a1qa.framework.entity.elements.BaseElement;
import a1qa.framework.entity.elements.Button;
import a1qa.framework.entity.elements.Combobox;
import a1qa.framework.entity.elements.Label;
import a1qa.framework.utils.Language;
import a1qa.framework.utils.Numbers;
import a1qa.framework.utils.TimeoutConfig;
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
			fluentWaitForVisibilityOf(LANGUAGE);
			new Button(LANGUAGE).clickBnt();
			swapLang(language);
		}
	}

	private void swapLang(Language lang) {
		fluentWaitForPresenceOf(LANG_COMBOBOX);
		element = new Combobox(LANG_COMBOBOX).getElement();
		
		log.info("Change the language to " + lang.toString());
		By langLocator = LanguagesLocators.valueOf(lang.toString()).getLocator();
		fluentWaitForVisibilityOf(langLocator);
		element.findElement(langLocator).click();
		int n = 0;
		do {
			try {
				Thread.sleep(TimeoutConfig.MIN.getTimeout());
				if(getAttribute(HTML, INPUT_ATRIBUTE_LANG).indexOf(properties.getProperty(PROP_LANG)) >= 0) {
					log.info("Checking site language");
					return;
				}
			} catch (ElementNotInteractableException | InterruptedException e) {
				++n;
			}
		} while (n < Numbers.THIRTY.getNumber());
		log.error("Error swap language");
	}
	
	public void selectCurrency(String currency) {
		fluentWaitForVisibilityOf(CURRENCY);
		if (new Label(CURRENCY).getTitleLabel().indexOf(currency) < 0) {
			setWaitClickable(CURRENCY);
			new Button(CURRENCY).clickBnt();
			element = new Combobox(CURRENCY_COMBOBOX).getElement();

			log.info("Change the currency");
			element.findElement(CurrenciesLocators.valueOf(currency).getLocator()).click();
		}
		log.info("Checking currency");
		fluentWaitForVisibilityOf(CURRENCY);
		String currencyPage = null;
		int n = 0;
		do {
			try {
				Thread.sleep(TimeoutConfig.MIN.getTimeout());
				currencyPage= new Label(CURRENCY).getTitleLabel();
				assertTrue(currencyPage.indexOf(currency.toString()) >= 0, "Error swap currency");
				return;
			} catch (ElementNotInteractableException | InterruptedException e) {
				++n;
			}
		} while (n < Numbers.THIRTY.getNumber());
		log.error("Error place content");
	}
}