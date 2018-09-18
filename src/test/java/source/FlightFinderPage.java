package source;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

/**
 * Created by SeleniumGuru.com on 3/14/18.
 */
public class FlightFinderPage {

    //Create webdriver object
    public WebDriver flightDriver;

    //Create constructor
    public FlightFinderPage(WebDriver driver) {
        flightDriver = driver;
    }

    //Verify the flight finder page title is correct
    public void verifyPageTitle() {
        System.out.println(flightDriver.getTitle());
        if (flightDriver.getTitle().equals("Find a Flight: Mercury Tours:")) {
            System.out.println("Test Passed");
        } else {
            fail("Test Failed");
        }
    }



}
