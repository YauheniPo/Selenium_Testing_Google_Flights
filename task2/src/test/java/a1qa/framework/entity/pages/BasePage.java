package a1qa.framework.entity.pages;

import org.openqa.selenium.By;

import a1qa.framework.entity.AbstractEntity;

public abstract class BasePage extends AbstractEntity{
	
	public BasePage(By locator) {
		super(locator);
	}
}