package crowdar.Crowdar_Exercises;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputFilter.Status;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;



public class Exercise {
    public static WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        // Set the path to the ChromeDriver executable
         
        if (browser.equalsIgnoreCase("chrome")) {
            // Set the path to the ChromeDriver executable
            System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            // Set the path to the GeckoDriver executable
            System.setProperty("webdriver.gecko.driver", ".//Drivers//geckodriver.exe");
            driver = new FirefoxDriver();
        }
        
        // Maximize the browser window
        driver.manage().window().maximize();
        
        // Open the exercise site
        driver.get("https://www.saucedemo.com/");
       
        try {
  	         WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
             WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));  
        } catch (TimeoutException e) {
            // Handle the TimeoutException here (e.g., log the error or perform a recovery action)
             System.out.println("TimeoutException occurred: " + e.getMessage());
            // You can take appropriate action, for example, failing the test or retrying the action.
        } catch (Exception e) {
            // Handle any other exceptions that might occur during the test
             System.out.println("An unexpected exception occurred: " + e.getMessage());
            // You can take appropriate action, for example, failing the test or logging the error.
        }
    }

    @Test
    public void LoginUserSuccessfully() {
        
    	 
    	 
    	  //Enter User data for login
    	  driver.findElement(By.id("user-name")).sendKeys("standard_user");
    	  driver.findElement(By.id("password")).sendKeys("secret_sauce");
    	  
    	  //Click on Login button
    	  driver.findElement(By.id("login-button")).click();
    	  
    	  Activities activities= new Activities();
    	  
    	  boolean alertPresent= activities.isPopupTriggered(driver);
    	  if(alertPresent==true) 
    	  {
    		  activities.handleConfirmation(driver, true);
    	  }
    	     	  
  
          boolean isSpanPresent =  activities.isSpanPresentByText(driver, "Products");
          
          if(isSpanPresent==false) {
        	     System.out.println("Main page not loaded correctly");
          }
          

    	 }
    	
    
    @Test
    public void AddItemsToCart(){
  	  //Enter User data for login
  	  driver.findElement(By.id("user-name")).sendKeys("standard_user");
  	  driver.findElement(By.id("password")).sendKeys("secret_sauce");
  	  
  	  //Click on Login button
  	  driver.findElement(By.id("login-button")).click();
  	  
  	  Activities activities= new Activities();
  	  
  	  activities.clickAddToCartButton(driver, "sauce-labs-bike-light");
  	  activities.clickAddToCartButton(driver, "sauce-labs-backpack");
      
      By selector = By.cssSelector("a.shopping_cart_link span.shopping_cart_badge");
      WebElement shoppingCartIcon = driver.findElement(selector);
      shoppingCartIcon.click();
    	try {
      	    Thread.sleep(5000);
      	} catch (InterruptedException e) {
      	    //do nothing
      	}
      //force the error to take screenshot!!!!!!!!!!!!!!!!!!!!
      Assert.assertTrue(false);
    	
    }
    
    @Test
    public void verifyDepartmentsExist() {
        // Set the base URL for the MercadoLibre API
        RestAssured.baseURI = "https://www.mercadolibre.com.ar";

        // Send the GET request to retrieve the departments
        Response response = RestAssured.given()
                .when()
                .get("/menu/departments")
                .then()
                .extract()
                .response();

        // Check the response status code
        Assert.assertEquals(response.getStatusCode(), 200);

        // Check that the response contains departments
        boolean departmentsExist = response.getBody().asString().contains("departments");
        Assert.assertEquals(departmentsExist, true);
        System.out.println("departments exist");	
    }


    
    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }

    
}