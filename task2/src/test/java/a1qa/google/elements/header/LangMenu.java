package a1qa.google.elements.header;

import static a1qa.framework.utils.ConstantValue.*;
import static a1qa.google.utils.SteamLocators.*;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import a1qa.framework.utils.Language;
import a1qa.framework.utils.TimeoutConfig;
import a1qa.google.pages.HomePage;

public class LangMenu extends Header {

	private static final By LOCATOR_LANG = By.xpath("//span[@id='language_pulldown']");
	private final By ENG_LOCATOR = By.xpath("//a[contains(@href, 'nglish')]");
	private final By CZ_LOCATOR = By.xpath("//a[contains(@href, 'zech')]");
	private final String ATRIBUTE_LANG = "lang";

	public LangMenu() {
		super(LOCATOR_LANG);
		log.info("Found the head language menu");
	}

	public HomePage swapLang(By locator) {
		log.info("Сlicked on the desired language");
		clickElement(locator);
		waitingForDownload(SPINNER_CHANGE_LANG, TimeoutConfig.SPINNER.getTimeout());
		return new HomePage();
	}

	public void choiceLanguage() {
		final String propLang = properties.getProperty(PROP_LANG).toUpperCase();

		log.info("Checked language " + propLang);
		String currentLanguage = getAttribute(HTML, ATRIBUTE_LANG).toUpperCase();
		if (!currentLanguage.equals(propLang)) {
			Language language;
			try {
				language = Language.valueOf(propLang.toUpperCase());
			} catch (EnumConstantNotPresentException e) {
				language = Language.EN;
			}
			log.info("Swap language");
			clickElement(LOCATOR_LANG);
			swapLang(language);
		}
	}

	private void swapLang(Language lang) {
		switch (lang) {
		case CS:
			log.info("Change the language to Czech");
			new LangMenu().swapLang(CZ_LOCATOR);
			break;
		case EN:
			log.info("Change the language to English");
			new LangMenu().swapLang(ENG_LOCATOR);
			break;
		default:
			log.info("Default language change to English");
			new LangMenu().swapLang(ENG_LOCATOR);
			break;
		}
		assertEquals(getAttribute(HTML, ATRIBUTE_LANG).toUpperCase(), properties.getProperty(PROP_LANG).toUpperCase(),
				"Error swap language");
	}
}