package com.cydeo.day03;

import com.cydeo.pojo.Spartan;
import com.cydeo.utility.SpartanTestbase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;



import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class P02_SpartanFlowWithPOJO extends SpartanTestbase {

    static int spartanID;

    @Order(1)
    @Test
    public void postSpartan() {

        //firstway
        Spartan spartan=new Spartan();

        spartan.setGender("Female");
        spartan.setName("FastTrack POJO");
        spartan.setPhone(1231231231l);

        //second way
        Spartan spartanNew=new Spartan("FastTrack POJO","Female",3213213211l);


         spartanID = given().log().uri()
                .contentType(ContentType.JSON)
                .body(spartanNew).
                when()
                .post("/spartans").prettyPeek().
                then()
                .statusCode(201)
                .body("success", is("A Spartan is Born!"))
                .extract().jsonPath().getInt("data.id");


    }

    @Order(2)
    @Test
    public void getSpartan() {

        JsonPath jsonPath = given()
                .pathParam("id", spartanID).
                when()
                .get("/spartans/{id}").prettyPeek().
                then()
                .statusCode(200)
                .body("name", is("FastTrack POJO"))
                .extract().jsonPath();


        System.out.println(jsonPath.getString("gender"));
    }
}
