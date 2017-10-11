package a1qa.framework.test;

import static a1qa.framework.utils.ConstantValue.*;
import static org.testng.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import a1qa.framework.browser_manager.BrowserManager;
import a1qa.framework.utils.ConfigLogger;
import a1qa.framework.utils.ConfigReader;

public class BaseTest {

	public Properties properties = ConfigReader.getInstance().getProperties();
	public WebDriver driver;
	public static Logger log = ConfigLogger.getInstance().getLogger();

	public void setUp() {
		BrowserManager.setDriverNull();
		driver = BrowserManager.getInstance(properties.getProperty(PROP_BROWSER)).getDriver();
		assertNotNull(driver, "Error creating a driver of browser");
		removeMouse();
		setTimeOut(Integer.parseInt(properties.getProperty(PROP_BROWSER_TIMEOUT)));
	}

	public void before() {
		openSite();
	}
	
	public void after() {
		BrowserManager.getInstance(properties.getProperty(PROP_BROWSER)).quit();
	}

	public void openSite() {
		setUp();
		driver.get(properties.getProperty(PROP_URL));
	}

	public void setTimeOut(int timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.MILLISECONDS);
	}
	
	public static void sleepTimeout(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			log.error("Error sleep timeout" + e.getMessage());
		}
	}

	private void removeMouse() {
		int pos_x = 0;
		int pos_y = 0;
		Robot ro = null;

		try {
			ro = new Robot();
		} catch (AWTException e) {
			log.info("Error mouse retraction " + e.getMessage());
		}
		ro.mouseMove(pos_x, pos_y);
	}
}