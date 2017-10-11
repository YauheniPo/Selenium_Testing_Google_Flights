package a1qa.framework.entity.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
	
	public void pointToElement(By locator) {
		log.info("Move the cursor over an element");
		Actions action = new Actions(driver);
		WebElement elem = driver.findElement(locator);
		action.moveToElement(elem);
		action.perform();
	}

	public WebElement pointToElement() {
		log.info("Point to element");
		Actions action = new Actions(driver);
		action.moveToElement(element);
		action.perform();
		return element;
	}
}