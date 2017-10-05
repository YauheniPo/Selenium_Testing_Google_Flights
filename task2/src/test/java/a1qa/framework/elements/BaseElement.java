package a1qa.framework.elements;

import org.openqa.selenium.By;

import a1qa.framework.entity.MainForEntityFramework;

public abstract class BaseElement extends MainForEntityFramework {
	
	public BaseElement(By locator) {
		super(locator);
	}
}