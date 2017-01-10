package com.example.inspiron.classpractice15;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by INSPIRON on 10-Jan-17.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    public static final String TAG = "FirebaseMessage: ";
    private Intent in,in1;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // ...

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
            if(remoteMessage.getData().get("Hello")!=null){

                String value = remoteMessage.getData().get("Hello");
                Log.d(TAG, "onMessageReceived: "+value);

                in = new Intent();
                in.setAction("Hello");
                in.putExtra("Key",value);
                sendBroadcast(in);
            }
            if(remoteMessage.getData().get("Hola")!=null){

                String value = remoteMessage.getData().get("Hola");
                Log.d(TAG, "onMessageReceived: "+value);
                in1 = new Intent();
                in.setAction("Hola");
                in.putExtra("Key1",value);
                sendBroadcast(in);
            }


        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }


}
