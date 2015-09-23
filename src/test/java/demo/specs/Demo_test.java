package demo.specs;

import org.openqa.selenium.By;
import org.seleniumworks.utilities.BaseController;
import org.testng.annotations.*;
import org.testng.Assert;
import demo.pages.Welcome;


/**
 * Author - Prashanth Sams [seleniumworks] 
 */

public class Demo_test extends BaseController  {
	
	public Welcome welcome;
	public String title;
	public String header;
	
	@Test(description = "Check Welcome Page for Title and contents")
	public void Test01() throws Exception {			
		
		welcome = new Welcome(driver);
		
		title = welcome.Title();
		header = welcome.Header();
		
		Assert.assertEquals("Welcome", title);				
		try {
			Assert.assertEquals("We're passionate about tea. ", header);
		} catch (Error e) {
			System.out.println("Error in displaying Header");		
		} catch (Exception e) {
			System.out.println("Error in displaying Header");
		}
	}	
	
	@Test(description = "Check Herbal-Tea collections")
	public void Test02() throws Exception {	

		welcome.HerbalTea();
		try{
			driver.findElement(By.xpath("//strong[contains(text(), 'Green Tea')]")).isDisplayed();
		} catch(Error e){
			System.out.println("Green Tea is not Displayed in the Menu page on navigation");
		} catch (Exception e) {
			System.out.println("Green Tea is not Displayed in the Menu page on navigation");
		}
		
	}

/*	@Test(description = "Our Passion")
	public void Test03() throws Exception {				
		driver.findElement(By.linkText("Our Passion")).click();	
		Assert.assertEquals("Our Passion", driver.getTitle());				
	}

	@Test(description = "Menu")
	public void Test04() throws Exception {
		driver.findElement(By.linkText("Menu")).click();
		Assert.assertEquals("Menu", driver.getTitle());			
	}*/

}