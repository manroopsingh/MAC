package com.example.inspiron.homework6;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class GetDataService extends IntentService {

    private static String TAG = "GetDataservice_TAG";
    OkHttpClient client = new OkHttpClient();
    private static String URL="http://www.mocky.io/v2/57a4dfb40f0000821dc9a3b8";
    String httpresponse, name, password;
    Response urlResponse;

    public GetDataService() {
        super("GetDataService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        try {
            httpresponse = run(URL);

            List<User> users = null;


            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(httpresponse);
            TypeFactory tf = objectMapper.getTypeFactory();
            JavaType listtofobject = tf.constructCollectionType(ArrayList.class,User.class);
            users = objectMapper.readValue(root.traverse(), listtofobject);

            for(User user: users) {
                Log.d(TAG, "onHandleIntent: " + user.getName());
            }
           // Log.d(TAG, "onHandleIntent: "+ response.body().string());
//            for (User user: response){
//                Log.d(TAG, "onHandleIntent: "+ user.getName() + user.getPassword());
//
////                name = intent.getStringExtra(MainActivity.USER);
////                password = intent.getStringExtra(MainActivity.PASSWORD);
////                if(name.equals(user.getName()) && password.equals(user.getPassword())){
////
////                    Toast.makeText(getApplicationContext(),"Login",Toast.LENGTH_SHORT).show();
////                }
//
//            }


        } catch (IOException e) {
            e.printStackTrace();
        }
//        String str = intent.getStringExtra(MainActivity.MY_KEY_VALUE);
//        Log.d(TAG, "onHandleIntent: " + str + Thread.currentThread()+ response) ;




    }



    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        urlResponse = client.newCall(request).execute();


        return urlResponse.body().string();
    }
}
