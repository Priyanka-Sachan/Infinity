package com.example.kamps.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIRetrofit {

    //API call for the data from the server
    @GET("posts")
    Call<List<post>> getPostFromServer();

    //API call for the data to the server.
    @POST("test")
    Call<post> sendPost();



}
