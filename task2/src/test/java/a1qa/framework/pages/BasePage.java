package a1qa.framework.pages;

import org.openqa.selenium.By;

import a1qa.framework.entity.MainForEntityFramework;

public abstract class BasePage extends MainForEntityFramework{
	
	public BasePage(By locator) {
		super(locator);
	}
}