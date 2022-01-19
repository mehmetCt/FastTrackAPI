package com.cydeo.day01;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class P03_SpartanTest {


    @BeforeAll
    public static void init(){
        baseURI="http://34.192.175.227:8000";
        basePath="/api";
    }

    @AfterAll
    public static void destroy(){
        reset();
    }

    /**
     * 1. Send request to Spartan url and save the response
     * 2. GET /spartans
     * 3. Store the response in Response Object that comes from get Request
     * 4. Print out followings
     *     - response
     *     - Content-Type
     *     - Status Code
     *     - Get me first spartan gender
     *     - Get me first spartan name
     *     - Get me all spartan name
     */


    @Test
    public void getAllSpartans() {

        Response response = get("/spartans");

        System.out.println(response.contentType());
        Assertions.assertEquals(ContentType.JSON.toString(), response.contentType());


        Assertions.assertEquals(200, response.statusCode());

         // Get me first spartan gender

        // get me first spartan and give me gender of spartan
        System.out.println("response.path(\"0].gender\" ) = " + response.path("[0].gender"));

        // get me all genders and give me first gender
        System.out.println("response.path(\"gender[0]\") = " + response.path("gender[0]"));


        // Get me first spartan name
        System.out.println("response.path(\"0].name\" ) = " + response.path("[0].name"));
        System.out.println("response.path(\"name[0]\") = " + response.path("name[0]"));

        // Get me all spartan name
        System.out.println("Get me all spartan name");
        List<String> allNames = response.path("name");
        System.out.println(allNames);
        System.out.println(allNames.get(0));

    }
}
