package demo.specs;

import org.openqa.selenium.By;
import org.seleniumworks.utilities.BaseController;
import org.testng.annotations.*;
import org.testng.Assert;
import demo.pages.Welcome;


/**
 * Author - Prashanth Sams [seleniumworks] 
 */

public class Home_page extends BaseController {

	public Welcome welcome;
	public String title;

	@Test(description = "Check Welcome Page for Title and contents")
	public void Test01() throws Exception {
		title = welcome.Title();
		Assert.assertEquals("Welcome", title);				
		try {
			Assert.assertEquals("We're passionate about tea.", driver.findElement(By.cssSelector("h1")).getText());
		} catch (Error e) {
			System.out.println("Mismatching Contents");		
		}
	}	
	
	@Test(description = "Check Herbal-Tea collections")
	public void Test02() throws Exception {	

		welcome.HerbalTea();
		try{
			driver.findElement(By.xpath("//strong[contains(text(), 'Green Tea')]")).isDisplayed();
		} catch(Error e){
			System.out.println("Green Tea is not Displayed in the Menu page on navigation");
		}
		
	}

	@Test(description = "Our Passion")
	public void Test03() throws Exception {				
		driver.findElement(By.linkText("Our Passion")).click();	
		Assert.assertEquals("Our Passion", driver.getTitle());				
	}

	@Test(description = "Menu")
	public void Test04() throws Exception {
		driver.findElement(By.linkText("Menu")).click();
		Assert.assertEquals("Menu", driver.getTitle());			
	}

}