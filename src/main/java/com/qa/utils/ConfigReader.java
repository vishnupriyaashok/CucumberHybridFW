package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
private Properties prop;
/*
 * this method is used to load properties from config.properties file
 * return Properties
 */
	

	public Properties init_properties() {
		try {
			FileInputStream ip =new FileInputStream(".\\src\\test\\resources\\config\\config.properties");
			prop=new Properties();
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	
	
}
