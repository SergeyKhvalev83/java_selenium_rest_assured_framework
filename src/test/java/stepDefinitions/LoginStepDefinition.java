package stepDefinitions;
import POM.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import unilities.ConfigurationReader;
import unilities.Driver;
import unilities.BrowserUtils;

public class LoginStepDefinition {
    LoginPage login_page = new LoginPage();

    @Given("User is on login page")
    public void user_is_on_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @When("user enter username {string}")
    public void user_enter_username(String string) {
        login_page.userNameInput.sendKeys(string);

    }

    @When("user enter password {string}")
    public void user_enter_password(String string) {
        login_page.passwordInput.sendKeys(string);
    }
    @When("user click to login button")
    public void user_click_to_login_button() {
       login_page.loginBtn.click();
    }

    @Then("user should see url contains {string}")
    public void user_should_see_url_contains(String string) {
       // BrowserUtils.alertsAccept(2);
        BrowserUtils.verifyURLContains(string);    }

}
