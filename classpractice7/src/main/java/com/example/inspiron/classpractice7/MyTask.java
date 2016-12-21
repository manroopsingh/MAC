package com.example.inspiron.classpractice7;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

/**
 * Created by INSPIRON on 21-Dec-16.
 */

public class MyTask extends AsyncTask<Integer, Integer, String> {


    private static String TAG = "Asynctask_TAG";
    private ProgressBar progressBar;


    public MyTask(ProgressBar progressBar) {
        this.progressBar = progressBar;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        Log.d(TAG, "onPreExecute: " + Thread.currentThread());
    }

    @Override
    protected String doInBackground(Integer... params) {
        Log.d(TAG, "doInBackground: " + Thread.currentThread());


        for (int i = 0; i < 50; i++) {

            Log.d(TAG, "commenceCountdown: " + i);
            publishProgress(i*2);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onPostExecute(String aVoid) {
        super.onPostExecute(aVoid);
        Log.d(TAG, "onPostExecute: " + Thread.currentThread());
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        progressBar.setProgress(values[0]);
        //Log.d(TAG, "onProgressUpdate: ");
    }


}
