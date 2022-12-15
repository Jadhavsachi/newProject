package neostoxBASE;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerNeostox extends BaseNeoStox implements ITestListener
{
	public void onTestFailure(ITestResult result) 
	{
		String tcName = result.getName();
		Reporter.log("Test " +tcName+ "is failed please have look out again", true);
		Reporter.log("Test is failed,taken Screenshot", true);
		
		try {
			screenshotmethod(tcName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSuccess(ITestResult result) 
	{
		
		Reporter.log("Test " +result.getName()+ " is completed successfuly", true);
	}
	
	public void onTestSkipped(ITestResult result)
	{
		Reporter.log("Test is skipped please retry", true);
	}
	
}

