package com.example.ravinderreddy.listfragmentstate;

import com.google.gson.JsonArray;

import org.json.JSONArray;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Ravinder Reddy on 03-03-2017.
 */
public interface Apiservice
{
    @GET("/json/movies.json")
    public void myMeth(Callback<JsonArray> callback);
}
