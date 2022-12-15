package neostoxPOM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeostoxLoginPage 
{
	// declare the variable
	
	@FindBy(id = "MainContent_signinsignup_txt_mobilenumber") private WebElement mobNumField;
	
	@FindBy(xpath = "//a[@class='btn btn-signup']") private WebElement signIn;
	
	// now initialize the variable using constructor
	
	public NeostoxLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// usage means create the method
	
	public void enterMobNum(WebDriver driver,String mobNum)
	{
		UtilityNeoStox.waitmethod(driver, 1000);
		mobNumField.sendKeys(mobNum);
		Reporter.log("Sending mobile number..", true);
		
	}
	
	public void clickOnSignInButton(WebDriver driver)
	{
		signIn.click();
		UtilityNeoStox.waitmethod(driver, 1000);
		Reporter.log("Clinking on signIn button..", true);
	}
	
	

}
