package Day7;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterOnSuggestionInTable 
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "/D:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement>element= driver.findElements(By.xpath("//tr/td[1]"));
		
		List<WebElement> list=element.stream().filter(Element->Element.getText().contains("Rice")).collect(Collectors.toList());
		
		Assert.assertEquals(element.size(), list.size());
		

	}

}
