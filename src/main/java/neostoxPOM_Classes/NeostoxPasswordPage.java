package neostoxPOM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeostoxPasswordPage
{
  
	@FindBy(xpath = "//input[@type='password']") private WebElement passwordfield;
	
	@FindBy(xpath = "//a[@class='btn btn-neo']") private WebElement submitbutton;
	
	public NeostoxPasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterpassword( WebDriver driver,String pass) throws InterruptedException
	{
		UtilityNeoStox.waitmethod(driver, 2000);
		passwordfield.sendKeys(pass);
		Thread.sleep(1000);
		Reporter.log("sending password", true);
		
	}
	
	public void clickOnSubmitButton(WebDriver driver)
	{
		UtilityNeoStox.waitmethod(driver, 3000);
		submitbutton.click();
		Reporter.log("click on submit button", true);
	}
	
	
	
}
