package neostoxPOM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeostoxHomePage 
{

	@FindBy(id = "lbl_username") private WebElement userName;
	
	@FindBy(id = "lbl_curbalancetop") private WebElement balance;
	
	@FindBy(xpath = "//span[text()='Logout']") private WebElement logoutButton;
	
	@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement popUpOkButton;
	
	@FindBy(xpath = "(//a[text()='Close'])[5]") private WebElement popUpCloseButton;

	public NeostoxHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getuserName()
	{
		String acutalUserName = userName.getText();
		Reporter.log("getting actual username", true);
		return acutalUserName;
		
	}
	
	public String getBalance()
	{
		String actualbalance = balance.getText();
		Reporter.log("getting balance", true);
		return actualbalance;
	}
	
	public void handlePopUp(WebDriver driver)
	{
		UtilityNeoStox.waitmethod(driver, 2000);
		
		popUpOkButton.click();
		
		UtilityNeoStox.waitmethod(driver, 2000);
		popUpCloseButton.click();
		
	}
	
	
	
	public void logoutfromApplication(WebDriver driver)
	{
		userName.click();
		UtilityNeoStox.waitmethod(driver, 2000);
		logoutButton.click();
		Reporter.log("log out from application", true);
	}
	
}

