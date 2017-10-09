package a1qa.framework.entity.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EntityElement extends BaseElement {

	public EntityElement(By locator) {
		super(locator);
	}
	
	public WebElement getEntityElement() {
		return element;
	}
}