package com.cydeo.utility;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public class LibraryTestBase {

    @BeforeAll
    public static void init(){
        baseURI="https://library2.cybertekschool.com";
        basePath="/rest/v1";
    }

    @AfterAll
    public static void destroy(){
        reset();
    }
}
