package com.example.inspiron.classpractice8;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class DownloadService extends IntentService {

    private static String TAG = "Downloadservice_TAG";
    OkHttpClient  client = new OkHttpClient();
    private static String URL="http://www.mocky.io/v2/57a4dfb40f0000821dc9a3b8";
    String response, name, password;

    public DownloadService() {
        super("DownloadService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {

        try {
            response = run(URL);

            Gson gson = new Gson();

            Type listtype = new TypeToken<List<User>>(){

            }.getType();

            List<User> users = gson.fromJson(response, listtype);

            for (User user: users){
               // Log.d(TAG, "onHandleIntent: "+ user.getName() + user.getPassword());

                name = intent.getStringExtra(MainActivity.USER);
                password = intent.getStringExtra(MainActivity.PASSWORD);
                if(name.equals(user.getName()) && password.equals(user.getPassword())){

                    Log.d(TAG, "onHandleIntent: Login");
                   // Toast.makeText(getApplicationContext(),"Login",Toast.LENGTH_SHORT).show();
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = intent.getStringExtra(MainActivity.MY_KEY_VALUE);
       // Log.d(TAG, "onHandleIntent: " + str + Thread.currentThread()+ response) ;




    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: " + Thread.currentThread());
    }


    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();

        return response.body().string();
    }




}