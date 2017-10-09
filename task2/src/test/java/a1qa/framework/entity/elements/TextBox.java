package a1qa.framework.entity.elements;

import org.openqa.selenium.By;

public class TextBox extends BaseElement {

	public TextBox(By locator) {
		super(locator);
		log.info("Found input field");
	}
	
	public TextBox inputData(String text) {
		log.info("Entered data");
		element.sendKeys(text);
		return this;
	}
	
	public TextBox clearData() {
		log.info("Cleared the data");
		element.clear();
		return this;
	}
	
	public String getText() {
		return element.getText();
	}
}