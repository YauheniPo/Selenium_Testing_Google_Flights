package a1qa.google.utils;

import org.openqa.selenium.By;

public enum UserMenuButton {
	
	LOGOUT("ogout')]"),
	ACCOUNT_DETAILS("account')][1]"),
	VIEW_PROVILE("profiles')]");
	
	private String dataValue;
	
	UserMenuButton(String value) {
		this.dataValue = value;
	}
	
	private final String START_X_PATH = "//div[@id='account_dropdown']//a[contains(@href, '";
	
	public By getXpath() {
		StringBuffer path = new StringBuffer(START_X_PATH).append(dataValue);
		return By.xpath(path.toString());
	}
}