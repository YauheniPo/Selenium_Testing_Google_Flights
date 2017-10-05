package a1qa.framework.browser_manager;

import org.openqa.selenium.WebDriver;

public enum Browsers {
	
	CHROME {
		@Override
		public WebDriver getBrowser() {
			WebDriver driver = new ChromeBrowser().getDriver();
			setPropertyWindow(driver);
			return driver;
		}
	},
	FIREFOX {
		@Override
		public WebDriver getBrowser() {
			WebDriver driver = new FirefoxBrowser().getDriver();
			return driver;
		}
	},
	IE {
		@Override
		public WebDriver getBrowser() {
			WebDriver driver = new IEBrowser().getDriver();
			setPropertyWindow(driver);
			return driver;
		}
	};
	
	public abstract WebDriver getBrowser();
	
	protected WebDriver setPropertyWindow(WebDriver driver) {
		driver.manage().window().maximize();
		return driver;
	}
}