package stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by SeleniumGuru.com.
 */
public class ServiceHooks {

    public static WebDriver driver;
    @Before
    public void initializeTest(){
        // Code to setup initial configurations
        System.out.println("Opening browser");
        //Declare the gecko driver path
        System.setProperty("webdriver.gecko.driver", "/Users/tulachanashok/Documents/Udemy-Selenium-Java/cucumber-newtours/geckodriver");
        //Initialize the selenium webdriver class and create object
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                // Code to capture and embed images in test reports (if scenario fails)
                String projectPath = System.getProperty("user.dir");
                captureScreenshot(projectPath.concat("/src/test/java/screenshots/failed1.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }

    public static void captureScreenshot(String filePath) {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}