package com.cydeo.day04;

import com.cydeo.pojo.Category;
import com.cydeo.utility.APIUtils;
import com.cydeo.utility.LibraryTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class P03_Library extends LibraryTestBase {

     /*
     1.  get("/get_book_categories")

    Task 1 : category types (don't use POJO)
         send a request as a librarian
         verify status code 200
         verify content type json
         verify each object in the response array contains id and name

    */


    @Test
    public void getBookCategories() {

        String token = APIUtils.getTokenLibrary();

        JsonPath jsonPath = given().log().uri()
                .header("x-library-token", token).
                when()
                .get("/get_book_categories").prettyPeek().
                then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", everyItem(notNullValue()))
                .body("name", everyItem(notNullValue()))
                .extract().jsonPath();

        List<String> nameList = jsonPath.getList("name");
        System.out.println(nameList);




        //Lets use POJO

        List<Category> categoryList = jsonPath.getList("", Category.class);

        System.out.println(categoryList);


    }
}
