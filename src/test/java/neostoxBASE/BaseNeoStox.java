package neostoxBASE;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import neostoxUtility.UtilityNeoStox;

public class BaseNeoStox
{
	protected static WebDriver driver;
	
	public void Browserlaunch() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		
		driver= new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get(UtilityNeoStox.readDataFromPropertiesFile("QAurl"));
		
	   UtilityNeoStox.waitmethod(driver, 500);
	}
	//2. Screenshot common method
	   public void screenshotmethod( String TCID) throws IOException
			{
				 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		         File dest= new File("E:\\Screenshot\\"+TCID+".jpg");
			     FileHandler.copy(src, dest);
			     Reporter.log("new commit for github", true);
			     Reporter.log("for branch1 commit", true);
				
			}
	   

}
