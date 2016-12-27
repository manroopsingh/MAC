package com.example.inspiron.classpractice9;

import com.example.inspiron.classpractice9.entities.ResultAPus;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by INSPIRON on 23-Dec-16.
 */

public class RetrofitMain {

    static final String BASE_URL = "https://api.github.com";
    public static void main(String[] args) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();


        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        GitHubEndpoints gitHubEndpoints
                = retrofit.create(GitHubEndpoints.class);
        Call<List<ResultAPus>> calllist = gitHubEndpoints.getRepos("manroopsingh ");

        try {
            List<ResultAPus> resultAPIS = calllist.execute().body();
            for (ResultAPus result: resultAPIS){
                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    interface GitHubEndpoints{

        @GET("/users/{username}/repos")
        Call<List<ResultAPus>> getRepos(@Path("username")String username);

    }

}
