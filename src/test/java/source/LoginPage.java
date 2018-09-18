package source;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

/**
 * Created by SeleniumGuru.com on 3/14/18.
 */
public class LoginPage {
    //Initialize Webdriver
    public WebDriver myWebDriver;

    public LoginPage(WebDriver webdriver) {
        myWebDriver = webdriver;
    }

    //Navigate to login page
    public void navigateTo(String url){
        myWebDriver.navigate().to(url);
        myWebDriver.manage().window().maximize();
    }


    //Login to the page
    public void loginWithRecord(String record) throws FileNotFoundException {
        //Create a yaml object
        Yaml yaml = new Yaml();
        //Get the path of the Project
        String projectPath = System.getProperty("user.dir");
        //Create File object
        File dataFile = new File(projectPath.concat("/src/test/java/data/data.yaml"));
        //Create a input stream
        FileInputStream inputStream = new FileInputStream(dataFile);
        //Parse the yaml file and create a list/map that contains inner map
        Map<String, Map<String, Object>> dataMap = (Map<String, Map<String, Object>>)yaml.load(inputStream);
        //Create variables
        String username = dataMap.get(record).get("username").toString();
        String password = dataMap.get(record).get("password").toString();

        //type testing in username text box
        myWebDriver.findElement(By.name("userName")).sendKeys(username);
        //type testing in password text box
        myWebDriver.findElement(By.name("password")).sendKeys(password);
        //click on sign in button
        myWebDriver.findElement(By.name("login")).click();
        //Set Explicit Wait for 10 seconds by creating object for WebDriverWait class
        WebDriverWait wait = new WebDriverWait(myWebDriver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("findFlights")));


    }



}
