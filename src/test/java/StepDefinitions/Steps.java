package StepDefinitions;

import PageObjects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Steps {

    public WebDriver driver;
    public LoginPage lp;

    @Given("User launch browser")
    public void user_launch_browser() {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver");
        driver=new ChromeDriver();

        lp=new LoginPage(driver);


    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);

    }

    @And("User enters email {string} and password {string}")
    public void user_enters_email_and_password(String email, String password) {
        lp.setUserName(email);
        lp.setPassword(password);
    }

    @And("Click on login")
    public void click_on_login() {
        lp.clickLogin();
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String title) {
        if (driver.getPageSource().contains("Login was unsuccessful.")){
            driver.close();
            Assert.assertTrue(false);
        } else {
            Assert.assertEquals(title, driver.getTitle());
        }
    }

    @When("User click on logout")
    public void user_click_on_logout() throws InterruptedException{
     lp.clickLogout();
     Thread.sleep(3000);
    }

    @Then("Close browser")
    public void close_browser() {
    driver.quit();
    }
}
