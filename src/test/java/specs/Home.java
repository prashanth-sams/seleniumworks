package specs;

import org.openqa.selenium.By;
import org.seleniumworks.utilities.Controllers;
//import org.seleniumworks.utilities.Controllers;
import org.testng.annotations.*;
import org.testng.Assert;

/**
 * Author - Prashanth Sams [seleniumworks] 
 */

public class Home extends Controllers {

	@Test(description = "Welcome Page")
	public void Test01() throws Exception {		
		Assert.assertEquals("Welcome", driver.getTitle());
		driver.findElement(By.id("wsb-canvas-template-page")).click();		
		try {
			Assert.assertEquals("We're passionate about tea.", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			System.out.println("Mismatching Header");		
		}
	}

	@Test(description = "Our Passion")
	public void Test02() throws Exception {				
		driver.findElement(By.linkText("Our Passion")).click();	
		Assert.assertEquals("Our Passion", driver.getTitle());				
	}

	@Test(description = "Menu")
	public void Test03() throws Exception {
		driver.findElement(By.linkText("Menu")).click();
		Assert.assertEquals("Menu", driver.getTitle());			
	}

}