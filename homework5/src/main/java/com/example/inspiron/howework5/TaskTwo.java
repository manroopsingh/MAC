package com.example.inspiron.howework5;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by INSPIRON on 21-Dec-16.
 */

public class TaskTwo extends AsyncTask<Integer,Integer,String> {
    private static String TAG = "TaskTwo_TAG";

    private TextView textview;

    public TaskTwo(TextView textview) {
        this.textview = textview;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        textview.setText(String.valueOf(values[0]));
    }

    @Override
    protected String doInBackground(Integer... params) {

        for (int i = 0; i <= 10; i++) {
            Log.d(TAG, "@@@@@@@@@@@@@@" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(i);
        }

        return null;
    }
}
