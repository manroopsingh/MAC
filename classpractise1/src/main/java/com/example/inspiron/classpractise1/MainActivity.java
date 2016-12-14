package com.example.inspiron.classpractise1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView textView;

    EditText editText1;
    EditText editText2;

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate is called");

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    public void SumIt(View view) {

        textView = (TextView) findViewById(R.id.TextView_result);

        editText1 = (EditText) findViewById(R.id.EditText1);
        editText2 = (EditText) findViewById(R.id.EditText2);

        int sum = Integer.parseInt(editText1.getText().toString()) + Integer.parseInt(editText2.getText().toString());
        textView.setText(Integer.toString(sum));

        Toast.makeText(getApplicationContext(),"Updated", Toast.LENGTH_SHORT).show();
    }

    public void MultiplyIt(View view) {

        textView = (TextView) findViewById(R.id.TextView_result);

        editText1 = (EditText) findViewById(R.id.EditText1);
        editText2 = (EditText) findViewById(R.id.EditText2);

        int sum = Integer.parseInt(editText1.getText().toString()) * Integer.parseInt(editText2.getText().toString());
        textView.setText(Integer.toString(sum));

        Toast.makeText(getApplicationContext(),"Updated", Toast.LENGTH_SHORT).show();
    }
}
