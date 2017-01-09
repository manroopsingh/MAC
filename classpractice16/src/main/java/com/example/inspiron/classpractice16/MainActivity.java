package com.example.inspiron.classpractice16;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver broadcastReceiver;
    IntentFilter intentFilter;
    EditText editText;
    Intent in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        intentFilter = new IntentFilter();
//        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
//
//        broadcastReceiver = new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                Toast.makeText(context, "Airplane mode", Toast.LENGTH_SHORT).show();
//            }
//        };

        editText = (EditText) findViewById(R.id.et_1);

        in = new Intent();
        in.setAction("hello");
        in.putExtra("s", editText.getText().toString());


    }

    @Override
    protected void onResume() {
        super.onResume();

        //this.registerReceiver(broadcastReceiver,intentFilter);

    }

    @Override
    protected void onStop() {
        super.onStop();

        //unregisterReceiver(broadcastReceiver);
    }

    public void sendBroadcast(View view) {
        sendBroadcast(in);
    }
}
