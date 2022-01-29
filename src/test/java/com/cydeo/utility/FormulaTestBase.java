package com.cydeo.utility;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public class FormulaTestBase {


    @BeforeAll
    public static void init(){
        baseURI="http://ergast.com";
        basePath="/api/f1";
    }

    @AfterAll
    public static void destroy(){
        reset();
    }
}
