package com.apitesting.test;

import java.util.ArrayList;
import java.util.List;
import com.apitesting.test.Result;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetFDI {

   @SerializedName("results")
   @Expose
    private List<Result> results = new ArrayList<Result>();

   @SerializedName("meta")
  @Expose
    private Meta meta ;


    public Meta getMeta() {
        return meta;
    }

    public void setMeta(final Meta meta) {
        this.meta = meta;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
