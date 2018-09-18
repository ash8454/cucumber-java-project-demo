package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import source.LoginPage;

/**
 * Created by SeleniumGuru.com on 3/14/18.
 */
public class LoginSteps {

    //Create webdriver object
    public WebDriver webDriver;

    //Create login page object
    public LoginPage loginPage;

    //Constructor
    public LoginSteps() {
        webDriver = ServiceHooks.driver;
    }


    @Given("^I open the website in a browser$")
    public void i_open_the_website_in_a_browser() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage = new LoginPage(webDriver);
        loginPage.navigateTo("https://newtours.herokuapp.com/");
    }

    @When("^I login with credentials using \"([^\"]*)\"$")
    public void i_login_with_credentials_using(String record) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage.loginWithRecord(record);
    }
}
