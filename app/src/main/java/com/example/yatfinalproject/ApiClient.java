package com.example.yatfinalproject;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL="https://simplifiedcoding.net/";
    public static Retrofit retrofit;

    static public Retrofit getClient(){

        if (retrofit==null){
             retrofit=new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;

    }
}