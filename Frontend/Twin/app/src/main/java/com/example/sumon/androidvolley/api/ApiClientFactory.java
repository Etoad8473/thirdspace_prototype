package com.example.sumon.androidvolley.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author kaiheng
 */
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
    public static EventApi GetEventApi(){
        return GetApiClientSeed().create(EventApi.class);
    }
    public static GroupChatApi GetGroupChatApi(){return GetApiClientSeed().create(GroupChatApi.class);}
    public static MatchApi GetMatchApi(){return  GetApiClientSeed().create(MatchApi.class);}
    public static PersonalityApi GetPersonalityApi(){return GetApiClientSeed().create(PersonalityApi.class);}
}
