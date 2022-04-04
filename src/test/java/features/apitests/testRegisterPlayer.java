package features.apitests;

import apiModel.response.ResponseDataPlayer;
import constants.data.Generator;
import env.api.ApiEnvContainer;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static steps.api.ApiTests.registerNewPlayer;

public class testRegisterPlayer extends ApiEnvContainer {
    ResponseDataPlayer results;
    private static String name,surname,username,email,password;
    Generator generator = new Generator();

    @When("we execute a request to create a new player")
    public void we_execute_a_request_to_create_a_new_player() {

        name = generator.getName();
        surname = generator.getSurname();
        username = generator.getUsername();
        email = name + generator.getEmail();
        password = generator.getPassword();

        results = registerNewPlayer(username,name,surname,
                generator.getPassword(),email);
    }

    @Then("in the response we get the player's data")
    public void in_the_response_we_get_the_players_data() {
        assertAll(
                () -> assertThat(results.getName()).contains(name),
                () -> assertThat(results.getSurname()).contains(surname),
                () -> assertThat(results.getUsername()).contains(username),
                () -> assertThat(results.getEmail()).contains(email)

        );
    }

}
