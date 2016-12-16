package com.example.inspiron.classpractise1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddUserActivity extends AppCompatActivity {


    private EditText firstName;
    private EditText lastName;
    private ArrayList<User> al;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        firstName = (EditText) findViewById(R.id.et_firstname);
        lastName = (EditText) findViewById(R.id.et_lastname);


         al= new ArrayList<User>();

    }

    public void AddUserToArray(View view) {

        String fname,lname;
        fname = firstName.getText().toString();
        lname = lastName.getText().toString();

        //Using User class for parcelable
        User u = new User(fname,lname);
        //List<String> list = Arrays.asList( u.getFirstName() ,u.getLastName() );

        //Creating a new array list

        al.add(u);
        Toast.makeText(this,"User Added",Toast.LENGTH_SHORT).show();

        firstName.setText("");
        lastName.setText("");


    }

    public void SendUserToAct(View view) {

        Intent in = new Intent(this, UserDescActivity.class);
        in.putExtra("userlist", al);

        startActivity(in);




    }
}
