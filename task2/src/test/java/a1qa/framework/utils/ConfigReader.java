package a1qa.framework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class ConfigReader {

	private static ConfigReader instance;
	private Properties properties;

	public ConfigReader() {
		String configFile = "src/test/resources/config.properties";
		
		properties = new Properties();
		InputStream input = null;
		try {
			Path path = FileSystems.getDefault().getPath(configFile);
			String pathConf = path.toAbsolutePath().toString();
			input = new FileInputStream(pathConf);
			properties.load(input);
		} catch (IOException e) {
			ConfigLogger.getInstance().getLogger().error("Error loading of properties file " + e.getMessage());
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					ConfigLogger.getInstance().getLogger().error("Error closing of properties file " + e.getMessage());
				}
			}
		}
	}
	
	public static synchronized ConfigReader getInstance() {
		if (instance == null) {
			instance = new ConfigReader();
		}
		return instance;
	}
	
	public Properties getProperties() {
		return properties;
	}
}