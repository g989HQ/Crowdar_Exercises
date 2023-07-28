package utilities;

import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.util.Date;
import crowdar.Crowdar_Exercises.*;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;


public class testUtils extends Exercise{
	
	public void getScreenshot(String testName, ITestContext context) throws IOException{
		Date currentdate= new Date();
        String driverName = context.getCurrentXmlTest().getParameter("browser");
		String screenshotfilename= currentdate.toString().replace(" ", "-").replace(":", "-");
		File screenshotfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotfile, new File (".//screenshot//" + screenshotfilename+" "+testName+" - "+driverName+ ".png"));
		
	}
	

}
