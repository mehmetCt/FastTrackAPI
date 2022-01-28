package com.cydeo.utility;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class APIUtils {


    public static String getTokenBookIT() {

        String accessToken = given().log().uri()
                .queryParam("email", "sbirdbj@fc2.com")
                .queryParam("password", "asenorval").
                when()
                .get("/sign").
                then()
                .statusCode(200)
                .extract().jsonPath().getString("accessToken");

        return "Bearer "+accessToken;
    }
}
