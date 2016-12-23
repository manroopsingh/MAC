package com.example.inspiron.howework5;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by INSPIRON on 21-Dec-16.
 */

public class TaskOne extends AsyncTask<Integer, Integer, String> {


    private static String TAG = "TaskOne_Tag:";
    private TextView textView;

    public TaskOne(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Integer... params) {

        for (int i = 0; i <= 10; i++) {
            Log.d(TAG, "<<<<<<<<<<>>>>>>>>>" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(i);
        }

        return null;
    }

    @Override
    protected void onPostExecute(String aVoid) {
        super.onPostExecute(aVoid);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        textView.setText(String.valueOf(values[0]));

    }
}
