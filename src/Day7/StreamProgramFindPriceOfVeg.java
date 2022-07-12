package Day7;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamProgramFindPriceOfVeg
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "/D:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr//th[1]")).click();
		
		//click on table coloum to make in sorted order
		List<WebElement> sorted=driver.findElements(By.xpath("//tr/td[1]"));
		
		//Store all the coloum value inand to one list make as origional string
		List<String> origionalList=sorted.stream().map(s->s.getText()).collect(Collectors.toList());
		System.out.println(origionalList);
		
						
		
		//sort that origional list into sorted list 
		List<String> sortedList=origionalList.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedList);
		
		
	}

}
