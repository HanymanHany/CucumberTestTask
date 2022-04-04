package features.apitests;

import apiModel.response.ResponseDataPlayer;
import constants.data.Generator;
import env.api.ApiEnvContainer;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static steps.api.ApiTests.*;

public class testCheckDateProfilePlayer extends ApiEnvContainer {
    ResponseDataPlayer response;
    String name,surname,username,email,password;
    Generator generator = new Generator();

    @When("we make a request to get data on a specific player")
    public void we_make_a_request_to_get_data_on_a_specific_player() {

        name = generator.getName();
        surname = generator.getSurname();
        username = generator.getUsername();
        email = generator.getEmail();
        password = generator.getPassword();

        int idPlayer = createdNewPlayerAndGetId(username,name,surname,password,email);
        response = getDataProfilePlayer(username,password,idPlayer,HTTP_OK);
    }

    @Then("in the response we get correct the player's data")
    public void in_the_response_we_get_correct_the_players_data() {
        assertAll(
                () -> assertThat(response.getName()).contains(name),
                () -> assertThat(response.getSurname()).contains(surname),
                () -> assertThat(response.getUsername()).contains(username),
                () -> assertThat(response.getEmail()).contains(email)

        );
    }

}
