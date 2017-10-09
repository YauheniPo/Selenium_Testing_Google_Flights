package a1qa.framework.browser_manager;

import static a1qa.framework.utils.ConstantValue.*;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import a1qa.framework.test.BaseTest;
import a1qa.framework.utils.ConfigReader;

public abstract class BaseBrowser {

	protected WebDriver driver;
	protected Properties properties = ConfigReader.getInstance().getProperties();
	protected Logger log = BaseTest.log;
	protected final String EXE = ".exe";

	protected abstract WebDriver getDriver();
	
	protected String capabilityName = "marionette";

	protected void setConfigurationOfBrowser(String keyDriver, String nameDriver) {
		log.info("Browser settings");
		DesiredCapabilities capabilitiesBrowser = new DesiredCapabilities();
		capabilitiesBrowser.setCapability(capabilityName, true);
		Path path = FileSystems.getDefault().getPath(properties.getProperty(PROP_RESOURCES_FOLDER), File.separator,
				nameDriver);
		String pathDriver = path.toAbsolutePath().toString();
		System.setProperty(keyDriver, pathDriver);
	}
	
	protected String getNameDriver(String nameDriver) {
		StringBuffer fullNameDriver = new StringBuffer(nameDriver);
		switch(SYSTEM_OC) {
		case NAME_WINDOWS:
			fullNameDriver.append(EXE);
			break;
		case NAME_LINUX:
		case NAME_UNIX:
			break;
		default:
			log.error("Error of Browser settings");
		}
		return fullNameDriver.toString();
	}
}