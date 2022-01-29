package com.cydeo.day05;

import com.cydeo.pojo.Driver;
import com.cydeo.utility.FormulaTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class P02_FormulaXML  extends FormulaTestBase {


     /*
    - Send GET Request /drivers.json
           // first Driver Given Name
           // all Drivers Given Name
           // Print out all driver given name if their nationality is Italian

     */

    @Test
   public  void getAllDrivers() {


        XmlPath xp = get("/drivers").xmlPath();

        // first Driver Given Name
        String firstDriverName = xp.getString("MRData.DriverTable.Driver[0].GivenName");
        System.out.println(firstDriverName);


        // all Drivers Given Name
        List<String> listOfName = xp.getList("MRData.DriverTable.Driver.GivenName");
        System.out.println(listOfName);


        // print out first driver driverId attribute

        String firstDriverID = xp.getString("MRData.DriverTable.Driver[0].@driverId");
        System.out.println(firstDriverID);

        // print out all driver driverId attribute
        List<String> driverIDs = xp.getList("MRData.DriverTable.Driver.@driverId");
        System.out.println(driverIDs);

        System.out.println("====== Print out all driver given name if their nationality is Italian IN ONE SHOT  =========");
        List<String> allItalians = xp.getList("MRData.DriverTable.Driver.findAll {it.Nationality=='Italian'}.GivenName");
        System.out.println(allItalians);

    }
}
