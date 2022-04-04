package helper.restAssured;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specification {

            public static RequestSpecification RequestSpec(String token, String baseUrl) {
                return new RequestSpecBuilder()
                        .setBaseUri(baseUrl)
                        .addHeader("authorization", token)
                        .setContentType(ContentType.JSON)
                        .addFilter(LogFilter.filters().withCustomTemplates())
                        .log(LogDetail.ALL)
                        .build();
            }

            public static ResponseSpecification ResponseSpecStatus(int status) {
                return new ResponseSpecBuilder()
                        .expectStatusCode(status)
                        .log(LogDetail.ALL)
                        .build();
            }

    }
