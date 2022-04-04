package features.webTests;

import env.web.WebConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.aeonbits.owner.ConfigFactory;
import steps.web.LoginSteps;
import steps.web.OpenPageSteps;
import steps.web.PlayersSteps;

import static constants.pages.PathUrl.players;

public class testCheckTablePlayers {

    OpenPageSteps openPageSteps = new OpenPageSteps();
    LoginSteps loginSteps = new LoginSteps();
    PlayersSteps playersSteps = new PlayersSteps();
    static final WebConfig data = ConfigFactory.create(WebConfig.class, System.getProperties());

    @Given("opening the login page and enter the correct authorization data")
    public void opening_the_login_page_and_enter_the_correct_authorization_data() {

        loginSteps.openPageAndLogin(data.getLogin(), data.getPassword());

    }

    @When("opening the players page")
    public void opening_the_players_page() {

        openPageSteps.stepOpenPage(players.getPath());

    }

    @Then("checking the display of a table with data")
    public void checking_the_display_of_a_table_with_data() {

        playersSteps.checkLoadingTablePlayers();

    }
}
