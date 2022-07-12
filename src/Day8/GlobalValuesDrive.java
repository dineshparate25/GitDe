
package Day8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.stream.FileCacheImageInputStream;

public class GlobalValuesDrive
{

	public static void main(String[] args) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream i1=new FileInputStream("D:\\Selenium code practise\\SeleniumForBeginners\\data.properties");
		prop.load(i1);
	System.out.println(prop.getProperty("browser"));
	System.out.println(prop.getProperty("url"));
	
	prop.setProperty("browser", "microsoftedge");
	FileOutputStream fo=new FileOutputStream("D:\\Selenium code practise\\SeleniumForBeginners\\data.properties");
	prop.store(fo, null);


	}

}
