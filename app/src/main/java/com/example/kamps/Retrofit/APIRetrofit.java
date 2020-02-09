package com.example.kamps.Retrofit;

import com.example.kamps.ui.slideshow.campItems;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIRetrofit {

    //API call for the data from the server
    //Camp API
    @GET("/1etovk")
    Call<List<campItems>> getPosts();

    //API call for the data to the server.

    //Fetch request for getting the posts from the server
    @POST("test")
    Call<post> sendPost();




}
