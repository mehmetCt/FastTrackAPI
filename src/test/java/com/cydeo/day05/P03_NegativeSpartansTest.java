package com.cydeo.day05;

import com.cydeo.pojo.Spartan;
import com.cydeo.utility.SpartanTestbase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class P03_NegativeSpartansTest extends SpartanTestbase {

    /**
     * Post /spartans request json payload have below requirements
     * name  : 2-15 chars
     * gender : Male or Female
     * phone  : 10 - 13 digit
     * for example :
     * {
     *     "name":"A",
     *     "gender":"Male",
     *     "phone":1231231231
     * }
     * we should expect 400 response
     * {
     *     "message": "Invalid Input!",
     *     "errorCount": 1,
     *     "errors": [
     *         {
     *             "errorField": "name",
     *             "rejectedValue": "A",
     *             "reason": "name should be at least 2 character and max 15 character"
     *         }
     *     ]
     * }
     * error count should be 1
     * "message": "Invalid Input!",
     * "errorField": "name"
     *  from the response
     */


    @Test
    public void postSpartanWithInvalidName() {

        //lets create a Spartan Object
        Spartan invalidSpartan=new Spartan("A","Female",1231231231l);

        given().log().uri()
                .contentType(ContentType.JSON)
                .body(invalidSpartan).
        when()
                .post("/spartans").
        then()
                .statusCode(400)
                .body("message", is("Invalid Input!"))
                .body("errorCount", is(1))
                .body("errors[0].errorField",is("name"));


    }


    /*   Tasks --Data Driven Test
    
        Create csv file under resources 
        
        name,gender,phone,expectedErrorCount
        A,Malez,1231231231,2
        ....
        ...
        ..
        .
        
        Make it @Parametirezed Test to check all condition in one Test Case with @CSVFileSource 
 
     */




    /*
     **
     *  Get One Valid Spartan ID from /spartans
     *  store this ID
     *  Create a new Spartan with 15 digit phone Number
     *
     *  Send a PUT request to update /spartans/{id}
     *      verfiy status code is 400
     *
     *
     */




    @Test
    public void spartanWithInvalidPhone() {

      // Get One valid spartan ID to update
       int lastID= get("/spartans").path("id[-1]");


      // Create new Spartan to update
        Spartan invalidSpartan=new Spartan("WrongNumber","Female",123456789l);

        given().log().uri()
                .contentType(ContentType.JSON)
                .pathParam("id", lastID)
                .body(invalidSpartan).
        when()
                .put("/spartans/{id}").prettyPeek().
        then()
                .statusCode(400);


    }


    /**
     *
     *
     * Create a new file called as phoneNumber
     *
     *      phone , statusCode
     *      123456789,400
     *      12345678912,204
     *      12345678912345,400
     *
     * Do parameterized test
     */


    @ParameterizedTest
    @CsvFileSource(resources = "/phoneNumber.csv",numLinesToSkip = 1)
    public void parametirezedTestPhone(long phone,int statusCode) {



        // Get One valid spartan ID to update
        int lastID= get("/spartans").path("id[-1]");


        // Create new Spartan to update
        Spartan invalidSpartan=new Spartan("WrongNumber","Female",phone);

        given().log().uri()
                .contentType(ContentType.JSON)
                .pathParam("id", lastID)
                .body(invalidSpartan).
                when()
                .put("/spartans/{id}").prettyPeek().
                then()
                .statusCode(statusCode);


        System.out.println("Phone number "+phone+" status Code is "+ statusCode);

    }
}
