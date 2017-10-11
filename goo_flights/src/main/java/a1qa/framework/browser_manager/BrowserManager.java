package a1qa.framework.browser_manager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class BrowserManager extends BrowserFactory {
	
	private static BrowserManager instance;
	
	private BrowserManager(String browser) {
		initializationBrowser(browser);
	}

	public static synchronized BrowserManager getInstance(String browser) {
		if (instance == null) {
			instance = new BrowserManager(browser);
		}
		return instance;
	}
	
	@Override
	public WebDriver getDriver() {
		return driver;
	}
	
	public static void setDriverNull() {
		instance = null;
	}
	
	public void back() {
		log.info("Click back");
		driver.navigate().back();
	}
	
	public void quit() {
		if (driver != null) {
			log.info("Browser close");
			driver.quit();	
			driver = null;
		}
	}
	
	public void refreshPage() {
		log.info("Refresh of page");
		driver.navigate().refresh();
		try {
			Alert alert = driver.switchTo().alert();
			log.info("A modal window appeared");
			alert.accept();
		} catch (NoAlertPresentException e) {
			log.info("There was no modal window" + e.getMessage());
		}
	}
	
	public void focusNewBrowserWindow() {
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
	}
	
	private void initializationBrowser(String browserName) {
		try {
			driver = Browsers.valueOf(browserName.toUpperCase()).getBrowser();
			log.info("Creating of driver browser");
		} catch (EnumConstantNotPresentException e) {
			driver = null;
			log.error("Error creating a driver of browser" + e.getMessage());
		}
	}
}