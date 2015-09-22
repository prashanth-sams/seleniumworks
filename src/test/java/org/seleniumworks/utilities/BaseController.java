package org.seleniumworks.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public abstract class BaseController {

	public WebDriver driver;

	@Parameters({ "browser" })
	@BeforeTest
	public void openBrowser(String browser) {
		try {
			if (browser.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();

			} else if (browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();

			} else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver",
						"C:/IEDriverServer.exe");
				driver = new InternetExplorerDriver();

			}
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}

	@BeforeMethod
	public void stepUp(){
		driver.get("http://www.practiceselenium.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}