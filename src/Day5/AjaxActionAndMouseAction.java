package Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class AjaxActionAndMouseAction 
{

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method 
		System.setProperty("webdriver.chrome.driver", "/D:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("https://www.google.com/");
		driver.get("https://afourtech.com/");
		Actions a=new Actions(driver);
		WebElement move=driver.findElement(By.cssSelector(".mega-menu-item-54877"));
		a.moveToElement(driver.findElement(By.cssSelector("input[placeholder='First name']"))).click().keyUp(Keys.SHIFT).sendKeys("hello").doubleClick().perform();
		//Thread.sleep(5000);
		a.moveToElement(move).contextClick().perform();
		
		//span[text()='Personal Development']

	}

}
