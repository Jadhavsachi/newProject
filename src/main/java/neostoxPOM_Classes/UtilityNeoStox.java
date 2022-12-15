package neostoxPOM_Classes;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UtilityNeoStox
{

	public static String readDataFromPropertiesFile(String key) throws IOException
	{
	 
	// create object of properties class
	Properties prop= new Properties();
	
	// create object of fileinputStream and pass property file path
	
	FileInputStream myfile= new FileInputStream("C:\\Users\\si\\eclipse-workspace\\SeleniumStudy\\Neostox.properties");
	prop.load(myfile);
	String value = prop.getProperty(key);
	return value;
	
	}
	
	
		
		// 3. Scrolling common method
		public static void scrollinto(WebDriver driver, WebElement element)
		{
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
			js.executeScript("arguments[0].scrollIntoView()", element);
			
			
		}
		
		// 4. Wait common method
		public static void waitmethod(WebDriver driver, long waitTime)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
		}
		
	
}
