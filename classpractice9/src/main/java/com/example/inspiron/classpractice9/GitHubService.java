package com.example.inspiron.classpractice9;

import com.example.inspiron.classpractice9.entities.ResultAPus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static com.example.inspiron.classpractice9.RetrofitMain.BASE_URL;

/**
 * Created by INSPIRON on 23-Dec-16.
 */

public interface GitHubService {

    @GET("/users/{username}/repos")
    Call<List<ResultAPus>> getRepos(@Path("username")String username);



    public class Factory{

        public GitHubService create(){
            return new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(GitHubService.class);

        }
    }
}
