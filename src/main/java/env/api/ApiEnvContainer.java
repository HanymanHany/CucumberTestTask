package env.api;

import constants.data.Generator;
import helper.restAssured.LogFilter;

import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;

import java.util.Base64;

import static constants.data.TokenType.BASIC;

public class ApiEnvContainer {
    public static String url,BasicToken;
    public static final ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());

    protected static String EncodingBase64(String basicToken){
        return Base64.getEncoder().encodeToString(basicToken.getBytes());
    }

    public static RequestSpecification RequestSpecDefault(String token) {
        return new RequestSpecBuilder()
                .setBaseUri(apiConfig.getUrl())
                .addHeader("Authorization", token)
                .addHeader("Host", apiConfig.getHost())
                .setContentType(ContentType.JSON)
                .addFilter(LogFilter.filters().withCustomTemplates())
                .log(LogDetail.ALL)
                .build();
    }

    public static Response responseSpecDefault(Response response, int statusCode) {
        response.then()
                .log().body()
                .statusCode(statusCode);
        return response;
    }

}
