package com.example.inspiron.classpractice17;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver broadcastReceiver;
    IntentFilter intentFilter;

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.tv_1);

        intentFilter = new IntentFilter();
        intentFilter.addAction("hello");
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String s = intent.getStringExtra("s");
                textView.setText(s);

            }
        };


    }

    @Override
    protected void onStart() {
        super.onStart();

        registerReceiver(broadcastReceiver, intentFilter);
    }
}
