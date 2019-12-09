package com.apitesting.testscripts;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
            Assert.assertTrue(lastUpdated.equals("2019-11-30"));
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
}
