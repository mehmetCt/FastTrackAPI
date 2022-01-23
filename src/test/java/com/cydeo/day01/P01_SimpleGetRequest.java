package com.cydeo.day01;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class P01_SimpleGetRequest {

    /**
     * 1. Send request to HR url and save the response
     * 2. GET /regions
     * 3. Store the response in Response Object that comes from get Request
     * 4. Print out followings
     *     - Headers
     *     - Content-Type
     *     - Status Code
     *     - Response
     *     - Date
     *     - Verify response body has "Europe"
     *     - Verify response has Date
     */
    @Test
    public void simpleGetRequest() {

        Response response = RestAssured.get("http://34.192.175.227:1000/ords/hr/regions");

        response.prettyPrint();

        System.out.println("==================");
        System.out.println(response.headers());


        System.out.println("==================");
        System.out.println(response.contentType());

        System.out.println("==================");
        System.out.println(response.statusCode());

        System.out.println("==================");
        System.out.println(response.header("Date"));

        System.out.println("==================");
        System.out.println(response.asString().contains("Europe"));


        // Verify Europe
        assertTrue(response.asString().contains("Europe"));

        // Verify Date is exist

        System.out.println(response.headers().hasHeaderWithName("Date"));
        assertTrue(response.headers().hasHeaderWithName("Date"));


    }

    /**
     * 1. Send request to HR url and save the response
     * 2. GET /employees/100
     * 3. Store the response in Response Object that comes from get Request
     * 4. Print out followings
     *     - First Name
     *     - Last Name
     *     - Verify status code is 200
     *     - Verify First Name is "Steven"
     *     - Verify content-Type is application/json
     */

    @DisplayName("GET /employees/100")
    @Test
    public void getOneEmployees() {


        Response response = RestAssured.get("http://34.192.175.227:1000/ords/hr/employees/100").prettyPeek();



        System.out.println(response.path("first_name").toString());
        System.out.println(response.path("last_name").toString());

        Assertions.assertEquals(200, response.statusCode()  );

        Assertions.assertEquals("Steven", response.path("first_name"));

        Assertions.assertEquals("application/json", response.contentType());
        Assertions.assertEquals(ContentType.JSON.toString(), response.contentType());


    }
}
