package a1qa.google.pages;

import static a1qa.google.utils.SteamConfig.*;

import org.openqa.selenium.By;

import a1qa.framework.elements.Combobox;
import a1qa.framework.elements.Label;
import a1qa.framework.pages.BasePage;
import a1qa.google.elements.header.Header;

public class UserProfilePage extends BasePage {

	private final static By BTN_EDIT_PROFILE_LOCATOR = By.xpath("//a[contains(@class, 'btn_profile')]");
	private final By BTN_NAMES_HISTORY = By.xpath("//img[contains(@id, 'getnamehistory')]");
	private final By ENUM_NAMES = By.xpath("//div[@id='NamePopupAliases']");
	private final By PERSONA_NAME_LOCATOR = By.xpath("//span[contains(@class, 'persona_name')]");
	
	public UserProfilePage() {
		super(BTN_EDIT_PROFILE_LOCATOR);
		log.info("Opened profile page");
	}
	
	public Header choiceHeader() {
		log.info("Choice header");
		return new Header();
	}
	
	public EditProfilePage choiceEditProfile() {
		log.info("Click edit profile");
		clickElement(BTN_EDIT_PROFILE_LOCATOR);
		return new EditProfilePage();
	}
	
	public UserProfilePage clickNamesHistory() {
		log.info("Click name history");
		clickElement(BTN_NAMES_HISTORY);
		return this;
	}
	
	public boolean isName(String name, int posit) {
		log.info("Compare texts");
		String text = new Combobox(ENUM_NAMES).fetchListElements(TAG_P).getElementFromList(posit).getText();
		return name.equals(text);
	}
	
	public Label checkName() {
		log.info("Checked for changes");
		return checkElementLabel(PERSONA_NAME_LOCATOR);
	}
}