package com.cydeo.day04;

import com.cydeo.pojo.Campus;
import com.cydeo.utility.APIUtils;
import com.cydeo.utility.BookITTestBase;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;


/*
GET("/api/campuses")

credentials:
    email : sbirdbj@fc2.com
    password : asenorval
baseUri: "https://cybertek-reservation-api-qa3.herokuapp.com"
doc: https://cybertek-reservation-api-docs.herokuapp.com/#get-all-rooms

Deserialization Exercise
            send a request to get all campuses
            verify status code 200
            Create an POJO to get all data
                //Find out how many campus we have
                //Find out how many cluster we have in VA
                //Find out how many room  we have in light-side


 */

public class P02_BookIT extends BookITTestBase {

    @Test
    public void getAllCampuses() {

        String accessToken = APIUtils.getTokenBookIT();


        JsonPath jp = given().log().uri()
                .header("Authorization", accessToken).
        when()
                .get("/api/campuses").
        then()
                .statusCode(200)
                .extract().jsonPath();

        List<Campus> campusList = jp.getList("", Campus.class);

        System.out.println(campusList);
        //Find out how many campus we have
        System.out.println(campusList.size());

        //Find out how many cluster we have in VA
        System.out.println(campusList.get(0).getClusterList().size());

        //Find out how many room  we have in light-side
        System.out.println(campusList.get(0).getClusterList().get(0).getRoomList().size());


    }
}
