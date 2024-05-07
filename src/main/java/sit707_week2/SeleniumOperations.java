package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import org.openqa.selenium.support.locators.RelativeLocator;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	 public static void bunningsLogin(String url, String email, String password) {
	        // Step 1: Locate chrome driver folder in the local drive.
	        System.setProperty("webdriver.chrome.driver", "C:\\\\Program Files\\\\chromedriver-win64\\\\chromedriver.exe");
	        
	        // Step 2: Use above chrome driver to open up a chromium browser.
	        System.out.println("Fire up chrome browser.");
			ChromeOptions opt= new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
			
			WebDriver driver = new ChromeDriver(opt);
			
			System.out.println("Driver info: " + driver);
			
	        
	        sleep(10);
	    
	        // Load the login page in the chromium browser.
	        
	        driver.get("https://www.bunnings.com.au/login");
	        /*
	         * How to identify HTML input fields -
	         * Step 1: Inspect the webpage, 
	         * Step 2: Locate the input fields, 
	         * Step 3: Find out how to identify them, by id/name/...
	         */
	        
	        // Find the email input field and populate it with the provided email
	        WebElement emailElement = driver.findElement(By.id("okta-signin-username"));
	        System.out.println("Found element: " + emailElement);
	        emailElement.sendKeys(email);
	        
	        // Find the password input field and populate it with the provided password
	        WebElement passwordElement = driver.findElement(By.id("okta-signin-password"));
	        System.out.println("Found element: " + passwordElement);
	        passwordElement.sendKeys(password);
	        
	        // Find the Remember Me checkbox and click it
	        WebElement rememberMeCheckbox = driver.findElement(By.id("input42"));
	        System.out.println("Found element: " + rememberMeCheckbox);
	        rememberMeCheckbox.click();
	        
	        // Identify the 'Sign In' button and click it to submit the form
	        WebElement signInButton = driver.findElement(By.id("okta-signin-submit"));
	        System.out.println("Found element: " + signInButton);
	        signInButton.click();
	       
	        // Take a screenshot after submitting the login form
	        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String screenshotPath = "C:\\Users\\Zaina\\OneDrive\\Documents\\deakin\\software testing\\week 2\\2.1P-resources\\task2_1P\\src\\images\\login_screenshot.png";
	        try {
	            if (screenshotFile.renameTo(new File(screenshotPath))) {
	                System.out.println("Screenshot saved at: " + screenshotPath);
	            } else {
	                System.out.println("Failed to save screenshot.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }    
	        
	        // Sleep for a while
	        sleep(2);
	        
	        // Close the browser
	        driver.quit();  
	    }
	}