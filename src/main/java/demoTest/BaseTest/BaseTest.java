package demoTest.BaseTest;


	

	import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.AfterMethod;
	import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseTest {
	    protected WebDriver driver;

	    @BeforeMethod
	    public void setup() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	    }

	    @AfterMethod
	    public void teardown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	    
	 // Method to take a screenshot and save it with a timestamp
	    public void takeScreenshot(String testName) {
	        // Create a timestamp to avoid overwriting screenshots
	        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	        @SuppressWarnings("unused")
			String Result = testName + "_" + timestamp + ".jpg";
	        
	        // Take the screenshot
	        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        
	        // Define the directory where the screenshots will be stored
	        File destination = new File("D:\\Shreya\\Screenshot" + "Rsult.jpg");
	        
	        try {
	            // Copy the screenshot to the destination directory
	            FileHandler.copy (screenshotFile, destination);
	            System.out.println("Screenshot saved to: Folder Shreya" + destination.getAbsolutePath());
	        } catch (IOException e) {
	            System.out.println("Error while saving screenshot: No screenshot captured" + e.getMessage());
	        }
	    }
	}



