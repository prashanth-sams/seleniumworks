package org.seleniumworks.essentials;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertyLoader {
	
	public static Logger APP_LOGS;
	public static Properties repo;
	
	
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, NoSuchMethodException, SecurityException {
		FileInputStream fs = new FileInputStream("src/test/resources/repo.properties");
		repo = new Properties();
		repo.load(fs);
		
		PropertyLoader test = new PropertyLoader();
		test.start();
	}
	
	 public void start() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
	        // initialize the app logs	  
//	        APP_LOGS.debug("Properties loaded. Starting testing");
		 
	 }
	
}
