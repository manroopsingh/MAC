package com.example.inspiron.classpractice21;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by INSPIRON on 24-Jan-17.
 */

public class RetroFitHelper {

    public static class Factory {
        private static final String BASE_URL = "https://api.github.com";

        public static Retrofit create() {
            return new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
    }

    public interface GithubService{

//        @GET("/users/{user}/repos")
//        Call<List<ResultAPI>> getRepos(@Path("user") String user);

        @GET("/users/{user}")
        Call<GithubProfile> getProfile(@Path("user") String user);



    }

}
