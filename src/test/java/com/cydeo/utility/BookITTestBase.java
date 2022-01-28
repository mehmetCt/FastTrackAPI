package com.cydeo.utility;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public class BookITTestBase {

    @BeforeAll
    public static void init(){
        baseURI="https://cybertek-reservation-api-qa3.herokuapp.com";
    }

    @AfterAll
    public static void destroy(){
        reset();
    }
}
