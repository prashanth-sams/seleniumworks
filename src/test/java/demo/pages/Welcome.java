/**
 * @author Sams
 *
 */
package demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Welcome {

	public WebDriver driver;
	
	public Welcome(WebDriver driver){
		this.driver = driver;
	}
	
	public String Title(){
		return driver.getTitle();
	}
	
	public String Header(){
		return driver.findElement(By.cssSelector("h1")).getText();
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