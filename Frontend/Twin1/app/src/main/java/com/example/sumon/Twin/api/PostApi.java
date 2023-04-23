package com.example.sumon.Twin.api;

import com.example.sumon.Twin.model.Post;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostApi{

    @GET("users")
    Call<Post> getFirstPost();
}
