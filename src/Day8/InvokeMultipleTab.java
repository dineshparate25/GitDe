package Day8;

import java.util.Iterator;
import java.util.Set;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.*;

public class InvokeMultipleTab {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "/D:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		driver.switchTo().newWindow(WindowType.TAB);

		Set<String> handle = driver.getWindowHandles();
		Iterator<String> it = handle.iterator();
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);

		driver.get("https://rahulshettyacademy.com/");
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
				.get(1).getText();
		System.out.println(courseName);
		driver.switchTo().window(parentid);

		WebElement name=driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(courseName);
		
		//Capture screenshot logic
		
		File file=name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));
		
		//get Height and width
		
		System.out.println(name.getRect().getHeight());

	}

}
