package features.apitests;

import constants.data.Generator;
import env.api.ApiEnvContainer;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static steps.api.ApiTests.*;
import static steps.api.ApiTests.getDataProfileNotExistPlayer;

public class testCheckDateProfileNotExistPlayer extends ApiEnvContainer {
    //private Generator generator = new Generator();
    int idPlayerNotExist = 22345;
    String name,surname,username,email,password;
    Generator generator = new Generator();

    @When("we execute a request to get data on a non-existent player")
    public void we_execute_a_request_to_get_data_on_a_non_existent_player() {

        name = generator.getName();
        surname = generator.getSurname();
        username = generator.getUsername();
        email = generator.getEmail();
        password = generator.getPassword();

        registerNewPlayer(username,name,surname, password,email);


    }

    @Then("we get a 404 error in the response")
    public void we_get_a_404_error_in_the_response() {
        getDataProfileNotExistPlayer(username,password,idPlayerNotExist,HTTP_NOT_FOUND);
    }

}
