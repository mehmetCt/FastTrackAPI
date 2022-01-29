package com.cydeo.day05;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class P05_MockAPITest {

    @BeforeAll
    public static void init(){
        baseURI="https://b5502d6e-7533-45db-8407-0a86e7f019bc.mock.pstmn.io";
    }

    @AfterAll
    public static void destroy(){
        reset();
    }

    @Test
    public void mockSpartans() {

        given().log().uri().
        when()
                .get("/spartans").prettyPeek().
        then()
                .statusCode(200)
                .contentType(ContentType.JSON);

    }
}
