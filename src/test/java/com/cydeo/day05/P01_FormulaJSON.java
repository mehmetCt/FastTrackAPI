package com.cydeo.day05;

import com.cydeo.pojo.Driver;
import com.cydeo.utility.FormulaTestBase;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class P01_FormulaJSON extends FormulaTestBase {

/*
- Send GET Request /drivers.json
- Create a POJO Class to get Driver as Object

        Print out first Driver Info
        Print out all Driver info
        Print out all driver given name if their nationality is Italian from above List

 */

    @Test
    public void getAllDrivers() {

        JsonPath jp = get("/drivers.json").prettyPeek().jsonPath();

        System.out.println("======Print out first Driver Info=========");

        Driver firstDriver = jp.getObject("MRData.DriverTable.Drivers[0]", Driver.class);

        System.out.println(firstDriver);
        System.out.println(firstDriver.getGivenName());
        System.out.println(firstDriver.getNationality());


        System.out.println("======Print out all Driver info=========");
        List<Driver> allDrivers = jp.getList("MRData.DriverTable.Drivers", Driver.class);
        System.out.println(allDrivers);


        System.out.println("====== Print out all driver given name if their nationality is Italian =========");
        for (Driver eachDriver : allDrivers) {
            if(eachDriver.getNationality().equals("Italian")){
                System.out.println(eachDriver.getGivenName());
            }
        }

        System.out.println("====== Print out all driver given name if their nationality is Italian IN ONE SHOT  =========");
        List<String> allItalians = jp.getList("MRData.DriverTable.Drivers.findAll {it.nationality=='Italian'}.givenName");
        System.out.println(allItalians);


    }
}
