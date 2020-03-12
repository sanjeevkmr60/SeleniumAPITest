package com.apitesting.testscripts;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.apitesting.test.APIDataProvider;
import com.apitesting.test.GetFDI;
import com.apitesting.test.Result;
import com.apitesting.utils.EndpointURL;
import com.apitesting.utils.URL;
import com.apitesting.webservices.methods.Webservices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.response.Response;

public class TC_001 {
    Response response;

    @BeforeClass
    public void setUp(){

    }

   @Test
    public void verifyGetFDI(){
        Gson gson= new GsonBuilder().create();
        GetFDI getFDI;
        String url= URL.fixURLFDI+ EndpointURL.GET_DRUG.getResourcePath();
        System.out.println(url);
        response= Webservices.Get(url);
        //System.out.println(response.getBody().asString());
        //Assert.assertTrue(response.getBody().asString().contains("DRUG INEFFECTIVE"));
        if(response.statusCode()==200){
           getFDI=gson.fromJson(response.getBody().asString(),GetFDI.class);
           String licence=getFDI.getMeta().getLicense();
           Assert.assertTrue(licence.equals("https://open.fda.gov/license/"));
            String lastUpdated = getFDI.getMeta().getLastUpdated();
            //Assert.assertTrue(lastUpdated.equals("2019-11-30"));
            String terms = getFDI.getMeta().getTerms();
            Assert.assertTrue(terms.equals("https://open.fda.gov/terms/"));
            String disclaimer = getFDI.getMeta().getDisclaimer();
            Assert.assertTrue(disclaimer.contains("Terms of Service"));

            for (Result fdi:getFDI.getResults()){
                System.out.println(fdi.getTerm());
                Assert.assertTrue(fdi.getTerm().equals("DRUG INEFFECTIVE"));
                break;
            }
        }
    }

    @Test
    public void ListofUsers(){
        String url= URL.getURL+ EndpointURL.GET_USERS.getResourcePath();
        System.out.println(url);
        response= Webservices.Get(url);
        System.out.println ( response.getBody().asString());
        Assert.assertTrue (response.getBody ().asString ().contains ("michael.lawson@reqres.in"));
    }

    @Test(dataProviderClass = APIDataProvider.class, dataProvider = "addUsers")
    public void verifyPostCreate(String json){
        String url= URL.getURL+ EndpointURL.POST_CREATE_USER.getResourcePath();
        System.out.println(url);
        response= Webservices.Post (url,json);
        System.out.println ( response.getBody().asString());
        if(response.statusCode ()==201){
            System.out.println (response.statusCode () );
            System.out.println ("User is created" );
        }
    }

    @Test(dataProviderClass = APIDataProvider.class, dataProvider = "updateUser")
    public void verifyUpdateUser(String userUpdate){
        String url= URL.getURL+ EndpointURL.UPADTE_USER.getResourcePath();
        System.out.println(url);
        response= Webservices.Put (url,userUpdate);
        System.out.println ( response.getBody().asString());
        if(response.statusCode ()==200){
            System.out.println (response.statusCode () );
            System.out.println ("User is updated" );
        }
    }

    @Test
    public void verifyDeleteUser(){
        String url= URL.getURL+ EndpointURL.DELETE_USER.getResourcePath();
        System.out.println(url);
        response= Webservices.Delete (url);
        System.out.println ( response.getBody().asString());
        if(response.statusCode ()==204){
            System.out.println (response.statusCode () ); 
            System.out.println ("User is Deleted" );
        }
    }

   @Test(dataProviderClass = APIDataProvider.class, dataProvider = "registerSuccess")
    public void verifyPostResgister(String json){
        String url= URL.getURL+ EndpointURL.POST_REGISTER.getResourcePath();
        System.out.println(url);
        response= Webservices.Post (url,json);
        System.out.println ( response.getBody().asString());
        if(response.statusCode ()==200){
            System.out.println (response.statusCode () );
            System.out.println ("User is Registered" );
        }
    }
}
