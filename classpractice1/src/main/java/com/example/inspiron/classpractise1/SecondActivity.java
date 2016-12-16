package com.example.inspiron.classpractise1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
        name = (TextView) findViewById(R.id.TextView_Name);
        String myName = getIntent().getStringExtra("name");
        name.setText(myName);


        //populating the arraylsit for listview
        users = new ArrayList<>();
        users.add(new User("Manroop", "Singh"));
        users.add(new User("David","Jimenez"));
        users.add(new User("Martin","Osorio"));
        //setting the adapter
        ArrayAdapter<User> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, users);
        listView = (ListView) findViewById(R.id.lv_userlist);
        listView.setAdapter(arrayAdapter);

        //display a toast on selecting list item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),users.get(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });


        //parcelable

        User myUser = getIntent().getParcelableExtra("key");
        if(myUser != null) {
            Log.d(TAG, "onCreate: " + myUser.getFirstName() + myUser.getLastName());
            Toast.makeText(this, "1. Manroop Singh desplayed on the top", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "2. Check log.d onCreate in Android Monitor", Toast.LENGTH_SHORT).show();
        }




    }

    public void ResultBack(View view) {

        EditText et_result = (EditText) findViewById(R.id.et_a_forresult);
        Intent in = new Intent();
        in.putExtra("text", et_result.getText().toString());
        setResult(RESULT_OK, in);
        finish();
    }
}
