package a1qa.framework.utils;

import static a1qa.framework.utils.ConstantValue.*;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ConfigLogger {
	
	private static ConfigLogger instance;
	private Properties properties = ConfigReader.getInstance().getProperties();
	private Logger log;

	public ConfigLogger() {
		String prop = "logfile";
		
		Path path = FileSystems.getDefault().getPath(properties.getProperty(PROP_RESOURCES_FOLDER), File.separator,
				properties.getProperty(PROP_LOG));
		String pathLog = path.toAbsolutePath().toString();
		PropertyConfigurator.configure(pathLog);
		Logger LOG = Logger.getRootLogger();
		log = Logger.getLogger(prop);
		Enumeration append = LOG.getAllAppenders();
		while (append.hasMoreElements()) {
			LOG.info("Available appender " + append.nextElement());
		}
	}

	public static synchronized ConfigLogger getInstance() {
		if (instance == null) {
			instance = new ConfigLogger();
		}
		return instance;
	}
	
	public Logger getLogger() {
		return log;
	}
}