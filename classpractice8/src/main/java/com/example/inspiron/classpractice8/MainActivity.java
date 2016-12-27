package com.example.inspiron.classpractice8;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    OkHttpClient client = new OkHttpClient();
    private static final String TAG = "MainActivity";
    public static final String MY_KEY_VALUE = "ANY_VALUE";
    public static final String USER = "USER";
    public static final String PASSWORD = "PASSWORD";

    EditText et_username,et_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);

    }

    public void askPermissions(View view) {

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED) {
            //ask for it
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_CONTACTS},20);
        }
        else{
            //do action

            doMagicContacts();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 20:
                if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    //do the action
                    doMagicContacts();

                }else{
                    //permission was denied
                }
        }



    }

    private void doMagicContacts() {
        Cursor cursor = getContentResolver()
                .query(ContactsContract.Contacts.CONTENT_URI,
                        null,
                        null,
                        null,
                        null);

        if (cursor == null) {
            return;
        }

        cursor.moveToFirst();

        do {
            String name = cursor.getString(
                    cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            String id = cursor.getString(
                    cursor.getColumnIndex(ContactsContract.Contacts.NAME_RAW_CONTACT_ID));

            Cursor phones = getContentResolver()
                    .query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id,
                            null,
                            null);
            if (phones != null) {
                while (phones.moveToNext()) {
                    String phoneNumber = phones.getString(
                            phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    Log.d(TAG, "doMagicContacts: " + name + " " + phoneNumber);
                }
                phones.close();
            }

        } while (cursor.moveToNext());

        cursor.close();
    }

    public void startIntentService(View view) {
        Intent in = new Intent(this, DownloadService.class);
        in.putExtra(USER,et_username.getText().toString());
        in.putExtra(PASSWORD,et_password.getText().toString());
        in.putExtra(MY_KEY_VALUE,"asd");
        startService(in);


    }

    void  run(String url)  {
        Request request = new Request.Builder()
                .url(url)
                .build();

       client.newCall(request).enqueue(new Callback() {
           @Override
           public void onFailure(Call call, IOException e) {

           }

           @Override
           public void onResponse(Call call, Response response) throws IOException {
               Log.d(TAG, "onResponse: " + response.body().string());
           }
       });

    }

    public void runOkhttp(View view) throws IOException {

    }
}


