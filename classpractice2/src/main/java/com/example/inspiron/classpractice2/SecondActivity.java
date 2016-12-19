package com.example.inspiron.classpractice2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class SecondActivity extends AppCompatActivity implements GreenFragment.MyCallBack{


    private static final String TAG ="SecondActivityTAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



    }

    public void AddGreen(View view) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.a_second_green, new GreenFragment(), "Green_Fragment")
                .addToBackStack("Green")
                .commit();

    }

    public void AddRed(View view) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.a_second_red, new RedFragment(), "Red_Fragment")
                .addToBackStack("Red")
                .commit();
    }

    public void RemoveRed(View view) {
        Fragment fragment = getSupportFragmentManager()
                .findFragmentByTag("Red_Fragment");

        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .remove(fragment)
                    .commit();
        }


    }


    @Override
    public void someoneClicked(String message) {
        RedFragment redFragment = (RedFragment)getSupportFragmentManager()
                .findFragmentByTag("Red_Fragment");
        redFragment.updateText(message);



        Log.d(TAG, "someoneClicked: "  + message);
    }
}
