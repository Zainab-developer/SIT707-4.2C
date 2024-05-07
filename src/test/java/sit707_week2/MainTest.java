package sit707_week2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MainTest {

    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\\\Program Files\\\\chromedriver-win64\\\\chromedriver.exe");
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
    }
    
    @Test
	public void testStudentIdentity() {
		String studentId = "S223123562";
		Assert.assertNotNull("Student ID is 223123562", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Zainab";
		Assert.assertNotNull("Student name is Zainab", studentName);
	}

	@Test
	public void testValidLogin() {
	    driver.get("https://www.bunnings.com.au/login");
	    login("zakhan23.zk@gmail.com", "Zainab123+");
	    Assert.assertEquals("https://www.bunnings.com.au/", driver.getCurrentUrl());
	}

    @Test
    public void testInvalidEmail() {
        driver.get("https://www.bunnings.com.au/login");
        login("invalidemail", "validpassword");
        Assert.assertTrue(driver.getCurrentUrl().contains("error"));
    }

    @Test
    public void testInvalidPassword() {
        driver.get("https://www.bunnings.com.au/login");
        login("validemail@example.com", "invalidpassword");
        Assert.assertTrue(driver.getCurrentUrl().contains("error"));
    }

    @Test
    public void testEmptyFields() {
        driver.get("https://www.bunnings.com.au/login");
        login("", "");
        Assert.assertTrue(driver.getCurrentUrl().contains("error"));
    }

    private void login(String email, String password) {
        WebElement emailElement = driver.findElement(By.id("okta-signin-username"));
        emailElement.sendKeys(email);
        WebElement passwordElement = driver.findElement(By.id("okta-signin-password"));
        passwordElement.sendKeys(password);
        WebElement signInButton = driver.findElement(By.id("okta-signin-submit"));
        signInButton.click();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
