package a1qa.google.elements.header;

import org.openqa.selenium.By;

public class AccountMenu extends Header {

	private static final By LOCATOR_ACCOUNT_MENU = By.xpath("//span[contains(@id, 'account_pulldown')]");
	private final By SET_USER_MENU = By.xpath("//div[@id='account_dropdown']/div");
	private final By ELEMENT_SET_USER_MENU = By.xpath("//div[@id='account_dropdown']/div[contains(@class, 'menu')]/a");

	public AccountMenu() {
		super(LOCATOR_ACCOUNT_MENU);
		log.info("Found account menu");
	}
	
	public AccountMenu clickMenu() {
		log.info("Click account menu");
		element.click();
		return this;
	}
	
	public void clickButton(By locator) {
		choiceComboBox(SET_USER_MENU).fetchListElements(ELEMENT_SET_USER_MENU).clickElement(locator);
	}
}