package a1qa.framework.entity.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import a1qa.framework.entity.AbstractEntity;

public abstract class BaseElement extends AbstractEntity {
	
	public BaseElement(By locator) {
		super(locator);
	}
	
	public WebElement getElement() {
		return element;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
}