package features.apitests;

import apiModel.response.ResponseCredentialsGrant;
import env.api.ApiEnvContainer;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static constants.data.Common.GRANT_TYPE_DEFAULT;
import static constants.data.Common.SCOPE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static steps.api.ApiTests.addClientCredentialsGrant;


public class testGetGuestToken extends ApiEnvContainer {
    ResponseCredentialsGrant response;


    @When("we send a request to get the data of the default user")
    public void we_send_a_request_to_get_the_data_of_the_default_user() {

        response = addClientCredentialsGrant(GRANT_TYPE_DEFAULT,SCOPE);
    }

    @Then("the response comes with an authorization token")
    public void the_response_comes_with_an_authorization_token() {
        assertAll(
                () -> assertThat(response.getAccessToken()).isNotEmpty()
        );
    }

}
