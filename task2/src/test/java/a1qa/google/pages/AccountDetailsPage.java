package a1qa.google.pages;

import org.openqa.selenium.By;

import a1qa.framework.pages.BasePage;

public class AccountDetailsPage extends BasePage {
	
	private final static By ACCOUNT_CASH_LOCATOR = By.xpath("//div[contains(@class, 'price')]");

	public AccountDetailsPage() {
		super(ACCOUNT_CASH_LOCATOR);
		log.info("Account details page");
	}
	
	public String getWalletCash() {
		log.info("Find value of wallet");
		return getElement().getText();
	}
}