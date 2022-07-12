package Day4;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/D:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// explicit wait
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		String[] arr = { "Cucumber", "Brocolli" };

		HandleCartMenuWithArray.addElement(driver, arr);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

	}

	public static void addElement(WebDriver driver, String[] arr) {
		List<WebElement> product = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < product.size(); i++) {
			String[] name = product.get(i).getText().split("-");
			String newName = name[0].trim();

			List itemNeededList = Arrays.asList(arr);

			if (itemNeededList.contains(newName)) {
				driver.findElements(By.xpath("//div[@class='product-action']//button")).get(i).click();
			}
		}
	}

}
