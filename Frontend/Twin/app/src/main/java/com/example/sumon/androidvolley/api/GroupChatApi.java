package com.example.sumon.androidvolley.api;

import com.example.sumon.androidvolley.model.GroupChat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GroupChatApi {
    @GET("groupChat")
    Call<List<GroupChat>> GetAllGroupChat();

    @POST("groupChat")
    Call<GroupChat> PostGroupChatByBody(@Body GroupChat newChat);
}
