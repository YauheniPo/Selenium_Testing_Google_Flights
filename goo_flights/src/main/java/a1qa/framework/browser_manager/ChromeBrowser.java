package a1qa.framework.browser_manager;

import static a1qa.framework.utils.ConstantValue.*;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser extends BaseBrowser {

	private final String NAME_DRIVER = "chromedriver";
	
	public ChromeBrowser() {
		String keyDriver = "webdriver.chrome.driver";
		
		setConfigurationOfBrowser(keyDriver, getNameDriver(NAME_DRIVER));
		driver = new ChromeDriver(setProperty());
	}

	@Override
	public WebDriver getDriver() {
		return driver;
	}

	private ChromeOptions setProperty() {
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("safebrowsing.enabled", "true"); 
		prefs.put("download.default_directory", PATH_FOR_ARTIFACTS);
		options.setExperimentalOption("prefs", prefs);
		return options;
	}
}