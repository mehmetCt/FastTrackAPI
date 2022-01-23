package com.cydeo.day02;

import com.cydeo.utility.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class P03_JsonPath extends HrTestBase {

    @Test
    public void getLocations() {
            /*
    Given
             accept type is application/json
     When
             user sends get request to /locaitons
     Then
             response status code must be 200
             content type equals to application/json
             get the second city with JsonPath
             get the last city with JsonPath
             get all country ids
             get all city where their country id is UK

  */

        Response response = given()
                .accept(ContentType.JSON)
                .log().uri().
                when()
                .get("/locations").prettyPeek();


        JsonPath jp = response.jsonPath();

        Assertions.assertEquals(200, response.statusCode());

        //second city name
        System.out.println("jp.getString(\"items[1].city\") = " + jp.getString("items[1].city"));


        //last city name
        System.out.println("jp.getString(\"items[-1].city\") = " + jp.getString("items[-1].city"));


        //get all country ids
        List<String> allCountryIDs = jp.getList("items.country_id");
        System.out.println("allCountryIDs = " + allCountryIDs);


        // get all city where their country id is UK
        List<String> allCityNamesUK = jp.getList("items.findAll {it.country_id=='UK'}.city");
        System.out.println("allCityNamesUK = " + allCityNamesUK);



    }
}
