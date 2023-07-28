package crowdar.Crowdar_Exercises;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utilities.testUtils;

public class Listeners extends testUtils implements ITestListener {

	public void onTestStart(ITestResult result) {
	System.out.println("Tet case is starting");	
	}
	
    public void onTestSuccess(ITestResult result) {
		
	}
    
    public void onTestFailure(ITestResult result) {
    System.out.println("Tet failed - screenshot captured");	
    String testName = result.getName();
    ITestContext context = result.getTestContext(); 
    try {
		getScreenshot(testName,context);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
    
    public void onTestSkipped(ITestResult result) {
    }
    
    public void onStart(ITestContext context) {
		
    }
    
    public void onFinish(ITestContext context) {
		
    }
}
