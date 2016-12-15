package com.example.inspiron.classpractise1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivityTAG_";
    TextView name;
    ArrayList<User> users;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        //getIntent and display from edittext from main activity
//        name = (TextView) findViewById(R.id.TextView_Name);
//        String myName = getIntent().getStringExtra("name");
//        name.setText(myName);

        users = new ArrayList<>();
        users.add(new User("Manny", "Singh"));


        ArrayAdapter<User> arrayAdapter = new ArrayAdapter<>(this, R.layout.simple_list_item1, users);
        listView = (ListView) findViewById(R.id.lv_userlist);

        listView.setAdapter(arrayAdapter);


        //parcelable
//
//        User myUser = getIntent().getParcelableExtra("key");
//        Log.d(TAG, "onCreate: " + myUser.getFirstName() + myUser.getLastName());

        //set result for returning to main activity




    }

    public void ResultBack(View view) {

        EditText et_result = (EditText) findViewById(R.id.et_a_forresult);
        Intent in = new Intent();
        in.putExtra("text", et_result.getText().toString());
        setResult(RESULT_OK, in);
        finish();
    }
}
