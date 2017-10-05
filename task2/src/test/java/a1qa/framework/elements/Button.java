package a1qa.framework.elements;

import org.openqa.selenium.By;

public class Button extends BaseElement {
	
	public Button(By locator) {
		super(locator);
		log.info("Found button");
	}
	
	public void clickBnt() {
		log.info("Click button");
		element.click();
	}
}