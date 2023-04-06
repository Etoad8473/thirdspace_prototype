package com.example.sumon.androidvolley.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Personality {

    @POST("personality")
    Call<Personality> PostEventByBody(@Body Personality newPersonality);
}
