package com.sample.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationConfiguration {
	
	private static final ApplicationConfiguration INSTANCE = new ApplicationConfiguration();
	
	public static ApplicationConfiguration getInstance() {
		return INSTANCE;
	}
	
	private static Properties configuration = new Properties();
	
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
		InputStream in = null;
		try
		{
			in = new FileInputStream(new File(file));
			configuration.load(in);
		} catch( IOException e) {
			e.printStackTrace();
		}
	}

}
