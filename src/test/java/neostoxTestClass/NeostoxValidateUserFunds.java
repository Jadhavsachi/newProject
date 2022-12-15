package neostoxTestClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import neostoxBASE.BaseNeoStox;
import neostoxPOM_Classes.NeostoxHomePage;
import neostoxPOM_Classes.NeostoxLoginPage;
import neostoxPOM_Classes.NeostoxPasswordPage;
import neostoxUtility.UtilityNeoStox;

//@Listeners(packagename.classname.class)

@Listeners(neostoxBASE.ListenerNeostox.class)

public class NeostoxValidateUserFunds extends BaseNeoStox
{
	NeostoxLoginPage login;
	NeostoxPasswordPage password;
	NeostoxHomePage home;
  
	@BeforeClass
	public void openBrowser() throws IOException
	{
		Browserlaunch();
		login= new NeostoxLoginPage(driver);
		password= new NeostoxPasswordPage(driver);
		home=new NeostoxHomePage(driver);
	}
	
	@BeforeMethod
	public void loginToNeostox() throws IOException, InterruptedException
	{
		login.enterMobNum(driver, UtilityNeoStox.readDataFromPropertiesFile("mobNum"));
		login.clickOnSignInButton(driver);
		password.enterpassword(driver, UtilityNeoStox.readDataFromPropertiesFile("pass"));
		password.clickOnSubmitButton(driver);
		
		Thread.sleep(1000);
		home.handlePopUp(driver);
	}
	
	
	
	@Test
  public void validateUserFunds() throws IOException 
  {
	Assert.assertEquals(home.getBalance(),UtilityNeoStox.readDataFromPropertiesFile("userbalance"));
  }
	@AfterMethod
	public void logOutFromNeostox()
	{
		home.logoutfromApplication(driver);
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
