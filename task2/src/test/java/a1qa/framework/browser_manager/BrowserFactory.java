package a1qa.framework.browser_manager;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import a1qa.framework.test.BaseTest;

public abstract class BrowserFactory {
	
	protected WebDriver driver;
	protected Logger log = BaseTest.log;
	
	public abstract WebDriver getDriver();
}