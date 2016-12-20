package com.example.inspiron.classpractice3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTag:";
    private TextView textview;

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "onReceive: ");

            textview.setText(intent.getStringExtra("Edittext"));


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);

        textview = (TextView) findViewById(R.id.a_main_tv);
        LocalBroadcastManager
                .getInstance(this)
                .registerReceiver(broadcastReceiver,new IntentFilter("My_Action"));



    }

    @Subscribe
    public void getInfoFragment(ManroopEvent manroopEvent){
        Log.d(TAG, "getInfoFragment: " + manroopEvent.getMessage());

        textview.setText(manroopEvent.getMessage());



    }
}
