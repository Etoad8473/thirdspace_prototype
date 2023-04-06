package com.example.sumon.androidvolley.api;

import com.example.sumon.androidvolley.model.Match;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MatchApi {
    @GET("matches")
    Call<List<Match>> GetAllMatches();

    @POST("users/{id}")
    Call<Match> PostEventByPath(@Path("q") String question, @Path("a") String answer);

}
