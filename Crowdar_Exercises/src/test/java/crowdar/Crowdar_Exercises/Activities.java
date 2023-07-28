package crowdar.Crowdar_Exercises;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.Reporter;

public class Activities {

    public static void setInputById(WebDriver driver, String id, String inputText) {
        // Find the input field by ID
        WebElement inputField = driver.findElement(By.id(id));

        // Clear the existing input, if any
        inputField.clear();

        // Enter the input text
        inputField.sendKeys(inputText);
    }
    
    public boolean isPopupTriggered(WebDriver driver) {
        try {
            // Wait for up to the specified time for the pop up to be present
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            if (alert != null) {
                return true; // Pop up is triggered within the timeout
            } else {
                return false; // Pop up is not triggered within the timeout
            }
        } catch (TimeoutException e) {
            return false; // Pop up is not triggered within the timeout
        }
    }
	
    
    public void handleConfirmation(WebDriver driver,  boolean accept) {
       
    	
    	// Switch to the Confirmation
        Alert confirmation = driver.switchTo().alert();

        // Handle the Confirmation based on the accept parameter
        if (accept) {
            confirmation.accept();
        } else {
            confirmation.dismiss();
        }
    }
    
    public boolean isSpanPresentByText(WebDriver driver, String expectedText) {
        try {
            // Wait for up to the specified time for the span with the expected text
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement spanElement = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//span[@class='title' and contains(text(), '" + expectedText + "')]")));

            // If the span is found, return true
            return spanElement.isDisplayed();
        } catch (Exception e) {
            // If the span is not found or any other exception occurs, return false
            return false;
        }
    }
    
    public void clickAddToCartButton(WebDriver driver,String productIdentifier) {
        // Use a CSS selector to find the button based on the data-test attribute
        WebElement addToCartButton = driver.findElement(By.cssSelector(
            "button[data-test='add-to-cart-" + productIdentifier + "']"));

        // Click on the button
        addToCartButton.click();
    }

    
}
