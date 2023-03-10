package com.example.twin.api;

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


    public static ProfileApi GetProfileApi(){
        return GetApiClientSeed().create(ProfileApi.class);
    }
    public static EventApi GetEventAPi(){
        return GetApiClientSeed().create(EventApi.class);
    }
}
