package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import source.FlightFinderPage;

/**
 * Created by SeleniumGuru.com on 3/14/18.
 */
public class FlightFinderSteps {

    //Create objects
    public WebDriver myDriver;

    public FlightFinderPage flightFinderPage;

    //Create constructor
    public FlightFinderSteps() {
        myDriver = ServiceHooks.driver;
    }

    @Then("^Flight Finder Page is displayed$")
    public void flight_Finder_Page_is_displayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        flightFinderPage = new FlightFinderPage(myDriver);
        flightFinderPage.verifyPageTitle();
    }
}
