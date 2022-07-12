package Day4;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Simple handle only one element code
/*
 * List<WebElement> product =
 * driver.findElements(By.cssSelector("h4.product-name")); for(int
 * i=0;i<product.size();i++) { String name=product.get(i).getText();
 * //System.out.println(name); if(name.contains("Cucumber")) {
 * driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click(
 * ); break; } }
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCartMenuWithArray {

	//implicit wait example
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/D:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		String[] arr = { "Cucumber", "Brocolli" };

		// handling the situation of array.
		HandleCartMenuWithArray.addElement(driver,arr);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		//Thread.sleep(5000);
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		
	}
	public static void addElement(WebDriver driver,String [] arr)
	{
		List<WebElement> product = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < product.size(); i++) 
		{
			String[] name = product.get(i).getText().split("-");
			String newName=name[0].trim();
			
			List itemNeededList = Arrays.asList(arr);

			if (itemNeededList.contains(newName))
			{
				driver.findElements(By.xpath("//div[@class='product-action']//button")).get(i).click();
			}
		}
	}
}
