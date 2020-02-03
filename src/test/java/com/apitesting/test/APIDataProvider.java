package com.apitesting.test;

import org.testng.annotations.DataProvider;

public class APIDataProvider {
    @DataProvider(name="addUsers")
    public static Object[][] addUsers(){
      String strJson="{\n" +
              "    \"name\": \"morpheus\",\n" +
              "    \"job\": \"leader\"\n" +
              "}";
        return new Object[][]{{strJson}};
    }

    @DataProvider(name="updateUser")
    public static Object[][] updateUser(){
        String strJson="{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";
        return new Object[][]{{strJson}};
    }

    @DataProvider(name="registerSuccess")
    public static Object[][] registerSuccess(){
        String strJson="{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}";
        return new Object[][]{{strJson}};
    }
}
