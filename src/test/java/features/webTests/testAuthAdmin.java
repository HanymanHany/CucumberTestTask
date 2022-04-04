package features.webTests;

import env.web.WebConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.aeonbits.owner.ConfigFactory;
import steps.web.LoginSteps;
import steps.web.OpenPageSteps;
import steps.web.PlayersSteps;

import static constants.pages.PathUrl.login;

public class testAuthAdmin {
    OpenPageSteps openPageSteps = new OpenPageSteps();
    LoginSteps loginSteps = new LoginSteps();
    PlayersSteps playersSteps = new PlayersSteps();
    static final WebConfig data = ConfigFactory.create(WebConfig.class, System.getProperties());

    @Given("opening the login page")
    public void opening_the_login_page() {

        openPageSteps.stepOpenPage(login.getPath());

    }

    @When("enter the correct authorization data")
    public void enter_the_correct_authorization_data() {

        loginSteps.loginUser(data.getLogin(), data.getPassword());
    }

    @Then("admin panel is displayed")
    public void admin_panel_is_displayed() {

        loginSteps.stepCheckAdminPanel();
    }
}
