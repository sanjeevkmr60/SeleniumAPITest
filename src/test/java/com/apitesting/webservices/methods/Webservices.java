package com.apitesting.webservices.methods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Webservices {

    public static Response Post(String strURI,String strJson){
        RequestSpecification requestSpecification= RestAssured.given().body(strJson);
        requestSpecification.contentType(ContentType.JSON);
        Response response=requestSpecification.post(strURI);
        return response;
    }

    public static Response Get(String strURI,String strJson){
        RequestSpecification requestSpecification= RestAssured.given().body(strJson);
        requestSpecification.contentType(ContentType.JSON);
        Response response=requestSpecification.get(strURI);
        return response;
    }


    public static Response Get(String strURI){
        RequestSpecification requestSpecification= RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        Response response=requestSpecification.get(strURI);
        return response;
    }

    public static Response Put(String strURI,String strJson){
        RequestSpecification requestSpecification= RestAssured.given().body(strJson);
        requestSpecification.contentType(ContentType.JSON);
        Response response=requestSpecification.post(strURI);
        return response;
    }

    public static Response Delete(String strURI){
        RequestSpecification requestSpecification= RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        Response response=requestSpecification.delete(strURI);
        return response;
    }
}
