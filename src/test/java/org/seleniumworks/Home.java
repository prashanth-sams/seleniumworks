package org.seleniumworks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.Assert;

/**
 * Author - Prashanth Sams [seleniumworks] 
 */

public class Home {

	private WebDriver driver;
//	private String baseUrl;
	
	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
//		baseUrl = "http://www.practiceselenium.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void Test01() throws Exception {
		driver.get("http://www.practiceselenium.com/");
		Assert.assertEquals("Welcome", driver.getTitle());	
		
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();		
	}

}
