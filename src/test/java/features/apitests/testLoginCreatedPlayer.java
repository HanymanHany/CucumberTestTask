package features.apitests;

import apiModel.response.ResponseResourceCredentials;
import constants.data.Generator;
import env.api.ApiEnvContainer;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static steps.api.ApiTests.createdAndLoginPlayer;

public class testLoginCreatedPlayer extends ApiEnvContainer {
    ResponseResourceCredentials response;
    String name,surname,username,email,password;
    Generator generator = new Generator();

    @When("we execute a request to create a new player and log in under him")
    public void we_execute_a_request_to_create_a_new_player_and_log_in_under_him() {

        name = generator.getName();
        surname = generator.getSurname();
        username = generator.getUsername();
        email = generator.getEmail();
        password = generator.getPassword();

        response = createdAndLoginPlayer(username,name,surname,password,email);
    }

    @Then("the in the response we get an authorization token")
    public void the_in_the_response_we_get_an_authorization_token() {
        assertAll(
                () -> assertThat(response.getAccessToken()).isNotEmpty()

        );
    }

}
