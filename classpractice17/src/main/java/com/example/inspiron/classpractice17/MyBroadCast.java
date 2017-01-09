package com.example.inspiron.classpractice17;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by INSPIRON on 09-Jan-17.
 */

public class MyBroadCast extends BroadcastReceiver {
    TextView textView;
    @Override
    public void onReceive(Context context, Intent intent) {

        intent.getExtras();
        String s = intent.getStringExtra("s");
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();

        
    }
}
