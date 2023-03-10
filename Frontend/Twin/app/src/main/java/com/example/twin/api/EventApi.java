package com.example.twin.api;

import com.example.twin.model.Event;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface EventApi {
    @GET("event")
    Call<List<Event>> GetAllEvent();

    @POST("users/{id}")
    Call<Event> PostEventByPath(@Path("q") String question, @Path("a") String answer);

    @POST("event")
    Call<Event> PostEventByBody(@Body Event newEvent);
}

