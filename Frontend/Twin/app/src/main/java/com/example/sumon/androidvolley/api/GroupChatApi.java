package com.example.sumon.androidvolley.api;

import com.example.sumon.androidvolley.model.Event;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GroupChatApi {
    @GET("groupChat")
    Call<List<Event>> GetAllGroupChat();

    @POST("groupChat")
    Call<Event> PostGroupChatByBody(@Body Event newEvent);
}
