package com.example.sumon.androidvolley.api;

import com.example.sumon.androidvolley.model.Login;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LoginApi {
    @GET("users/login")
    Call<List<Login>> GetLoginCheck();

    @POST("users/login")
    Call<Login> PostLoginRequest(@Body Login login);

}
