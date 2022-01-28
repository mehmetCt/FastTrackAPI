package com.cydeo.day03;

import com.cydeo.pojo.Location;
import com.cydeo.utility.HrTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class P04_DeserilizationWithPOJO extends HrTestBase {
    /**
     * Create a test called getLocation
     * 1. Send request to GET /locations
     * 2. log uri to see
     * 3. Get all Json as a Location Object and print out screen all the things with the help of  POJO
     * System.out.println("====== GET FIRST LOCATION  ======");
     * System.out.println("====== GET FIRST LOCATION LINKS POJO ======");
     * System.out.println("====== ALL LOCATIONS ======");
     * System.out.println("====== FIRST LOCATION ID ======");
     * System.out.println("====== FIRST LOCATION COUNTRY_ID ======");
     * System.out.println("====== GET FIRST LOCATION FIRST LINK  ====== ");
     * System.out.println("====== LAST LOCATION ID ======");
     */
    @Test
    public void getAllLocations() {

        JsonPath jp = given().log().uri().
                when().get("/locations").jsonPath();


        List<Location> allLocations = jp.getList("items", Location.class);


        System.out.println(allLocations);

        System.out.println("====== GET FIRST LOCATION  ======");
        System.out.println(allLocations.get(0));

        System.out.println("====== GET FIRST LOCATION LINKS POJO ======");
        System.out.println(allLocations.get(0).getLinks().get(0));

        System.out.println("====== FIRST LOCATION ID ======");
        System.out.println(allLocations.get(0).getLocationID());

        System.out.println("====== FIRST LOCATION COUNTRY_ID ======");
        System.out.println(allLocations.get(0).getCountryID());

        System.out.println("====== GET FIRST LOCATION FIRST LINK REL INFORMATION  ====== ");
        System.out.println(allLocations.get(0).getLinks().get(0).getRel());

        System.out.println("====== LAST LOCATION ID ======");
        System.out.println(allLocations.get(allLocations.size() - 1).getLocationID());


    }







}
