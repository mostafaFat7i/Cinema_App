package com.example.yatfinalproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("demos/marvel/")
    public Call<List<MoveModel>> getMove();
}
