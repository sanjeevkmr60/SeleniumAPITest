package com.apitesting.TestAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class TestWeatherAPI {

    @Test(priority = 0)
    public void getWeatherInfoBangaloreCityWithValidData()
    {
        RestAssured.baseURI="https://api.fda.gov/drug/event.json";
       RequestSpecification requestSpecification=
                RestAssured.given().param("search", "patient.drug.openfda.pharm_class_epc:\"nonsteroidal+anti" +
                        "-inflammatory+drug\"").param("count", "patient.reaction.reactionmeddrapt.exact");

        String responseBody = requestSpecification.get().getBody().asString();

        System.out.println("response is  = " + responseBody);



    }
}
