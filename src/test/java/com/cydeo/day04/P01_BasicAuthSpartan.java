package com.cydeo.day04;

import com.cydeo.utility.SpartanAuthTestbase;
import com.cydeo.utility.SpartanTestbase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class P01_BasicAuthSpartan extends SpartanAuthTestbase {

    /**
     * Create a test method  testPublicUser
     * Send a request GET /spartans without any authentication
     * expect 401
     */

    @Test
    public void testPublicUser() {

        given()
                .log().uri().
        when()
                .get("/spartans").
        then()
                .statusCode(401);

    }


    /**
     * Create a test method  testAuthenticatedUser
     * Send a request GET /spartans
     * expect 200
     * user / user
     */

    @Test
    public void testAuthenticatedUser() {

        given()
                .log().uri()
                 .auth().basic("user","user").
        when()
                .get("/spartans").
        then()
                .statusCode(200);

    }

    /**
     * Given editor credentials are provided
     * When editor try to delete any data
     * Then the response should be 403 forbidden
     *  id -->13
     */

    @Test
    void testEditorDeleteSpartan() {

        given().log().uri()
                .pathParam("id", 13)
                .auth().basic("editor", "editor").
        when()
                .delete("/spartans/{id}").
        then()
                .statusCode(403);

    }




    /*
        user / admin / editor
    */

    @ParameterizedTest
    @ValueSource(strings = {"admin","user","editor"})
    public void testAllAuthenticatedUser(String role) {

        given()
                .log().uri()
                .auth().basic(role,role).
                when()
                .get("/spartans").
                then()
                .statusCode(200);

    }


    /*
        -- POST REQUEST
            - user  --> 403
            - admin --> 201
            - editor --> 201

            @ParametirezedTest
            @CsvFileSource

     */
}
