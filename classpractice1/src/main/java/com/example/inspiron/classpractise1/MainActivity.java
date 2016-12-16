package com.example.inspiron.classpractise1;

import android.content.Intent;
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

        Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
    }

    public void MultiplyIt(View view) {

        textView = (TextView) findViewById(R.id.TextView_result);

        editText1 = (EditText) findViewById(R.id.EditText1);
        editText2 = (EditText) findViewById(R.id.EditText2);

        int sum = Integer.parseInt(editText1.getText().toString()) * Integer.parseInt(editText2.getText().toString());
        textView.setText(Integer.toString(sum));

        Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
    }

    public void GoToActivity(View view) {

        String name = "Manroop Singh";
        Intent in = new Intent(this, SecondActivity.class);
        in.putExtra("name", name);

        User user = new User("Manroop", "Singh");
        in.putExtra("key", user);

        startActivity(in);

    }

    public void DisplayEt(View view) {

        EditText et = (EditText) findViewById(R.id.et_a);
        String et_text = et.getText().toString();
        Intent in = new Intent(this, SecondActivity.class);
        in.putExtra("name", et_text);
        startActivity(in);


    }


    public void ActforResult(View view) {

        Intent in = new Intent(this, SecondActivity.class);
        startActivityForResult(in,2);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Toast.makeText(this, "Back",Toast.LENGTH_LONG).show();

        switch(requestCode){
            case 2:
                TextView tc_result = (TextView) findViewById(R.id.tv_actforresult);
                tc_result.setText(data.getStringExtra("text"));
        }

    }

    public void NewUserActivity(View view) {

        Intent in = new Intent(this,AddUserActivity.class);
        startActivity(in);

    }
}
