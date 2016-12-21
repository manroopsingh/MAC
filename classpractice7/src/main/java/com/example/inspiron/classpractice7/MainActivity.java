package com.example.inspiron.classpractice7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main_TAG";
    private TextView textView;
    private ProgressBar progressBar;


    private static final String MY_KEY = "MY_KEY_BUNDLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.main_tv);
        progressBar = (ProgressBar) findViewById(R.id.main_progress);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(new BlankFragment(), "Fragment_TAG")
                    .commit();
        }
    }

    public void doMagic(View view) {
        textView.setText("Kidaan");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        String str = textView.getText().toString();
        outState.putString(MY_KEY, str);

        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String str = savedInstanceState.getString(MY_KEY, "");
        textView.setText(str);

    }


    public void commenceCountdown(View view) throws InterruptedException {

        new MyTask(progressBar).execute();



    }

    public void printLog(View view) {
        Log.d(TAG, "printLog: I'm Smart");

    }


    public void startService(View view) {

        Intent in = new Intent(this, MyService.class);
        startService(in);



    }
    public void stopService(View view) {

        Intent in = new Intent(this, MyService.class);
        stopService(in);



    }
}
