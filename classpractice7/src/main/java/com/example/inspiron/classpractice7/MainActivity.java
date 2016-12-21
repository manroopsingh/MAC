package com.example.inspiron.classpractice7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main_TAG";
    private TextView textView;

    private static final String MY_KEY = "MY_KEY_BUNDLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.main_tv);

        if(savedInstanceState == null) {
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
        outState.putString(MY_KEY,str);

        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String str =savedInstanceState.getString(MY_KEY,"");
        textView.setText(str);


    }

    public void commenceCountdown(View view) throws InterruptedException {

        for (int i = 0; i < 50; i++) {
            Log.d(TAG, "commenceCountdown: " + i);
            Thread.sleep(1000);
        }
    }

    public void printLog(View view) {
    }
}
