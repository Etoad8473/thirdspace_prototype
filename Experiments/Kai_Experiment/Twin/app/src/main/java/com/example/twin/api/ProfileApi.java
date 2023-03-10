package com.example.twin.api;

import com.example.twin.model.Profile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ProfileApi {

    //return latest append user
    @GET("user")
    Call<Profile> GetLatestProfile();

    //return all users in database
    @GET("user")
    Call<List<Profile>> GetAllProfile();

    @POST("users/{id}")
    Call<Profile> PostProfileByPath(@Path("q") String question, @Path("a") String answer);

    @POST("users")
    Call<Profile> PostProfileByBody(@Body Profile newProfile);
}
