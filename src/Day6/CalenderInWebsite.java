package Day6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderInWebsite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// input[name='travel_date']

		System.setProperty("webdriver.chrome.driver", "/D:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.findElement(By.cssSelector("input[name='travel_date']")).click();
		
		
		while(!driver.findElement(By.cssSelector("div[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("August"))
		{
			driver.findElement(By.cssSelector("div[class='datepicker-days'] th[class='next']")).click();
		}
		List<WebElement> dates = driver.findElements(By.className("day"));
		int size = driver.findElements(By.className("day")).size();
		// System.out.println(size);
		//Grab the common attribute put into the list and iterate.
		for (int i = 0; i < size - 1; i++) {
			String day1 = driver.findElements(By.className("day")).get(i).getText();
			// System.out.println(day1);
			if (day1.equalsIgnoreCase("23")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
		}

	}

}
