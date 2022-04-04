package features.webTests;

import env.web.WebConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.aeonbits.owner.ConfigFactory;
import steps.web.LoginSteps;
import steps.web.OpenPageSteps;
import steps.web.PlayersSteps;

import static constants.pages.PathUrl.players;

public class testCheckSortingPlayers {
    OpenPageSteps openPageSteps = new OpenPageSteps();
    LoginSteps loginSteps = new LoginSteps();
    PlayersSteps playersSteps = new PlayersSteps();
    static final WebConfig data = ConfigFactory.create(WebConfig.class, System.getProperties());

    @Given("opening the login page and enter the authorization data")
    public void opening_the_login_page_and_enter_the_authorization_data() {
        loginSteps.openPageAndLogin(data.getLogin(), data.getPassword());

    }

    @When("opening the players tables")
    public void opening_the_players_tables() {
        openPageSteps.stepOpenPage(players.getPath());

    }
    @And("sorting name column")
    public void sorting_name_column() {
        playersSteps.getFirstElementsPlayers();

    }

    @Then("checking correct sorting")
    public void checking_correct_sorting() {
        playersSteps.checkSorting();

    }

}
