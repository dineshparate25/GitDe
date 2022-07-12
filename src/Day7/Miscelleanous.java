package Day7;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.*;

public class Miscelleanous {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/D:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//maximize and delete cookies
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		
		//take screenshot code.
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File DestFile=new File("D://screen//screenshot.png");
		FileUtils.copyFile(src, DestFile);
		
	}

}
