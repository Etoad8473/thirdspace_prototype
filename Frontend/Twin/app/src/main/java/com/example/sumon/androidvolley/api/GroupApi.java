package com.example.sumon.androidvolley.api;

import com.example.sumon.androidvolley.model.Group;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GroupApi {
    @GET("group")
    Call<List<Group>> GetAllGroups();

    @GET("group/{groupId}")
    Call<List<Group>> GetAGroup(@Path("groupId") int groupId);

    @POST("group")
    Call<Group> PostCreateGroup(@Body Group newGroup);

    @POST("group/addUser")
    Call<Group> PostNewUsers(@Body Group newUsers);

}
