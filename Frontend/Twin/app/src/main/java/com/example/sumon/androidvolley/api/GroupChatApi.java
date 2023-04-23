package com.example.sumon.androidvolley.api;

import com.example.sumon.androidvolley.model.GroupChat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
/**
 * @author kaiheng
 */
public interface GroupChatApi {
    @GET("message")
    Call<List<GroupChat>> GetAllGroupChat();

    @POST("message")
    Call<GroupChat> PostGroupChatByBody(@Body GroupChat newChat);
}
