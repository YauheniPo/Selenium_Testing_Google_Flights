package a1qa.framework.browser_manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEBrowser extends BaseBrowser {

	protected final String NAME_DRIVER = "IEDriverServer";
	
	public IEBrowser() {
		String keyDriver = "webdriver.ie.driver";
		
		setConfigurationOfBrowser(keyDriver, getNameDriver(NAME_DRIVER));
		driver = new InternetExplorerDriver();
	}

	public WebDriver getDriver() {
		return driver;
	}
}