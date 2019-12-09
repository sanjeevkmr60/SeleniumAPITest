package com.apitesting.utils;

public enum EndpointURL {
    ADD_COUNTRY("/countries/details"),
    UPDATE_COUNTRY("/countries/update/details"),
    GET_COUNTRY_BY_ID("/country"),
    DELETE("/country"),
    GET_COUNTRIES("/country"),
    GET_DRUG("search=patient.drug.openfda.pharm_class_epc:\"nonsteroidal+anti-inflammatory+drug\"&count=patient" +
            ".reaction.reactionmeddrapt.exact");

   String resourcePath;

   EndpointURL(String resourcePath){
       this.resourcePath=resourcePath;
   }

   public String getResourcePath(){
       return this.resourcePath;
   }
    public String getResourcePath(String data){
        return this.resourcePath+data;
    }

}
