package a1qa.google.utils;

import org.openqa.selenium.By;

public enum SortingCheckBox {
	
	INDIE("492"),
	STRATEGY("9"),
	ACTION("19"),
	SINGLE_PLAYER("2"),
	WINDOWS("win");
	
	private String dataValue;
	
	SortingCheckBox(String value) {
		this.dataValue = value;
	}
	
	private final String START_X_PATH = "//div[@data-value='";
	private final String END_X_PATH = "']";
	
	public By getXpath() {
		StringBuffer path = new StringBuffer(START_X_PATH).append(dataValue).append(END_X_PATH);
		return By.xpath(path.toString());
	}
}
