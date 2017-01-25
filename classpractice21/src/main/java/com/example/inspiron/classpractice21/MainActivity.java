package com.example.inspiron.classpractice21;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG:";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = RetroFitHelper.Factory.create();
        RetroFitHelper.GithubService service = retrofit.create(RetroFitHelper.GithubService.class);
        Call<GithubProfile> call = service.getProfile("manroopsingh");

        call.enqueue(new Callback<GithubProfile>() {

            @Override
            public void onResponse(Call<GithubProfile> call, Response<GithubProfile> response) {
                Log.d(TAG, "onResponse: "+ response.body().toString());
            }

            @Override
            public void onFailure(Call<GithubProfile> call, Throwable t) {

            }
        });




    }
}
