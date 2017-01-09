package com.example.inspiron.classpractice16;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by INSPIRON on 09-Jan-17.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
    }
}
