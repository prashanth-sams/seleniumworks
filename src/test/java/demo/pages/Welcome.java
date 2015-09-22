/**
 * @author Sams
 *
 */
package demo.pages;

import org.openqa.selenium.By;
import org.seleniumworks.utilities.BaseController;

public class Welcome extends BaseController{

	public String Title(){
		return driver.getTitle();
	}
	
	public void HerbalTea(){
		driver.findElement(By.xpath("(//span[@class='button-content wsb-button-content'])[2]")).click();
	}
	
	public void LooseTea(){
		driver.findElement(By.xpath("(//span[@class='button-content wsb-button-content'])[3]")).click();
	}
	
	public void FlavoredTea(){
		driver.findElement(By.xpath("(//span[@class='button-content wsb-button-content'])[1]")).click();
	}
	
}