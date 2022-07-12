package Day6;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LimitingScopeOfWebDriver {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/D:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement dropdown = driver.findElement(By.id("gf-BIG"));// limiting webdriver scope
		System.out.println(dropdown.findElements(By.tagName("a")).size());
		WebElement firstDropdown = dropdown.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(firstDropdown.findElements(By.tagName("a")).size());

		for (int i = 1; i < firstDropdown.findElements(By.tagName("a")).size(); i++) {
			String clickDownLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			firstDropdown.findElements(By.tagName("a")).get(i).sendKeys(clickDownLink);
			Thread.sleep(1000);
		}
				Set<String> abc=driver.getWindowHandles();
				Iterator<String> it=abc.iterator();
				
				while(it.hasNext())
				{
					driver.switchTo().window(it.next());
					System.out.println(driver.getTitle());
				}
 
		

	}

}
