package com.example.inspiron.classpractise1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class UserDescActivity extends AppCompatActivity {

    private TextView tv_user;
    private User u;
    ArrayList<User> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_desc);
        tv_user = (TextView) findViewById(R.id.tv_userlist);

        list = new ArrayList<User>();

        list = getIntent().getParcelableArrayListExtra("userlist");


        StringBuilder sb = new StringBuilder();
        for (User u : list) {


            sb.append(u.toString());
            sb.append("\n");

        }

        tv_user.setText(sb.toString());

    }
}
