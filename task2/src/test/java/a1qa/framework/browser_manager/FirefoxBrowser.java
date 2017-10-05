package a1qa.framework.browser_manager;

import static a1qa.framework.utils.ConstantValue.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxBrowser extends BaseBrowser {
	
	private final String NAME_DRIVER = "geckodriver";
	
	public FirefoxBrowser() {
		String keyDriver = "webdriver.gecko.driver";

		setConfigurationOfBrowser(keyDriver, getNameDriver(NAME_DRIVER));

		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("browser.download.dir", PATH_FOR_ARTIFACTS);
		options.addPreference("browser.download.folderList", 2);
		options.addPreference("browser.helperApps.neverAsk.saveToDisk",
				"application/x-debian-package; application/octet-stream");
		options.addPreference("browser.download.manager.showWhenStarting", false);
		options.addPreference("pdfjs.disabled", true);
		options.addPreference("browser.helperApps.alwaysAsk.force", false);
		options.addPreference("intl.accept_languages", "en");
		driver = new FirefoxDriver(options);
	}

	public WebDriver getDriver() {
		return driver;
	}
}