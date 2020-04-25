package com.sample.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/***
 * 
 * 
 * @author SARANYA
 *
 */
public class ApplicationConfiguration {
	
	private final static Logger LOGGER = Logger.getLogger(ApplicationConfiguration.class.getName());
	
	private static final ApplicationConfiguration INSTANCE = new ApplicationConfiguration();
	
	private static Properties configuration = new Properties();
	
	public static ApplicationConfiguration getInstance() {
		return INSTANCE;
	}
	
	private static Properties getConfiguration() {
		return configuration;
	}
	
	public static String getConfiguration(final String key) {
		return (String) getConfiguration().get(key);
	}
	
	public static String getConfiguration(final String key, final String defaultValue) {
		return getConfiguration().getProperty(key, defaultValue);
	}
	
	public void initialize(final String file) {
		InputStream inputStream = null;
		try
		{
			inputStream = new FileInputStream(new File(file));
			configuration.load(inputStream);
		} catch( IOException e) {
			LOGGER.setLevel(Level.WARNING);
		}
	}

}
