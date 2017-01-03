package com.example.inspiron.classpractice10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void doMagic(View view) {
        Intent in = new Intent();
        in.setAction("com.example.inspiron.classpractise1.newintent");
        startActivity(in);

    }
}
