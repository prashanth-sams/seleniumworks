package org.seleniumworks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.Assert;

/**
 * Author - Prashanth Sams [seleniumworks] 
 */

public class AppTest {

	private WebDriver driver;
	private String baseUrl;
	
	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://www.practiceselenium.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void Test01() throws Exception {
		driver.get(baseUrl + "/");
		Assert.assertEquals("Welcome", driver.getTitle());	
		
		
/*		driver.findElement(By.id("wsb-canvas-template-page")).click();
		try {
			assertEquals("We're passionate about tea.", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.linkText("Menu")).click();
		assertEquals("Menu", driver.getTitle());
		driver.findElement(By.cssSelector("#wsb-element-00000000-0000-0000-0000-000453230000 > div.txt. > p > span > span > strong")).click();
		driver.findElement(By.id("wsb-canvas-template-page")).click();
		driver.findElement(By.cssSelector("h1")).click();
		driver.findElement(By.cssSelector("#wsb-button-00000000-0000-0000-0000-000451955160 > span.button-content.wsb-button-content")).click();
		assertEquals("Check Out", driver.getTitle());
		driver.findElement(By.linkText("Let's Talk Tea")).click();
		driver.findElement(By.linkText("Check Out")).click();
		driver.findElement(By.linkText("Our Passion")).click();
		driver.findElement(By.cssSelector("h1")).click();
		assertEquals("Our Passion", driver.getTitle());
		try {
			assertEquals("Our Passion", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}*/
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();		
	}

}
