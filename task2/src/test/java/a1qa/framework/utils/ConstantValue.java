package a1qa.framework.utils;

import java.io.File;
import java.nio.file.FileSystems;

import org.openqa.selenium.By;

public class ConstantValue {

	public static final String OC_NAME = "os.name";
	public static final String NAME_WINDOWS = "Win";
	public static final String NAME_LINUX = "Lin";
	public static final String NAME_UNIX = "Uni";
	
	public static final String PROP_BROWSER = "browser";
	public static final String PROP_BROWSER_TIMEOUT = "browser.timeout";
	public static final String PROP_RESOURCES_FOLDER = "resources.folder";
	public static final String PROP_ARTIFACTS_FOLDER = "artifacts.folder";
	public static final String PROP_URL = "steam.url";
	public static final String PROP_LOG = "log.properties";
	public static final String PROP_LANG = "language.site";
	
	public static final String INPUT_ATRIBUTE_LANG = "lang";
	public static final String INPUT_ATRIBUTE_VALUE = "value";
	public static final String INPUT_ATRIBUTE_TITLE = "title";
	public static final String INPUT_ATRIBUTE_HREF = "href";
	
	public static final String NAME_BUTTON = "nameButton";
	public static final String EMPTY_STR = "";
	
	public static final String SYSTEM_OC = System.getProperty(OC_NAME).substring(Numbers.ZERO.getNumber(), Numbers.THREE.getNumber());

	public static final String PATH_FOR_ARTIFACTS = FileSystems.getDefault()
			.getPath(ConfigReader.getInstance().getProperties().getProperty(PROP_ARTIFACTS_FOLDER), File.separator)
			.toAbsolutePath().toString();
	
	public static final By HTML = By.xpath("html");
	public static final By TAG_SPAN = By.tagName("span");
}