package Day7;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "/D:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		SoftAssert a=new SoftAssert();
		// get response code
		// broken url - means url is not working.
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		for (WebElement link : links) {
			
			String url = link.getAttribute("href");
			System.out.println(url);
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respcode = conn.getResponseCode();
			System.out.println(respcode);
			a.assertTrue(respcode<400, "The link with text :"+link.getText()+" broken code is :"+respcode);
			/*if(respcode>400)
			{
				System.out.println("The link with text :"+link.getText()+" broken code is :"+respcode);
				Assert.assertTrue(false);
			}*/
		}
		a.assertAll();

	}

}
