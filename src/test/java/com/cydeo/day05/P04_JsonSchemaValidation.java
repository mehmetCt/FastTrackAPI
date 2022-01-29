package com.cydeo.day05;

import com.cydeo.utility.SpartanTestbase;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class P04_JsonSchemaValidation extends SpartanTestbase {
    // Send request to GET /spartans
    // and verify the response json match the schema document
    // under resources folder
    // with the name of AllSpartansSchema.json


    @Test
    public void allSpartanSchemaValidaton() {


        given().log().uri().
        when()
                .get("/spartans").
        then()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("AllSpartanSchema.json"));
    }





}

