package Day5;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowSwitchParenttoChild {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/D:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// driver.get("https://www.google.com/");
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#/");
		driver.findElement(By.xpath("//a[text()='Free Access to InterviewQues/ResumeAssistance/Material']")).click();

		// get window handle
		Set<String> windows = driver.getWindowHandles();

		Iterator<String> it = windows.iterator();
		String parentid = it.next();// get parent window id
		String childid = it.next();// get child window id

		driver.switchTo().window(childid);// switch to child window
		
		String []st=driver.findElement(By.xpath("//Strong[text()=' Learn Earn & Shine']")).getText().split(" ");
		//System.out.println(st);
		String str=st[1];
		driver.switchTo().window(parentid);
		driver.findElement(By.id("username")).sendKeys(str);
		
		

	}

}
