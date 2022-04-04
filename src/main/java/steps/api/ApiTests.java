package steps.api;

import apiModel.request.RequestClientCredentials;
import apiModel.request.RequestDataPlayer;
import apiModel.request.RequestResourceCredentials;
import apiModel.response.ResponseDataPlayer;
import apiModel.response.ResponseResourceCredentials;
import env.api.ApiEnvContainer;
import io.restassured.response.Response;
import apiModel.response.ResponseCredentialsGrant;

import static constants.data.Common.*;
import static constants.data.TokenType.BEARER;
import static constants.endPoint.ApiEndpoint.*;
import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.*;

public class ApiTests extends ApiEnvContainer {

    public static ResponseCredentialsGrant addClientCredentialsGrant(String grantType, String scope) {

        Response response = given()
                .spec(RequestSpecDefault(BasicToken))
                .body(RequestClientCredentials.builder().granType(grantType).scope(scope).build())
                .when()
                .post(V2_OAUTH2_TOKEN.path());
        return response.as(ResponseCredentialsGrant.class);
    }

    public static String getTokenClient(String grantType, String scope) {
        ResponseCredentialsGrant response =  addClientCredentialsGrant(grantType,scope);

        return response.getAccessToken();
    }

    public static ResponseDataPlayer registerNewPlayer(String username, String name, String surname, String password, String email) {
        String token = getTokenClient(GRANT_TYPE_DEFAULT,SCOPE);
        RequestDataPlayer bodyRequestDataPlayer = RequestDataPlayer.builder().username(username).passwordChange(password).passwordRepeat(password).
                email(email).name(name).surname(surname).build();

        Response response = given()
                .spec(RequestSpecDefault(BEARER.type() + token))
                .body(bodyRequestDataPlayer)
                .when()
                .post(V2_PLAYERS.path());

        return responseSpecDefault(response, HTTP_CREATED).as(ResponseDataPlayer.class);
    }

    public static int createdNewPlayerAndGetId(String username, String name, String surname, String password, String email) {
        String token = getTokenClient(GRANT_TYPE_DEFAULT,SCOPE);
        RequestDataPlayer bodyRequestDataPlayer = RequestDataPlayer.builder().username(username).passwordChange(password).passwordRepeat(password).
                email(email).name(name).surname(surname).build();

        Response response = given()
                .spec(RequestSpecDefault(BEARER.type() + token))
                .body(bodyRequestDataPlayer)
                .when()
                .post(V2_PLAYERS.path());

        return responseSpecDefault(response, HTTP_CREATED).as(ResponseDataPlayer.class).getId();
    }

    public static ResponseResourceCredentials createdAndLoginPlayer(String username, String name, String surname, String password, String email) {
        registerNewPlayer(username,name,surname,password,email);
        RequestResourceCredentials bodyRequestResourceCredentials = RequestResourceCredentials.builder().grantType(GRANT_TYPE_PASSWORD).username(username).password(password).build();

        Response response = given()
                .spec(RequestSpecDefault(BasicToken))
                .body(bodyRequestResourceCredentials)
                .when()
                .post(V2_OAUTH2_TOKEN.path());

        return responseSpecDefault(response, HTTP_OK).as(ResponseResourceCredentials.class);
    }

    public static ResponseResourceCredentials loginCreatedPlayer(String username, String password) {

        RequestResourceCredentials bodyRequestResourceCredentials = RequestResourceCredentials.builder().grantType(GRANT_TYPE_PASSWORD).username(username).password(password).build();

        Response response = given()
                .spec(RequestSpecDefault(BasicToken))
                .body(bodyRequestResourceCredentials)
                .when()
                .post(V2_OAUTH2_TOKEN.path());

        return responseSpecDefault(response, HTTP_OK).as(ResponseResourceCredentials.class);
    }

    public static ResponseDataPlayer getDataProfilePlayer(String username,  String password, int idPlayer, int statusCode) {
        ResponseResourceCredentials response = loginCreatedPlayer(username,password);
        String token = response.getAccessToken();

        Response results = given()
                .spec(RequestSpecDefault(BEARER.type() + token))
                .when()
                .get(V2_PLAYERS.pathAndEndpoint(idPlayer) );

        return responseSpecDefault(results, statusCode).as(ResponseDataPlayer.class);
    }

    public static void getDataProfileNotExistPlayer(String username,  String password, int idPlayer, int statusCode) {
        ResponseResourceCredentials response = loginCreatedPlayer(username,password);
        String token = response.getAccessToken();

        Response results = given()
                .spec(RequestSpecDefault(BEARER.type() + token))
                .when()
                .get(V2_PLAYERS.pathAndEndpoint(idPlayer) );
        responseSpecDefault(results, statusCode);
    }


}
