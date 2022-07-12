package Day7;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamSortedOrderCheck {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/D:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr//th[1]")).click();

		List<String> price;

		do {
			List<WebElement> sorted = driver.findElements(By.xpath("//tr/td[1]"));
			price = sorted.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPrice(s))
					.collect(Collectors.toList());
			

			if (price.size() < 1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		} while (price.size() < 1);
		System.out.println(price);
	}

	public static String getPrice(WebElement s) {
		String prices = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return prices;
	}

}
