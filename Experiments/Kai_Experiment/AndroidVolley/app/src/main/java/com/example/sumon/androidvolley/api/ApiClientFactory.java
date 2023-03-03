package com.example.sumon.androidvolley.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientFactory {
    static Retrofit apiClientSeed = null;

    static Retrofit GetApiClientSeed() {

        if (apiClientSeed == null) {
            apiClientSeed = new Retrofit.Builder()
                    .baseUrl("http://coms-309-015.class.las.iastate.edu:8080/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return apiClientSeed;
    }


    public static PostApi GetPostApi(){
        return GetApiClientSeed().create(PostApi.class);
    }

    public static PhotoApi GetPhotoApi(){
        return GetApiClientSeed().create(PhotoApi.class);
    }
    public static TriviaApi GetTrivaApi(){
        return GetApiClientSeed().create(TriviaApi.class);
    }
}
